package asteroidi.domain;


public class Asteroidi {
    public int koko;
    public int nopeus;
    public int x;
    public int y;
    public int kulmia;
    
    public Asteroidi(){
        koko = 5 + (int)(Math.random() * 15); 
        nopeus = 1;
        kulmia = 6 + (int)(Math.random() * 9);
        
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
       
    public void setX(int luku){
        x = luku;
    }
    
    public void setY(int luku) {
        y = luku;
    }    
    
}
