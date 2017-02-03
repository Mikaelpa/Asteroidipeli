
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
        Asteroidi asteroidi = new Asteroidi(3,8);
        assertEquals(3, asteroidi.getX());
        assertEquals(8, asteroidi.getY());
    }
    
    @Test
    public void testAsteroidiSetX() {
        Asteroidi asteroidi = new Asteroidi(4,8);
        int i = 8;
        asteroidi.setX(i);
        assertEquals(i, asteroidi.getX());
    }

    @Test
    public void testAsteroidiSetY() {
        Asteroidi asteroidi = new Asteroidi(4,9);
        asteroidi.setY(5);
        assertEquals(5, asteroidi.getY());
    }



}
