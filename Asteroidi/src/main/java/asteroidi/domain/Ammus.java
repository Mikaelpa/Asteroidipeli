
package asteroidi.domain;

public class Ammus {
    public int x;
    public int y;
    public int nopeus;
    
    public Ammus() {
        this.nopeus = 1;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setX(int luku) {
        x = luku;
    }
    
    public void setY(int luku) {
        y = luku;
    }
    
    public boolean osuu(int toinenX, int toinenY) {
        if (this.x == toinenX && this.y == toinenY) {
            return true;
        }
        return false;
    }
    
    
}
