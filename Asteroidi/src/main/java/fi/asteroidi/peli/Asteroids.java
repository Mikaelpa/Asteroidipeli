
package fi.asteroidi.peli;

import fi.asteroidi.domain.Alus;
import fi.asteroidi.domain.Asteroidi;
import fi.asteroidi.gui.Update;
import fi.asteroidi.domain.Ammus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;
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
    private int kerroin;
    private int taso;
    private int elamat;
    private int pisteet;
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
        for (int a = 0; a < 10; a++) {
            Asteroidi uusi = new Asteroidi();
            asteroidit.add(uusi);
        }
        this.taso = 1;
        this.kerroin = 3;
        this.elamat = 5;
        addActionListener(this);
       
        
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
    
    public int getTaso() {
        return this.taso;
    }
    
    public int getElamat() {
        return this.elamat;
    }
    public int getPisteet() {
        return this.pisteet;
    }
    /**
     * Palautetaan alus keskelle näyttöä.
     * Laitetaan alus pysymään paikoillaan.
     */
    public void palautaAlusKeskelle() {
        this.alus.liikkuu = false;
        this.alus.setX(korkeus / 2);
        this.alus.setY(leveys / 2);
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
        if (asteroidit.isEmpty()) {
            taso++;
            if (kerroin > 1) {
                kerroin--;
            }
            for (int it = 0; it < 9 + taso; it++) {
                Asteroidi uusi = new Asteroidi();
                asteroidit.add(uusi);
            }
        }
        if (alus.liikkuu) {
            alus.kiihdyta(alus.getVanhaKulma());
        }
        if (i > 2000) {
            i = 1;
        }
        if (alus.ampuu && i % 20 == 0 && alus.liikkuu) {
            Ammus uusi = new Ammus(alus.getX(), alus.getY());
            uusi.kaanny(alus.getKulma());
            alus.ammukset.add(uusi);
        }
        for (Ammus ammus : alus.ammukset) {
            ammus.liiku(ammus.getKulma());
            ammus.liiku(ammus.getKulma());
            ammus.liiku(ammus.getKulma());
        }
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

        ListIterator<Asteroidi> iter = asteroidit.listIterator();
        if (i % kerroin == 0) {
            while (iter.hasNext()) {
                Asteroidi asteroidi = iter.next();
                if (asteroidi.getKoko() < 15) {
                    pisteet += 50;
                    iter.remove();
                } else {
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

                    if (alus.osuu(asteroidi) && alus.liikkuu) {
                        elamat--;
                        palautaAlusKeskelle();
                    }
                    for (Ammus ammus : alus.ammukset) {
                        if (ammus.osuu(asteroidi)) {
                            pisteet += 100;
                            iter.remove();
                            Asteroidi uusiA = new Asteroidi(asteroidi, asteroidi.getSuunta() - 1.5);
                            Asteroidi uusiB = new Asteroidi(asteroidi, asteroidi.getSuunta() + 1.5);
                            iter.add(uusiA);
                            iter.add(uusiB);
                        }
                    }
                }

            }
        }
        i++;
        update.update();
    }
}
