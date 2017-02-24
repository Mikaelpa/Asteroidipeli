
package fi.asteroidi.gui;

import fi.asteroidi.domain.Alus;
import fi.asteroidi.peli.Asteroids;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Oma luokka näppäinkomennoille.
 * @author mikaelpa
 */

public class Nappaimistonkuuntelija implements KeyListener {
    private final Alus alus;
    
    /**
     * Konstruktori.
     * Annetaan parametrina käytettävä alus
     * @param alus annettu alus
     */
    public Nappaimistonkuuntelija(Alus alus) {
        this.alus = alus;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            alus.kaantyyVasemmalle = true;
        }     
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            alus.kaantyyOikealle = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            alus.liikkuu = true;
            alus.vanhaKulma = alus.getKulma();
            
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            alus.ampuu = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            alus.kaantyyVasemmalle = false;
            
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            alus.kaantyyOikealle = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            alus.ampuu = false;
        }
    }
    
}
