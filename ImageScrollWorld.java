import greenfoot.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ArrayList;


public class ImageScrollWorld extends World
{
    public static int WIDE=600;
    public static final int HIGH=400;
    
    private Scroller scroller;
    private Actor scrollActor;
    public String mapaLocal;
    private int vidaActual;
    
    interfaz vidaB =new interfaz();
    interfaz vida = new interfaz();
    
    GreenfootImage vidaBarraIm = new GreenfootImage("barraVida.png");
    GreenfootImage vidaIm = new GreenfootImage("vida.png");
    
    private HashMap<String, mapaIndividual> mapas;
    
    ArrayList<Lavadora> lavadoras = new ArrayList<>();
    
    int timer=0;
    public GreenfootSound bkgMusic = new GreenfootSound("MenuSong.mp3");
    
    public ImageScrollWorld()
    {
        super(WIDE,HIGH,1,false);
        mapas = new HashMap<String, mapaIndividual>();
        declaraMundos();
        GreenfootImage bg = new GreenfootImage(mapas.get("mapa1").getRutaImagenMapa());
        mapaLocal="mapa1";
        
        int bgWide= bg.getWidth();
        int bgHigh = bg.getHeight();
        drawTiles(bg,mapas.get("mapa1").getArchivoMapa());
        scroller = new Scroller(this,bg);
        scrollActor = new Heroe();
        addObject(scrollActor,bgWide/2,bgHigh/2);
        declaraEnemy1();
        
        for(Lavadora lav : lavadoras){
            addObject(lav,501,500);
        }
        
        
        generaMundoGenerico();  
        bkgMusic.playLoop();
        
    }
    public ImageScrollWorld(String mapaActual){
        super(WIDE,HIGH,1,false);
        mapas = new HashMap<String, mapaIndividual>();
        declaraMundos();
        mapaLocal=mapaActual;
        
        GreenfootImage bg = new GreenfootImage(mapas.get(mapaLocal).getRutaImagenMapa());
        int bgWide= bg.getWidth();
        int bgHigh = bg.getHeight();
        drawTiles(bg,mapas.get(mapaLocal).getArchivoMapa());
        
        
        scroller = new Scroller(this,bg);
        scrollActor = new Heroe();
        addObject(scrollActor,bgWide/2,bgHigh/2);
        
        if(mapaActual.equals("mapa2")){
            declaraEnemy2();
        }
        if(mapaActual.equals("mapa3")){
            declaraEnemy3();
        }
        if(mapaActual.equals("mapa4")){
            declaraEnemy4();
        }
        
        
        generaMundoGenerico();
        bkgMusic.playLoop();
    }
    public void detenMus(){
        bkgMusic.stop();
    }
    
    public void declaraEnemy1(){
        Lavadora l = new Lavadora(180,100,501,501,0);
        addObject(l,501,500);
        Lavadora l2 = new Lavadora(180,600,501,600,1);
        addObject(l2,501,600);
        Lavadora l3 = new Lavadora(180,400,501,400,1);
        addObject(l3,501,400);
        
    }
    
    public void declaraEnemy2(){
        
        Licuadora l2 = new Licuadora(180,650,501,600,1);
        addObject(l2,601,650);
        Licuadora l3 = new Licuadora(180,500,501,400,1);
        addObject(l3,601,500);
    }
    
    public void declaraEnemy3(){
        Microondas l = new Microondas(180,100,501,501,0);
        addObject(l,801,635);
        Microondas l3 = new Microondas(180,400,501,400,1);
        addObject(l3,501,445);
    }
    
    public void declaraEnemy4(){
        Lavadora l = new Lavadora(180,100,501,501,0);
        addObject(l,501,600);
        Microondas l2 = new Microondas(180,600,501,600,1);
        addObject(l2,501,800);
        Licuadora l3 = new Licuadora(180,400,501,400,1);
        addObject(l3,501,400);
    }
    
    public void generaMundoGenerico(){
        scroll();
        prepare();
        
        vidaActual=revisaVida();
        vidaBarraIm.scale(20,320);
        vidaIm.scale(8,315);
        vidaB.setImage(vidaBarraIm);
        vida.setImage(vidaIm);
        addObject(vidaB,20,230);
        addObject(vida,20,230);
    }
    
    public void act()
    {
        if(scrollActor != null) scroll();
        vidaB.setLocation(20,230);
        vida.setLocation(20,230);
        if(vidaActual>0){
            vidaActual=revisaVida();
            cambiaVida(vidaActual);
        }
        
        if(mapaLocal.equals("mapa4")&&timer>10){
            if(getObjects(Enemigo.class).size()==0){
                bkgMusic.stop();
                Greenfoot.setWorld(new Victory());
            }
            
        }
        timer++;
    }
    
