import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private GreenfootSound bkgMusic;
    public Volver but = new Volver();
    
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        bkgMusic = new GreenfootSound("GOSong.mp3"); 
        bkgMusic.playLoop();
        addObject(but,500,365);
    }
    
     public void act(){
        if(Greenfoot.mouseClicked(but)){
             bkgMusic.stop();
             Menu world = new Menu();
             Greenfoot.setWorld(world);
        }
    }
}
