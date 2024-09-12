import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heroe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heroe extends Entidad
{
    private GreenfootImage im1,im2,im3,im4,im5,im6,im7,im8, im9, im10, im11, im12, atD, atI, atF, atE;
    public int x, y;
    private int timer,mx,my;
    private int frame = 0,frameInv=0,frameInvE=0;
    private int animationCounter = 0;
    
 
    public Heroe(){
        im1 = new GreenfootImage("PF.png");
        im2 = new GreenfootImage("PF1.png");
        im3 = new GreenfootImage("PF2.png");
        im4 = new GreenfootImage("PE.png");
        im5 = new GreenfootImage("PE1.png");
        im6 = new GreenfootImage("PE2.png");
        im7 = new GreenfootImage("PD.png");
        im8 = new GreenfootImage("PD1.png");
        im9 = new GreenfootImage("PD2.png");
        im10 = new GreenfootImage("PI.png");
        im11 = new GreenfootImage("PI1.png");
        im12 = new GreenfootImage("PI2.png");
        atD = new GreenfootImage("atD.png");
        atI = new GreenfootImage("atI.png");
        atE = new GreenfootImage("atE.png");
        atF = new GreenfootImage("atF.png");
        setImage(im1);
        vida=315;
        timer=0;
    }
    protected void addedToWorld(World world)
    {
        x = getX();
        y = getY();
    }
    /**
     * Act - do whatever the Heroe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        timer++;
        mx=my=0;
        if(Greenfoot.isKeyDown("Right"))
        {
            if(timer%10==0){
            if (getImage() != im7 && getImage() != im8)
            {
                 setImage(im7);
            }
            else if(getImage() != im8 && getImage() != im9)
            {
                setImage(im8);
            }else{
                
                setImage(im9);
            }
            }
            
            mx=3;            
        }
           if(Greenfoot.isKeyDown("Left"))
        {
            if(timer%10==0){
            if (getImage() != im10 && getImage() != im11)
            {
                 setImage(im10);
            }
            else if(getImage() != im11 && getImage() != im12)
            {
                setImage(im11);
            }else{
                setImage(im12);
            }
            }
            
            mx=-3;
        }
            if(Greenfoot.isKeyDown("Up"))
        {
            if(timer%10==0){
            if (getImage() != im4 && getImage() != im5)
            {
                 setImage(im4);
            }
            else if(getImage() != im5 && getImage() != im6)
            {
                setImage(im5);
            }else{
                
                setImage(im6);
            }
            }
            
            my=-3;
        }
            if(Greenfoot.isKeyDown("Down"))
        {
            if(timer%10==0){
            if (getImage() != im1 && getImage() != im2)
            {
                 setImage(im1);
            }
            else if(getImage() != im2 && getImage() != im3)
            {
                setImage(im2);
            }else{
                
                 setImage(im3);
            }
            }
            
            my=3;
        }
        
        if(Greenfoot.isKeyDown("Z"))
        {
            if(getImage() == im1 || getImage() == im2 || getImage() == im3)
                setImage(atF);
            if(getImage() == im4 || getImage() == im5 || getImage() == im6)
                setImage(atE);
            if(getImage() == im7 || getImage() == im8 || getImage() == im9)
                setImage(atD);
            if(getImage() == im10 || getImage() == im11 || getImage() == im12)
                setImage(atI);
            
            Enemigo ene = (Enemigo)getOneIntersectingObject(Enemigo.class);
            if(ene != null){
                if(frameInvE>4){
                if(ene.getVida()>0){
                    ene.setVida(ene.getVida()-1);
                    ene.cambia();
                }else{
                    getWorld().removeObject(ene);
                }
                frameInvE=0;
            }
            }
        }
        
        setLocation(getX()+mx, getY()+my);
        
        detectaColision(mx,my);
        
        
        goal();
        frameInvE++;
        frameInv++;
    }
    
    public void goal(){
        Actor pasto = getOneIntersectingObject(Goal.class);
        int numEn = getWorld().getObjects(Enemigo.class).size();
        if(numEn==0){
            if(pasto != null){
            ImageScrollWorld world = (ImageScrollWorld) getWorld();
            world.nextlevel();
        }
        }
        
    }
    
    public void detectaColision(int mx,int my){
        if (isTouching(Ladrillo.class) || isTouching(colisionInvisible.class)||isTouching(Arbol.class)||isTouching(Brick_wall.class)
            ||isTouching(Desk1.class)||isTouching(Desk2.class)||isTouching(Maceta.class)||isTouching(Mesa.class)||isTouching(Maceta2.class)
            ||isTouching(Screen.class)||isTouching(Mesa_2.class)){
            setLocation(getX()-mx, getY()-my);
        }
        
        if (isTouching(Enemigo.class) && frameInv>60){
            if(this.vida>0){
                this.vida=vida-20;
                }
            if(this.vida <= 0){
                ((ImageScrollWorld) getWorld()).detenMus();
                GameOver world = new GameOver();
                Greenfoot.setWorld(world);
            }
            setLocation(getX()-mx*5, getY()-my*5);
            frameInv=0;
        }
    }
}
