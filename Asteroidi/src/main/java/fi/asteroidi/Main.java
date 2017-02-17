package fi.asteroidi;

import fi.asteroidi.gui.Kayttoliittyma;
import fi.asteroidi.peli.Asteroids;
import javax.swing.SwingUtilities;
/**
 * Main luokka. Käynnistetään peli.
 * @author mikaelpa
 */

public class Main {
    /**
     * Main luokka. Käynnistetään peli.
     * @param args argumentit.
     */
    public static void main(String[] args) {
        Asteroids peli = new Asteroids(500, 500);
        Kayttoliittyma liittyma = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(liittyma);
        while (liittyma.getUpdate() == null) {
            try {
                Thread.sleep(100);
                System.out.println("liittymä null, päivitykset jää jälkeen");
            } catch (InterruptedException ex) {
                System.out.println("ei ole alustaa");
            }
        }

        peli.setUpdate(liittyma.getUpdate());
        peli.start();
    }
}
