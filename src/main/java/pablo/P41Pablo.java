/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pablo;

/**
 *
 * @author pablo
 */
public class P41Pablo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //Crea dos ascensores con los datos que tú quieras, uno con parámetros correctos y otro con parámetros incorrectos
        Elevador e1 = new Elevador("funcionando", "baja", "", "");
        System.out.println(e1);
        
        Elevador e2 = new Elevador("hola", "decima", "", "");
        System.out.println(e2);
        
        //Vamos a subir a la planta 8
        
        //e1.viaje(e1, 5, 450, "ocho");
        
        e1.mover(e1);
        //Se imprime el estado
        System.out.println(e1.getEstado());
        
        
        
        
        
        
        
        
        
        
        
        
        //Renovacion del mantenimiendo
        Edificio.renovarFechaRevision(e1);
    }
}
