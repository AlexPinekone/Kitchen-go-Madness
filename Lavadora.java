import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lavadora here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lavadora extends Enemigo
{
    private GreenfootImage im1,im2,im3,im4,im5,im6,im7,im8;
    public int x, y;
    private int timer,mx,my;
    private int frame = 0;
    private int animationCounter = 0;
    /**
     * Act - do whatever the Lavadora wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Lavadora(){
        
    }
    public Lavadora(int posX,int posY,int desX,int desY,int d){
        super(posX,posY,desX,desY,d);
        im1 = new GreenfootImage("lava.png");
        im2 = new GreenfootImage("lava2.png");
        setImage(im1);
        timer=0;
        vida=2;
    }
    @Override
    public void cambia(){
        setImage(im2);
    }
}
