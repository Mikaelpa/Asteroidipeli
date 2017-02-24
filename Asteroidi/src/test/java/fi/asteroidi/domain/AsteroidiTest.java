
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
    public void testRandomToimii() {
        Asteroidi asteroidi = new Asteroidi();
        assertTrue(asteroidi.x >= 0);
        assertTrue(asteroidi.x < 501);
        assertTrue(asteroidi.y >= 0);
        assertTrue(asteroidi.y < 501);
    }

    @Test
    public void testAsteroidiSetY() {
        Asteroidi asteroidi = new Asteroidi();
        asteroidi.setY(5);
        assertEquals(5, asteroidi.getY(), 0.1);
    }

    @Test
    public void testAsteroidiParametrillatoimii() {
        Asteroidi asteroidi = new Asteroidi();
        asteroidi.setX(200);
        Asteroidi uusi = new Asteroidi(asteroidi, 0);
        assertEquals(asteroidi.getX(), uusi.getX(), 0.1);
    }
    
    @Test
    public void testAsteroidiSuuntaParametrina() {
        Asteroidi asteroidi = new Asteroidi();
        Asteroidi uusi = new Asteroidi(asteroidi, 3.1);
        assertEquals(3.1, uusi.getSuunta(), 0.1);
    }
    
    @Test
    public void testLiikuToimii() {
        Asteroidi uusi = new Asteroidi();
        uusi.setX(0);
        uusi.liiku(2);
        double test = Math.cos(2);
        assertEquals(uusi.getX(), test, 0.1);
    }

}
