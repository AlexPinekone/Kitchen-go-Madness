import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private GreenfootSound bkgMusic;
    public start but1 = new start();
    public help but2 = new help();
    public History but = new History();
    private GreenfootImage s2;
    
    public Menu()
    {    
        super(600, 400, 1); 
        bkgMusic = new GreenfootSound("MenuSong2.mp3");  
        bkgMusic.playLoop();
        addObject(but1,300,280);
        addObject(but2,300,350);
        addObject(but,100,350);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(but1)){
             bkgMusic.stop();
             ImageScrollWorld world = new ImageScrollWorld();
             Greenfoot.setWorld(world);
        }
        
        if(Greenfoot.mouseClicked(but2)){
             bkgMusic.stop();
             HelpM world = new HelpM();
             Greenfoot.setWorld(world);
        }
        
        if(Greenfoot.mouseClicked(but)){
             bkgMusic.stop();
             Historia world = new Historia();
             Greenfoot.setWorld(world);
        }
    }
}
