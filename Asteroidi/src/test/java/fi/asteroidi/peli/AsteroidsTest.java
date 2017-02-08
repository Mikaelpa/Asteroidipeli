package fi.asteroidi.peli;

import fi.asteroidi.domain.Asteroidi;
import fi.asteroidi.domain.Ammus;
import fi.asteroidi.domain.Alus;
import org.junit.Test;
import static org.junit.Assert.*;

public class AsteroidsTest {
    public AsteroidsTest() {
        
    }
    
    @Test
    public void testTekeeUudenListan() {
        Asteroids peli = new Asteroids(20, 20);
        int i = peli.asteroidiLista().size();
        assertEquals(20, i);
    }
    
    @Test
    public void testTekeeUudenAluksen() {
        Asteroids peli = new Asteroids(20, 20);
        peli.getAlus().setX(20.0);
        assertEquals(20.0, peli.getAlus().getX(), 0.1);
    }
    
    @Test
    public void testAsteroidipeliKokoToimii() {
        Asteroids peli = new Asteroids(20, 50);
        assertEquals(peli.getKorkeus(), 20);
        assertEquals(peli.getLeveys(), 50);
    }
}
