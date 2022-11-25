/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablo;

import java.time.LocalDate;

/**
 *
 * @author pablo
 */
public class Edificio {
    
    public static void renovarFechaRevision(Elevador elevador ){
        
         LocalDate sumarMeses = elevador.ultimaRevision.plusMonths(6);
        System.out.println(" La fecha de mantenimiento se hara el " + sumarMeses);
        
    };
    
}
