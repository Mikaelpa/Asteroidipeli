
package fi.asteroidi.gui;
import fi.asteroidi.peli.Asteroids;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Käyttöliittymän oma luokka
 * Luodaan peli ja piirtoalusta.
 * @author mikaelpa
 */

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Asteroids peli;
    private Piirtoalusta alusta;
    private int koko;
    /**
     * Konstruktori.
     * Annetaan peli parametrinä
     * @param peli annettu peli
     */
    public Kayttoliittyma(Asteroids peli) {
        this.peli = peli;
        this.koko = peli.getKorkeus();
    }
    
    /**
     * Luodaan pelille komponentit.
     * @param container 
     */

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
    
    /**
     * Luodaan uusi paneeli millä peliä pelataan.
     */

    @Override
    public void run() {
        frame = new JFrame("Asteroids");
        frame.setPreferredSize(new Dimension(peli.getKorkeus(), peli.getLeveys()));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        
    }
    
}
