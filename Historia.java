import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Historia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Historia extends World
{
     private GreenfootImage h1,h2,h3,h4,h5,h6,h7,h8, h9, h10;
     public Volver but = new Volver();
     public Sig but1 = new Sig();
     private GreenfootSound bkgMusic;
    
    public Historia()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        bkgMusic = new GreenfootSound("MenuSong.mp3");  
        bkgMusic.playLoop();
        h1 = new GreenfootImage("His_P1.png");
        h2 = new GreenfootImage("His_P2.png");
        h3 = new GreenfootImage("His_P3.png");
        h4 = new GreenfootImage("His_P4.png");
        h5 = new GreenfootImage("His_P5.png");
        h6 = new GreenfootImage("His_P6.png");
        h7 = new GreenfootImage("His_P7.png");
        h8 = new GreenfootImage("His_P8.png");
        h9 = new GreenfootImage("His_P9.png");
        setBackground(h1);   
        addObject(but,40,380);
        addObject(but1,560,380);
        
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(but)){
             bkgMusic.stop();
             Menu world = new Menu();
             Greenfoot.setWorld(world);
        }
        
        if(Greenfoot.mouseClicked(but1) && getBackground() == h1){
             setBackground(h2);
        }else if(Greenfoot.mouseClicked(but1) && getBackground() == h2){
            setBackground(h3);
        }else if(Greenfoot.mouseClicked(but1) && getBackground() == h3){
            bkgMusic.stop();
            bkgMusic = new GreenfootSound("Wii.mp3");  
            bkgMusic.playLoop();
            setBackground(h4);
        }else if(Greenfoot.mouseClicked(but1) && getBackground() == h4){
            setBackground(h5);
        }else if(Greenfoot.mouseClicked(but1) && getBackground() == h5){
            setBackground(h6);
        }else if(Greenfoot.mouseClicked(but1) && getBackground() == h6){
            setBackground(h7);
        }else if(Greenfoot.mouseClicked(but1) && getBackground() == h7){
            setBackground(h8);
        }else if(Greenfoot.mouseClicked(but1) && getBackground() == h8){
            setBackground(h9);
        }
    }
}
