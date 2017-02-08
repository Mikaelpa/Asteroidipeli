
package fi.asteroidi.domain;

import fi.asteroidi.domain.Asteroidi;
import fi.asteroidi.domain.Ammus;
import fi.asteroidi.domain.Alus;
import org.junit.Test;
import static org.junit.Assert.*;


public class AsteroidiTest {

    public AsteroidiTest() {
    }


    @Test
    public void testUusiAsteroidi() {
        Asteroidi asteroidi = new Asteroidi();
        assertTrue(asteroidi.getKoko()>0);
    }
    
    @Test
    public void testAsteroidiSetX() {
        Asteroidi asteroidi = new Asteroidi();
        double i = 8;
        asteroidi.setX(i);
        assertEquals(i, asteroidi.getX(), 0.1);
    }

    @Test
    public void testAsteroidiSetY() {
        Asteroidi asteroidi = new Asteroidi();
        asteroidi.setY(5);
        assertEquals(5, asteroidi.getY(), 0.1);
    }



}
