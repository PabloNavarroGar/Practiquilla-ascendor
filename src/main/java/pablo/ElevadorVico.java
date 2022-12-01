/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablo;

import java.time.LocalDate;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author pablo
 */
public class ElevadorVico {
    
    
    //Atributos de clase
    //Se incializan aqi arriba y se pueden usar.
    public static final double PESO_MAXIMO =800;
    public static final double PESO_MINIMO =0;
    public static final int PLANTA_BAJA=0;
    public static final int PLANTA_MAX=8;
    
    //Atributos de instancia
    private String numero;
    private String fabricante;
    private int capacidadMaxima;
    private double pesoSoportado;
    private LocalDate fechaFabricacion;
    private LocalDate fechaRevision;
    private int planta;
    //ENLAZAR CON LOS ENUM
    private Estado estado;

    public ElevadorVico(String fabricante, int capacidadMaxima, double pesoSoportado) {
        this.numero = generarNumeroSerie();
        this.fabricante = fabricante;
        //Condicionas se ponen directamente en el constructor!!!!!!!!!!!!
        if (capacidadMaxima >= PESO_MINIMO && capacidadMaxima <= 10) {
            this.capacidadMaxima = capacidadMaxima;
        }
        //MAS CONDICIONES
        if (pesoSoportado >= PESO_MINIMO && pesoSoportado <= 800) {
            this.pesoSoportado = pesoSoportado;
        }
        //Se puede llamar la fecha directamente al constructor
        this.fechaFabricacion = LocalDate.now();
        this.fechaRevision = LocalDate.now();
        //this.estado= Estado.PARADO;

    }

    private static String generarNumeroSerie() {

        String numero = RandomStringUtils.randomNumeric(8);

        return numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getPesoSoportado() {
        return pesoSoportado;
    }

    public void setPesoSoportado(double pesoSoportado) {
        this.pesoSoportado = pesoSoportado;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    //Estos 3 van a cambiar
    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ElevadorVico{");
        sb.append("numero=").append(numero);
        sb.append(", fabricante=").append(fabricante);
        sb.append(", capacidadMaxima=").append(capacidadMaxima);
        sb.append(", pesoSoportado=").append(pesoSoportado);
        sb.append(", fechaFabricacion=").append(fechaFabricacion);
        sb.append(", fechaRevision=").append(fechaRevision);
        sb.append(", planta=").append(planta);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

    public boolean mover(int numeroPersonas, double pesoPersona, int numPlanta) {
        //Hay que mirar la capacidad de que el numero de personas no sea diferente
        //por lo cual se una el this.capacidadMxima del constructor
        boolean resultado = false;
        //Si no esta AVERIADO(Su ESTADO)
        if (!this.estado.equals(Estado.AVERIADO)) {
            //Compruebo pesos, y numero de personas
            //Se tiene que en condicion, el numero 
            //de personas que se le de al parametro, sea en el rango de su capacidad 
            if (numeroPersonas >= 0 && numeroPersonas <= this.capacidadMaxima
                    && pesoPersona >= 0 && pesoPersona <= this.pesoSoportado) {
                //Compruebo la planta valida
                //Si la planta es diferente que la planta que YO le pongo, y 
                // el muumero de planta esta entre 0 y 8 
                if (numPlanta != this.planta && numPlanta >= 0 && numPlanta <= PLANTA_MAX) {
                    if (this.planta > numPlanta) {
                        //Se cambian los string por el Enum.su caracteristica
                        this.estado = Estado.BAJANDO;
                    } else {
                        this.estado = Estado.SUBIENDO;
                    }
                    //se cambia el numero de planta para que se mantenga
                    this.planta = numPlanta;
                    //resultado se cambia a true
                    resultado = true;
                }
                //Puedo hacer el viaje

            }

        }

        return resultado;
    }

    public void parar() {
        this.estado = Estado.PARADO;
    }

}
