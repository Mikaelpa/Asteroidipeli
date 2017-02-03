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
        peli.getAlus().setX(20);
        assertEquals(20, peli.getAlus().getX());
    }
}
