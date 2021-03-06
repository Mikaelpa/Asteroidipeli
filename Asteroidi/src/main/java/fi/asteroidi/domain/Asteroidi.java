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
        this.koko = 40;
        this.nopeus = 0;
        this.x = 0 + (int) (Math.random() * 500);
        this.y = 0 + (int) (Math.random() * 500);
        this.suunta = 0.1f + (double) (Math.random() * 5.0f);
    }
    /**
     * Vaihtoehtoinen konstruktori.
     * Kun asteroidiin osutaan, tehdään 2 uutta asteroidia ja annetaan niille uusi suunta
     * @param vanha vanha asteroidi
     * @param suunta uusi suunta
     */
    public Asteroidi(Asteroidi vanha, double suunta) {
        this.koko = vanha.getKoko() / 2 + 5;
        this.x = vanha.getX();
        this.y = vanha.getY();
        this.suunta = suunta;
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
