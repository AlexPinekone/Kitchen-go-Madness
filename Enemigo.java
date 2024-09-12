import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Entidad
{
    public int rutaX,rutaY,posRutaX,posRutaY;
    protected int timer,dire;
    protected int velocidad;
    protected int gpx,gpy;
    
    public Enemigo(){
        
    }
    
    public Enemigo(int posX,int posY,int desX,int desY,int d){
        this.rutaX=posX;
        this.rutaY=posY;
        
        this.posRutaX=desX;
        this.posRutaY=desY;
        gpx = posX;
        gpy = posY;
        
        dire=d;
        velocidad=2;
    }
    public void cambia(){
        
    }
    
    public int getVida(){
        return vida;
    }
    
    public void setVida(int v){
        vida=v;
    }
    
    public int obtenGpx(){
        return gpx;
    }
    
    public int obtenGpy(){
        return gpy;
    }
    
    public void setPosRutaX(int a){
        posRutaX = a;
    }
    public void setPosRutaY(int a){
        posRutaY = a;
    }
    public int getPosRutaX(){
        return posRutaX;
    }
    public int getPosRutaY(){
        return posRutaY;
    }
    
    public void act()
    {
        // Add your action code here.
       
        if(dire==0){
            if(obtenGpx()<posRutaX && !detectaColision()){
                setRotation(0);
                gpx=gpx+velocidad;
                move(velocidad);
            }
            if(getX()>posRutaX){
            dire=1; 
            }
        }
        
        if(dire==1){
            if(obtenGpx()>rutaX && !detectaColision()){
                setRotation(0);
                gpx=gpx-velocidad;
                move(-velocidad);
        }
            if(getX()<rutaX+20){
            dire=0; 
        }
        }
        
    }
    
    
    
    public void mueveteD(){
        if(getX()<posRutaX && !detectaColision()){
            setRotation(0);
            move(2);
        }else{
            if(getY()<posRutaY && !detectaColision()){
                setRotation(-90);
                move(-2);
            }
            else{
                if(getY()>posRutaY && !detectaColision()){
                setRotation(-90);
                move(2);
                }
            }
        }
        if(getX()>posRutaX){
           dire=1; 
        }
        
    }
    
    public void mueveteI(){
        if(getX()>rutaX && !detectaColision()){
            setRotation(0);
            move(-2);
        }else{
            if(getY()>rutaY && !detectaColision()){
                setRotation(-90);
                move(2);
            }
            else{
                if(getY()<rutaY && !detectaColision()){
                setRotation(-90);
                move(-2);
                }
            }
        }
        if(getX()<rutaX){
           dire=0; 
        }
        
    }
    
    public boolean detectaColision(){
        if (isTouching(Ladrillo.class) || isTouching(colisionInvisible.class)){
        return true;
        }
        return false;
    }
}
