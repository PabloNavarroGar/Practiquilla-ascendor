/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pablo;

import java.time.LocalDate;

/**
 *
 * @author pablo
 */
public class VicoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        ElevadorVico e1 = new ElevadorVico("Pablos", 6, 600);
        ElevadorVico e2 = new ElevadorVico("Tomas", 8, 800);
        ElevadorVico e3 = new ElevadorVico("Samus", 10, 1000);
        
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        
        System.out.println("---------------------");
        e1.mover(3, 345, 3);
        
        System.out.println(e1);
        //e1.setEstado(Estado.PARADO);
        //se puede crear el metodo de parar en la clase
        e1.parar();
        System.out.println("La proxima fecha de revision del anscesor es el "+fechaProxRevision(e1));
    }
    
    public static LocalDate fechaProxRevision(ElevadorVico e){
        
        LocalDate fechaRevision;
        fechaRevision = e.getFechaRevision().plusMonths(6);
                return fechaRevision;
    }
    
}
