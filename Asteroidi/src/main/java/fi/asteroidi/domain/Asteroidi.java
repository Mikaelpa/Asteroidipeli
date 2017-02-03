package fi.asteroidi.domain;


public class Asteroidi {
    public int koko;
    public int nopeus;
    public int x;
    public int y;
    public int kulmia;
    
    public Asteroidi(int uusiX, int uusiY) {
        this.kulmia = 6 + (int) (Math.random() * 9);
        this.koko = 12 + (int) (Math.random() * 20);
        this.nopeus = 0;
        this.x = uusiX;
        this.y = uusiY;
        
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
    
}
