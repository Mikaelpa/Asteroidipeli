
package asteroidi.domain;

import org.junit.Test;
import static org.junit.Assert.*;


public class AsteroidiTest {

    public AsteroidiTest() {
    }


    @Test
    public void testUusiAsteroidi() {
        Asteroidi asteroidi = new Asteroidi();
        int i = 0;
        assertEquals(i, asteroidi.getX());
    }
    
    @Test
    public void testAsteroidiSetX() {
        Asteroidi asteroidi = new Asteroidi();
        int i = 8;
        asteroidi.setX(i);
        assertEquals(i, asteroidi.getX());
    }

    @Test
    public void testAsteroidiSetY() {
        Asteroidi asteroidi = new Asteroidi();
        int i = 9;
        asteroidi.setY(i);
        assertEquals(i, asteroidi.getY());
    }
    
    @Test
    public void testAmmusSetX() {
        Ammus ammus = new Ammus();
        int i = 3;
        ammus.setX(i);
        assertEquals(i, ammus.getX());
    }
  
    @Test
    public void testAmmusSetY() {
        Ammus ammus = new Ammus();
        int i = 7;
        ammus.setY(i);
        assertEquals(i, ammus.getY());
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
        alus.setX(uusiY);
        alus.setY(uusiY);
        assertTrue(alus.osuu(uusiX, uusiY));
    }
    
    @Test
    public void testAmmusOsuuAsteroidiin() {
        Ammus ammus = new Ammus();
        Asteroidi asteroidi = new Asteroidi();
        int astX = asteroidi.getX();
        int astY = asteroidi.getY();
        
        ammus.setX(astX);
        ammus.setY(astY);
        
        assertTrue(ammus.osuu(astX, astY));
    }
    
    @Test
    public void testAmmusEiOsuAina() {
        Ammus ammus = new Ammus();
        int uusiX = 3;
        int uusiY = 4;
        
        ammus.setX(6);
        ammus.setY(4);
        
        assertFalse(ammus.osuu(uusiX, uusiY));
    }    
    

}
