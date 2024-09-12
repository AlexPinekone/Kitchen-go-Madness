import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpM here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpM extends World
{
    private GreenfootSound bkgMusic;
    public Volver but = new Volver();
    
    public HelpM()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        bkgMusic = new GreenfootSound("HelpSong.mp3"); 
        bkgMusic.playLoop();
        addObject(but,300,365);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(but)){
             bkgMusic.stop();
             Menu world = new Menu();
             Greenfoot.setWorld(world);
        }
    }
}
