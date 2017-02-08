
package fi.asteroidi.peli;

import fi.asteroidi.domain.Alus;
import fi.asteroidi.domain.Asteroidi;
import fi.asteroidi.gui.Update;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
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
        this.alus = new Alus(korkeus / 2 - 10, leveys / 2 - 10);
        for (int i = 0; i < 20; i++) {
            Asteroidi uusi = new Asteroidi();
            asteroidit.add(uusi);
        }
        addActionListener(this);
        setInitialDelay(1000);
        
    }
    
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
        update.update();
        if (alus.kaantyyOikealle) {
            alus.kaanny(0.04);
        }
        if (alus.kaantyyVasemmalle) {
            alus.kaanny(-0.04);
        }
        if (alus.liikkuuko()) {
            alus.kiihdyta(alus.getKulma());
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
        asteroidit.forEach((asteroidi) -> {
            asteroidi.liiku(asteroidi.getSuunta());
        });
        
        
        
    }
    
}
