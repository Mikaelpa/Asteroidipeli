
package fi.asteroidi.peli;

import fi.asteroidi.domain.Alus;
import fi.asteroidi.domain.Asteroidi;
import fi.asteroidi.gui.Update;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;



public class Asteroids extends Timer implements ActionListener {
    private int leveys;
    private int korkeus;
    private Alus alus;
    private ArrayList<Asteroidi> asteroidit;
    private Update update;
    
    public Asteroids(int korkeus, int leveys) {
        super(1000, null);
        this.asteroidit = new ArrayList<>();
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.alus = new Alus();
        for (int i = 0; i < 20; i++) {
            Asteroidi uusi = new Asteroidi(0 + (int) (Math.random() * 300), 0 + (int) (Math.random() * 300));
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
    


    @Override
    public void actionPerformed(ActionEvent e) {
        update.update();
    }
    
}