    private void declaraMundos(){
        mapaIndividual mapa1 = new mapaIndividual("mapa1","bgn1.png","mapa1.txt");
        mapaIndividual mapa2 = new mapaIndividual("mapa2","bgn1.png","mapa2.txt");
        mapaIndividual mapa3 = new mapaIndividual("mapa3","bgn1.png","mapa3.txt");
        mapaIndividual mapa4 = new mapaIndividual("mapa4","bgn1.png","mapa4.txt");
        
        mapa1.setSiguienteMapa(mapa2);
        mapa2.setSiguienteMapa(mapa3);
        mapa3.setSiguienteMapa(mapa4);
        
        mapas.put("mapa1",mapa1);
        mapas.put("mapa2",mapa2);
        mapas.put("mapa3",mapa3);
        mapas.put("mapa4",mapa4);
        
    }
    private void scroll()
    {
         int dsx = scrollActor.getX()-WIDE/2;
         int dsy = scrollActor.getY()-HIGH/2;
         
         scroller.scroll(dsx,dsy);
    }
    private void prepare(){
        
    }
    
    public void drawTiles(GreenfootImage bg,String mapaActual){
        char cha;
        String line;
        int alto,largo;
        removeObjects(getObjects(Baldosa.class));
        try{
        BufferedReader br = new BufferedReader(new FileReader(mapaActual));
        largo=Integer.parseInt(br.readLine());
        alto=Integer.parseInt(br.readLine());
        
        for(int j=0;j<alto;j++){
            line=br.readLine();
            for(int i=0;i<largo;i++){
            cha=line.charAt(i);
            
            switch(cha){
                case '0':
                    GreenfootImage pasto = new GreenfootImage("grass.png");
                    bg.drawImage(pasto,64*i+32,64*j+32);
                    break;
                case '1':
                    Ladrillo lad = new Ladrillo();
                    addObject(lad,64*i+64,64*j+64);
                    break;
                case '2':
                    Goal pastoCa = new Goal();
                    addObject(pastoCa,64*i+64,64*j+64);
                    break;
                case '3':
                    Arbol tree = new Arbol();
                    addObject(tree,64*i+64,64*j+64);
                    break;
                case '4':
                    piedra stone = new piedra();
                    addObject(stone,64*i+64,64*j+64);
                    break;
                case '5':
                    tierra dirt = new tierra();
                    addObject(dirt,64*i+64,64*j+64);
                    break;
                case '6':
                    flor flower = new flor();
                    addObject(flower,64*i+64,64*j+64);
                    break;
                case '7':
                    piedrita cobb = new piedrita();
                    addObject(cobb,64*i+64,64*j+64);
                    break;
                case '8':
                    piso floor = new piso();
                    addObject(floor,64*i+64,64*j+64);
                    break;
                case '9':
                    Brick_wall office_wall = new Brick_wall();
                    addObject(office_wall,64*i+64,64*j+64);
                    break;
                case 'd':
                    Desk1 Dsk1 = new Desk1();
                    addObject(Dsk1,64*i+64,64*j+64);
                    break;
                case 'e':
                    Desk2 Dsk2 = new Desk2();
                    addObject(Dsk2,64*i+64,64*j+64);
                    break;
                case 'f':
                    Madera wood = new Madera();
                    addObject(wood,64*i+64,64*j+64);
                    break;
                case 'g':
                    Mesa m = new Mesa();
                    addObject(m,64*i+64,64*j+64);
                    break;
                case 'h':
                    Maceta pot = new Maceta();
                    addObject(pot,64*i+64,64*j+64);
                    break;
                case 'i':
                    Maceta2 treePot = new Maceta2();
                    addObject(treePot,64*i+64,64*j+64);
                    break;
                case 'j':
                    Mesa_2 table = new Mesa_2();
                    addObject(table,64*i+64,64*j+64);
                    break;
                case 'k':
                    Screen pantalla = new Screen();
                    addObject(pantalla,64*i+64,64*j+64);
                    break;
                case 'l':
                    trashcan basura = new trashcan();
                    addObject(basura,64*i+64,64*j+64);
                    break;
                case 'm':
                    Piedra_2 stoneFloor = new Piedra_2();
                    addObject(stoneFloor,64*i+64,64*j+64);
                    break;
                case '\r':
                    cha = (char)br.read();
                    break;
                case '\n':
                    cha = (char)br.read();
                    break;
                case 'b':
                    colisionInvisible coln = new colisionInvisible();
                    addObject(coln,64*i+64,64*j+64);
                    break;
            }  
            } 
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
        
    }
    
    public void nextlevel(){
        if(mapas.get(mapaLocal).getSiguienteMapa() != null){
        bkgMusic.stop();
        ImageScrollWorld newWorld = new ImageScrollWorld(mapas.get(mapaLocal).getSiguienteMapa().getNomMapa());
        Greenfoot.setWorld(newWorld);
        }
        
    }
    
    public void cambiaVida(int cantidadVida){
        
            if(cantidadVida<=0){
                vidaIm.scale(8,1);
            }else{
               vidaIm.scale(8,cantidadVida); 
            }
            
            vida.setImage(vidaIm);
        
    }
    
    public int revisaVida(){
        return ((Heroe)this.scrollActor).vida;
    }
}


