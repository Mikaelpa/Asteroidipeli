
package asteroidipeli;

import asteroidi.domain.Alus;
import asteroidi.domain.Asteroidi;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class Asteroids implements ActionListener {
    private int leveys;
    private int korkeus;
    private Alus alus;
    private ArrayList<Asteroidi> asteroidit;
    
    public Asteroids(int korkeus, int leveys) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.alus = new Alus();
        for (int i = 0; i < 10; i++) {
            Asteroidi uusi = new Asteroidi(4, 5);
            asteroidit.add(uusi);
        }
        addActionListener(this);
    }
    
    public ArrayList<Asteroidi> asteroidiLista() {
        return this.asteroidit;
    }
    
    


    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
