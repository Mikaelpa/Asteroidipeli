
package fi.asteroidi.domain;

import fi.asteroidi.domain.Asteroidi;
import fi.asteroidi.domain.Ammus;
import fi.asteroidi.domain.Alus;
import org.junit.Test;
import static org.junit.Assert.*;

public class AmmusTest {
    public AmmusTest() {
        
    }
    
    
    @Test
    public void testAmmusSetX() {
        Ammus ammus = new Ammus();
        double i = 3;
        ammus.setX(i);
        assertEquals(i, ammus.getX(), 0.1);
    }
      
    @Test
    public void testAmmusSetY() {
        Ammus ammus = new Ammus();
        double i = 7;
        ammus.setY(i);
        assertEquals(i, ammus.getY(), 0.1);
    }
    
    
    @Test
    public void testAmmusOsuuAsteroidiin() {
        Ammus ammus = new Ammus();
        Asteroidi asteroidi = new Asteroidi();
        double astX = asteroidi.getX();
        double astY = asteroidi.getY();
        
        ammus.setX(astX);
        ammus.setY(astY);
        
        assertTrue(ammus.osuu(astX, astY));
    }
    
    @Test
    public void testAmmusEiOsuAina() {
        Ammus ammus = new Ammus();
        double uusiX = 3;
        double uusiY = 4;
        
        ammus.setX(6);
        ammus.setY(4);
        
        assertFalse(ammus.osuu(uusiX, uusiY));
    }    
        
}
