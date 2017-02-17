
package fi.asteroidi.gui;

import fi.asteroidi.domain.Alus;
import fi.asteroidi.domain.Ammus;
import fi.asteroidi.domain.Asteroidi;
import fi.asteroidi.peli.Asteroids;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import static java.lang.Boolean.TRUE;
import javafx.scene.shape.TriangleMesh;
import static javafx.scene.transform.Transform.translate;
import javax.swing.JPanel;
import static oracle.jrockit.jfr.events.Bits.intValue;
import sun.java2d.pipe.BufferedOpCodes;
/**
 * Pelin piirtämiselle oma luokka.
 * @author mikaelpa
 */

public class Piirtoalusta extends JPanel implements Update {
    private int koko;
    private Asteroids peli;
    
    /**
     * Konstruktori.
     * Luodaan uusi piirtoalusta
     * @param peli annettu peli
     * @param koko piirtoalustan koko
     */
    public Piirtoalusta(Asteroids peli, int koko) {
        this.peli = peli;
        this.koko = koko;
    }
    
    /**
     * Piirretään joka päivityksellä uudestaan.
     * @param g 
     */
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        piirraAlus(g2d, peli.getAlus(), peli.getAlus().getX(), peli.getAlus().getY());
        for (Asteroidi asteroidi : peli.asteroidiLista()) {
            piirraAsteroidi(g2d, asteroidi, asteroidi.getX(), asteroidi.getY());   
        }
        for (Ammus ammus : peli.getAlus().ammukset) {
            piirraAmmus(g2d, ammus, ammus.getX(), ammus.getY());
        }
    }
    
    /**
     * piirretään pelaajan käyttämä alus.
     * @param g2d alusta millä piirretään.
     * @param alus käytettävä alus.
     * @param x aluksen tämän hetken xy.
     * @param y 
     */
    
    private void piirraAlus(Graphics2D g2d, Alus alus, double x, double y) {
        AffineTransform tallennus = new AffineTransform();
        tallennus = g2d.getTransform();        
        g2d.translate(x, y);
        double kaannos = alus.getKulma();
        g2d.rotate(kaannos);
        g2d.drawLine(-10, -8, 10, 0);
        g2d.drawLine(-10, 8, 10, 0);
        g2d.drawLine(-6, -6, -6, 6);
        g2d.setTransform(tallennus);
    }
    
    /**
     * Piirretään ammukset yksi kerrallaan.
     * @param g2d alusta millä piirretään.
     * @param ammus piirrettävä ammus.
     * @param x ammuksen tämän hetken xy.
     * @param y 
     */
    private void piirraAmmus(Graphics2D g2d, Ammus ammus, double x, double y) {
        AffineTransform tallennus = new AffineTransform();
        tallennus = g2d.getTransform();
        g2d.translate(x, y);
        g2d.fill3DRect(0, 0, 2, 2, true);
        g2d.setTransform(tallennus);        
    }
    
    /**
     * Piirretään asteroidit yksi kerrallaan.
     * @param g2d alusta millä piirretään.
     * @param asteroidi piirrettävä asteroidi.
     * @param x asteroidin tämän hetken xy.
     * @param y 
     */
    private void piirraAsteroidi(Graphics2D g2d, Asteroidi asteroidi, double x, double y) {
        if (asteroidi.onElossa) {
            AffineTransform tallennus = new AffineTransform();
            tallennus = g2d.getTransform();
            g2d.translate(x, y);
            g2d.draw3DRect(0, 0, asteroidi.koko, asteroidi.koko, true);
            g2d.setTransform(tallennus);
        }
    }

    /**
     * Piirretään alusta uudestaan joka päivityksellä.
     */
    
    @Override
    public void update() {
        super.repaint();
    }
    
    
}
