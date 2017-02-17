
package fi.asteroidi.domain;

import java.util.ArrayList;

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
    public boolean ampuu;
    public double kulma;
    public ArrayList<Ammus> ammukset;
    public boolean liikkuu;
    public double vanhaKulma;
    /**
     * Aluksen konstruktori.
     * @param x Annetaan luotavalle alukselle xy koordinaatit, mihin se sijoitetaan.
     * @param y 
     */
    public Alus(double x, double y) {
        this.x = x;
        this.y = y;
        this.ammukset = new ArrayList<>();
        this.nopeus = 0;
        this.kaantyyOikealle = false;
        this.kaantyyVasemmalle = false;
        this.ampuu = false;
        this.kulma = -1.6f;
        this.liikkuu = false;
        
        
    }
    public double getVanhaKulma() {
        return this.vanhaKulma;
    }
    /**Ei vielä käytössä.
     * lisätään nopeus myöhemmin
     * @param arvo 
     */
    public void nopeuta(double arvo) {
        this.x *= arvo;
        this.y *= arvo;
    }
    
    /** Lasketaan uusi y annetusta kulmasta.
     * 
     * @param kulma annettu kulma
     * @return y palautetaan uusi y
     */
    
    public double getYKulmasta(double kulma) {
        double y = Math.sin(kulma);
        return y;
    } 
    /** Lasketaan uusi x annetusta kulmasta.
     * 
     * @param kulma annettu kulma
     * @return x palautetaan uusi x
     */
    public double getXKulmasta(double kulma) {
        double x = Math.cos(kulma);
        return x;
    }
    
    /** Käännetään aluksen tämänhetkistä kulmaa / suuntaa x määrä.
     * 
     * @param maara annettu määrä mitä käännytään. 
     */
    
    public void kaanny(double maara) {
        this.kulma += maara;
        this.kulma %= Math.PI * 2;
    }
    
    /** Liiku.
     * liikutaan eteenpäin annetuilla xy koordinaateilla
     * @param x lisätään x aluksen x:n
     * @param y lisätään y aluksen y:n
     */
    
    public void liiku(double x, double y) {
        this.x += x;
        this.y += y;
    }
    
    public double getKulma() {
        return this.kulma;
    }
    
    
    public void setNopeus(double arvo) {
        this.nopeus = arvo;
    }
    
    public double getNopeus() {
        return this.nopeus;
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
    
    
    public void setX(double luku) {
        x = luku;
    }
    
    public void setY(double luku) {
        y = luku;
    }
    
    /** Boolean osuuko.
     * Testataan osuuko annettu asteroidi alukseen
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
