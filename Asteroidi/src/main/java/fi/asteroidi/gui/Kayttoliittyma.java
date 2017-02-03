
package fi.asteroidi.gui;
import fi.asteroidi.peli.Asteroids;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Asteroids peli;
    private Piirtoalusta alusta;
    private int koko;
    
    public Kayttoliittyma(Asteroids peli, int koko) {
        this.peli = peli;
        this.koko = koko;
    }

    public void luoKomponentit(Container container) {
        alusta = new Piirtoalusta(peli, koko);
        container.add(alusta);
        Nappaimistonkuuntelija key = new Nappaimistonkuuntelija(peli.getAlus());
        frame.addKeyListener(key);   
    }
    
    public Update getUpdate() {
        return alusta;
    }


    public JFrame getFrame() {
        return frame;
    }    

    @Override
    public void run() {
        frame = new JFrame("Asteroids");
        int leveys = (peli.getLeveys()) * koko;
        int korkeus = (peli.getKorkeus()) * koko;

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());


        frame.pack();
        frame.setVisible(true);        
    }
    
}
