
package fi.asteroidi.peli;

import fi.asteroidi.domain.Alus;
import fi.asteroidi.domain.Asteroidi;
import fi.asteroidi.gui.Update;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import fi.asteroidi.domain.Ammus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 * Luokka toimii pelialustana (pelin säännöt tänne).
 * @author mikaelpa.
 */


public class Asteroids extends Timer implements ActionListener {
    private final int leveys;
    private final int korkeus;
    private final Alus alus;
    private final ArrayList<Asteroidi> asteroidit;
    private Update update;
    private int i;
    /**
     * Tekee uuden Alus- olion ja sijoittaa sen pelilaudan keskelle
     * Tekee myös uuden asteroidilistan ja sijoittaa sinne x määrän asteroideja.
     * @param korkeus pelinlaudan korkeus.
     * @param leveys pelilaudan leveys.
     */
    public Asteroids(int korkeus, int leveys) {
        super(10, null); // päivitetään joka 10:s millisekunti. //
        this.asteroidit = new ArrayList<>();
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.alus = new Alus(korkeus / 2 , leveys / 2);
        for (int i = 0; i < 20; i++) {
            Asteroidi uusi = new Asteroidi();
            asteroidit.add(uusi);
        }
        addActionListener(this);
        setInitialDelay(1000);
        
    }
    /**
     * Palautetaan pelin asteroidit.
     * lista
     * @return palautetaan asteroidilista
     */
    public ArrayList<Asteroidi> asteroidiLista() {
        return this.asteroidit;
    }
    
    
    public void setUpdate(Update update) {
        this.update = update;
    }
    
    public Alus getAlus() {
        return this.alus;
    }
    
    public int getLeveys() {
        return this.leveys;
    }
    
    public int getKorkeus() {
        return this.korkeus;
    }
    

    /**
     * Pelin peruslogiikka tänne, eli mitää tapahtuu jos esim alus törmää asteroidiin
     * Metodi käydään läpi joka päivityksellä.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (alus.liikkuu) {
            alus.kiihdyta(alus.getVanhaKulma());
        }

        if (alus.ampuu) {
            Ammus ammus = new Ammus(alus.getX(), alus.getY());
            ammus.kaanny(alus.getKulma());
            alus.ammukset.add(ammus);
        }
        for (Ammus ammus : alus.ammukset) {
            ammus.liiku(ammus.getKulma());
            ammus.liiku(ammus.getKulma());
            ammus.liiku(ammus.getKulma());
        }
        alus.ampuu = false;
        if (alus.kaantyyOikealle) {
            alus.kaanny(0.05);
        }
        if (alus.kaantyyVasemmalle) {
            alus.kaanny(-0.05);
        }

        if (alus.getX() > leveys + 1) {
            alus.setX(0);
        }
        if (alus.getX() < -1) {
            alus.setX(leveys);
        }
        if (alus.getY() > korkeus + 1) {
            alus.setY(0);
        }
        if (alus.getY() < -1) {
            alus.setY(korkeus);
        }

        if (i % 3 == 0) { // Tehdään joka kolmas päivitys, muutetaan kun keksin miten lisään nopeuden
            asteroidit.forEach((asteroidi) -> {
                if (asteroidi.onElossa) {
                    asteroidi.liiku(asteroidi.getSuunta());
                    if (asteroidi.getX() > leveys + 1) {
                        asteroidi.setX(0);
                    }

                    if (asteroidi.getY() > korkeus + 1) {
                        asteroidi.setY(0);
                    }

                    if (asteroidi.getX() < -1) {
                        asteroidi.setX(leveys);
                    }

                    if (asteroidi.getY() < -1) {
                        asteroidi.setY(korkeus);
                    }

                    if (alus.osuu(asteroidi)) {
                        System.out.println("Törmäys");
                    }
                    for (Ammus ammus : alus.ammukset) {
                        if (ammus.osuu(asteroidi)) {
                            asteroidi.onElossa = false;
                            asteroidi.setX(600);
                            asteroidi.setY(600);   //Viedään asteroidi pois pelilaudalta, jos ammus osuu.

                        }
                    }
                }
            });

        }
        i++;

        update.update();

    }
    
}
