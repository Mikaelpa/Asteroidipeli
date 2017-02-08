
package fi.asteroidi.domain;
/**
 * Pelaajan liikuttaman aluksen luokka.
 * @author mikaelpa
 */
public class Alus {
    public int koko;
    public double nopeus;
    public double x;
    public double y;
    public boolean kaantyyOikealle;
    public boolean kaantyyVasemmalle;
    public boolean liikkuu;
    public boolean ampuu;
    public double kulma;
    /**
     * Aluksen konstruktori.
     * @param x Annetaan luotavalle alukselle xy koordinaatit, mihin se sijoitetaan.
     * @param y 
     */
    public Alus(double x, double y) {
        this.x = x;
        this.y = y;
        this.nopeus = 0;
        this.kaantyyOikealle = false;
        this.kaantyyVasemmalle = false;
        this.liikkuu = false;
        this.ampuu = false;
        this.kulma = -1.6f;
        
        
    }
    
    /**
     * Käännetään aluksen tämänhetkistä kulmaa / suuntaa x määrä.
     * @param maara annettu määrä mitä käännytään. 
     */
    
    public void kaanny(double maara) {
        this.kulma += maara;
        this.kulma %= Math.PI * 2;
    }
    
    public double getKulma() {
        return this.kulma;
    }
    
    public void setLiikkuuko(boolean arvo) {
        this.liikkuu = arvo;
    }
    
    public boolean liikkuuko() {
        return this.liikkuu;
    }

    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    /**
     * Liikutetaan alusta haluttuun suuntaan.
     * @param arvo metodille annetaan parametrinä aluksen tämänhetkinen kulma (menosuunta).
     */
    
    public void kiihdyta(double arvo) {
        this.x += Math.cos(arvo);
        this.y += Math.sin(arvo);        
    }
    
    public void pysahdy() {
        this.nopeus = 0;
    }
    
    public void setX(double luku) {
        x = luku;
    }
    
    public void setY(double luku) {
        y = luku;
    }
    
    /**
     * Testataan osuuko alus asteroidiin.
     * @param toinenX asteroidin xy.
     * @param toinenY
     * @return 
     */
    
    public boolean osuu(double toinenX, double toinenY) {
        if (this.x == toinenX) {
            if (this.y == toinenY) {
                return true;
            }
        }
        return false;
    } 
}
