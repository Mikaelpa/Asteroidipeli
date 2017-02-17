
package fi.asteroidi.domain;
/**
 * Aluksen ammukset.
 * @author mikaelpa
 */
public class Ammus {
    public double x;
    public double y;
    public int nopeus;
    public double suunta;
    public double kulma;
    
    /**
     * Tehdään uusi ammus.
     * Default nopeus 1
     * Nopeus ei vielä käytössä
     */
    public Ammus() {
        this.nopeus = 1;
    }
    
    /**
     * Tehdään uusi ammus.
     * Parametrinä x ja y
     * @param x annettu x
     * @param y annettu y
     */
    public Ammus(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Liikutetaan ammusta annetun kulman suuntaan.
     * Lasketaan ammuksen x ja y kulmasta
     * @param arvo annettu kulma
     */
    public void liiku(double arvo) {
        this.x += Math.cos(arvo);
        this.y += Math.sin(arvo);        
    }
    
    /**
     * Käännytään annettu määrä.
     * Lasketaan annetun kulman mukaan
     * @param maara annettu kulma
     */
    public void kaanny(double maara) {
        this.kulma += maara;
        this.kulma %= Math.PI * 2;
    }
    
    public double getKulma() {
        return this.kulma;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setX(double luku) {
        x = luku;
    }
    
    public void setY(double luku) {
        y = luku;
    }
    /**
     * Testataan osuuko ammus asteroidiin.
     * Otetaan asteroidin koko huomioon
     * @param ast annettu asteroidi
     * @return osuuko vai ei
     */
    public boolean osuu(Asteroidi ast) {
        if (this.x <= ast.getX() + ast.koko / 2 && this.x >= ast.getX() - ast.koko / 2) {
            if (this.y <= ast.getY() + ast.koko / 2 && this.y >= ast.getY() - ast.koko / 2) {
                return true;
            }
        }
        return false;
    } 
    
    
}
