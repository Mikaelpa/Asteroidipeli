
package fi.asteroidi.domain;
/**
 * Aluksen ammukset.
 * @author mikaelpa
 */
public class Ammus {
    public double x;
    public double y;
    public int nopeus;
    
    public Ammus() {
        this.nopeus = 1;
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
     * @param toinenX asteroidin xy.
     * @param toinenY
     * @return 
     */
    public boolean osuu(double toinenX, double toinenY) {
        if (this.x == toinenX && this.y == toinenY) {
            return true;
        }
        return false;
    }
    
    
}
