package fi.asteroidi.domain;
/**
 * Asteroidin luokka.
 * @author mikaelpa
 */

public class Asteroidi {
    public int koko;
    public int nopeus;
    public double x;
    public double y;
    public int kulmia;
    public double suunta;
    
    /**
     * Luodaan uudelle asteroidille random määrä kulmia,
     * random koko, random sijainti ja random suunta pelilaudalla.
     */
    
    public Asteroidi() {
        this.kulmia = 6 + (int) (Math.random() * 9);
        this.koko = 12 + (int) (Math.random() * 20);
        this.nopeus = 0;
        this.x = -20 + (int) (Math.random() * 50);
        this.y = -20 + (int) (Math.random() * 30);
        this.suunta = 0.1f + (double) (Math.random() * 5.0f);
    }
    
    
    public int getKoko() {
        return this.koko;
    }
    
    public double getSuunta() {
        return this.suunta;
    }
    
    /**
     * Liikutaan haluttuun suuntaan.
     * @param arvo asteroidin tämänhetkinen suunta.
     */
    
    public void liiku(double arvo) {
        this.x += Math.cos(arvo);
        this.y += Math.sin(arvo);        
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
    
    
}
