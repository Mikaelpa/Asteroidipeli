
package fi.asteroidi.gui;

import fi.asteroidi.domain.Asteroidi;
import fi.asteroidi.peli.Asteroids;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel implements Update {
    private int koko;
    private Asteroids peli;
    
    public Piirtoalusta(Asteroids peli, int koko) {
        this.peli = peli;
        this.koko = koko;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (Asteroidi asteroidi : peli.asteroidiLista()) {
            g.fill3DRect(asteroidi.getX(), asteroidi.getY(), asteroidi.koko, asteroidi.koko, true); //testataan että piirto toimii
        }
        
    }

    @Override
    public void update() {
        super.repaint();
    }
    
    
}
