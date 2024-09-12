/**
 * Write a description of class mapaIndividual here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mapaIndividual  
{
    // instance variables - replace the example below with your own
    private mapaIndividual siguienteMapa;
    private String rutaImagenMapa;
    private String archivoMapa;
    private String nomMapa;

    /**
     * Constructor for objects of class mapaIndividual
     */
    public mapaIndividual()
    {
    }
    public mapaIndividual(String nom, String ima,String arc)
    {
        this.nomMapa=nom;
        this.rutaImagenMapa=ima;
        this.archivoMapa=arc;
    }
    
    public String getNomMapa(){
        return this.nomMapa;
    }
    
    public String getRutaImagenMapa(){
        return this.rutaImagenMapa;
    }
    
    public String getArchivoMapa(){
        return this.archivoMapa;
    }

    public mapaIndividual getSiguienteMapa(){
        return this.siguienteMapa;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setSiguienteMapa(mapaIndividual mp){
        this.siguienteMapa = mp;
    }
    
}
