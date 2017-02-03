
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
        Alus alus = new Alus();
        int i = 4;
        alus.setX(i);
        assertEquals(i, alus.getX());
    }
    
    @Test
    public void testAlusSetY() {
        Alus alus = new Alus();
        int i = 4;
        alus.setY(i);
        assertEquals(i, alus.getY());
    }
    
    @Test
    public void testAlusOsuukoToimii() {
        Alus alus = new Alus();
        int uusiX = 5;
        int uusiY = 8;
        alus.setX(uusiX);
        alus.setY(uusiY);
        assertTrue(alus.osuu(uusiX, uusiY));
    }    
}
