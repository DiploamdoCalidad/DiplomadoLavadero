/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import java.awt.Dimension;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
/**
 *
 * @author Miguel
 */
public class JExplotar {
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();    
    private Dimension d;
    private int count = 0;
    //
    private JPanel contenedor;
    private JPanel contenido;
    //coordenadas del JPanel contenido
    private int px=0;
    private int py=0;
    //
    private int ancho_min = 10;
    private int alto_min = 10;
    private int velocidad = 20;//en milisegundos
    
    public JExplotar( JPanel contenedor , JPanel contenido )
    {
        this.contenedor = contenedor;
        this.contenido = contenido;        
        this.contenedor.removeAll();
        
        d = new Dimension( 10 ,10 );
        this.contenido.setSize( d );//tamaño inicial
        
        //coordenadas iniciales
        px = this.contenedor.getSize().width/2-this.ancho_min/2;
        py = this.contenedor.getSize().height/2-this.alto_min/2;        
        contenido.setLocation( px, py );
        contenido.setVisible(true);
        
        //se agrega al contenedor el JPanel contenido
        this.contenedor.add( contenido );
        count = 10;
    }

    
    
    
       public void play()
    {       
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate( 
            new Runnable() 
            {
                
                @Override
                public void run() {                     
                    //nuevo tamaño 
                    d = new Dimension( contenedor.getSize().width * count/100 , contenedor.getSize().height * count/100 );
                    count = count + 10;
                    //se recalcula la posicion mientras el jpanel crece
                    px = contenedor.getSize().width/2-d.width/2;
                    py = contenedor.getSize().height/2-d.height/2;        
                    contenido.setLocation( px, py );
                    
                   if( count > 100 ) 
                   {                       
                       close();                       
                   }
                   contenido.setSize( d );
                   contenedor.updateUI();                        
                }
              }, 100, velocidad , TimeUnit.MILLISECONDS );
            
    }
       
       public void close() {
        scheduler.shutdownNow();
    }

    
}
