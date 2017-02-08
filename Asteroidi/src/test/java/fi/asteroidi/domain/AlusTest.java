
package fi.asteroidi.domain;

import fi.asteroidi.domain.Asteroidi;
import fi.asteroidi.domain.Ammus;
import fi.asteroidi.domain.Alus;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlusTest {
    
    public AlusTest() {
    }
    
    @Test
    public void testAlusSetX() {
        Alus alus = new Alus(6,7);
        double i = 4;
        alus.setX(i);
        assertEquals(i, alus.getX(), 0.1);
    }
    
    @Test
    public void testAlusSetY() {
        Alus alus = new Alus(7,9);
        double i = 4;
        alus.setY(i);
        assertEquals(i, alus.getY(), 0.1);
    }
    
    @Test
    public void testAlusOsuukoToimii() {
        Alus alus = new Alus(3,8);
        double uusiX = 5;
        double uusiY = 8;
        alus.setX(uusiX);
        alus.setY(uusiY);
        assertTrue(alus.osuu(uusiX, uusiY));
    }
    
    @Test
    public void testLiikkuukoToimii() {
        Alus alus = new Alus(3,8);
        alus.setLiikkuuko(true);
        assertTrue(alus.liikkuuko());
    }
    
    @Test
    public void testLiikkuukoEiToimiVaaralla() {
        Alus alus = new Alus(3,8);
        alus.setLiikkuuko(false);
        assertFalse(alus.liikkuuko());
    }    
}
