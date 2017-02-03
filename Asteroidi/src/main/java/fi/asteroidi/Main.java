package fi.asteroidi;

import fi.asteroidi.gui.Kayttoliittyma;
import fi.asteroidi.peli.Asteroids;
import javax.swing.SwingUtilities;


public class Main {
    
    public static void main(String[] args) {
        Asteroids peli = new Asteroids(20, 20);
        Kayttoliittyma liittyma = new Kayttoliittyma(peli, 20);
        SwingUtilities.invokeLater(liittyma);
        while (liittyma.getUpdate() == null) {
            try {
                Thread.sleep(1000);
                System.out.println("liittymä null");
            } catch (InterruptedException ex) {
                System.out.println("ei ole alustaa");
            }
        }

        peli.setUpdate(liittyma.getUpdate());
        peli.start();
    }
}
