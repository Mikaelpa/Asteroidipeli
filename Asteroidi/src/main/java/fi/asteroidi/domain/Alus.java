
package fi.asteroidi.domain;

public class Alus {
    public int koko;
    public int nopeus;
    public int x;
    public int y;
    
    public Alus() {
        this.koko = 10;
        this.nopeus = 0;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void kiihdyta() {
        this.nopeus = 2;
    }
    
    public void pysahdy() {
        this.nopeus = 0;
    }
    
    public void setX(int luku) {
        x = luku;
    }
    
    public void setY(int luku) {
        y = luku;
    }    
    
    public boolean osuu(int toinenX, int toinenY) {
        if (this.x == toinenX) {
            if (this.y == toinenY) {
                return true;
            }
        }
        return false;
    } 
}
