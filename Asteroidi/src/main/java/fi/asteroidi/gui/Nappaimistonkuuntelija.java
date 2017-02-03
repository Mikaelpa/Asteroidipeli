
package fi.asteroidi.gui;

import fi.asteroidi.domain.Alus;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Nappaimistonkuuntelija implements KeyListener {
    private Alus alus;
    
    public Nappaimistonkuuntelija(Alus alus) {
        this.alus = alus;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
