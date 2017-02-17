
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
        Alus alus = new Alus(200,200);
        Asteroidi asteroidi = new Asteroidi();
        asteroidi.setX(199);
        asteroidi.setY(199);
        assertTrue(alus.osuu(asteroidi));
    }
    
    @Test
    public void testLiikkuuToimii() {
        Alus alus = new Alus(3,8);
        alus.liikkuu = true;
        assertTrue(alus.liikkuu);
    }
    
    @Test
    public void testEiLiikuAlussa() {
        Alus alus = new Alus(3,8);
        assertFalse(alus.liikkuu);
    }   
    
    @Test
    public void testKiihdytaToimii() {
        Alus uusi = new Alus(20,20);
        uusi.setX(0);
        uusi.kiihdyta(2);
        double test = Math.cos(2);
        assertEquals(uusi.getX(), test, 0.1);
    }
    
    @Test
    public void testKaannyToimii() {
        Alus uusi = new Alus(20,20);
        double test = uusi.getKulma();
        uusi.kaanny(2);
        test += 2;
        test %= Math.PI * 2;
        assertEquals(uusi.getKulma(), test, 0.1);
    }
    
    @Test
    public void testLiikuToimii() {
        Alus alus = new Alus(20,20);
        alus.liiku(1, 1);
        assertEquals(alus.getX(), 21, 0.1);
    }
    
}
