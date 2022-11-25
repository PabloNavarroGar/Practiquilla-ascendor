/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author pablo
 */
public class Elevador {

    //Atributos
    private String numSerie;
    private int capacidadMaxima;//800kg
    private int capacidadMinima;//Siempre es 0
    private int capacidadMaximaPersonas;//10 personas como maximo
    private String estado;//estado del ascensor
    private String planta;//Plantas, se crea en la baja por defecto,primera segunda.....

    //Atributos de cuando viajan
    private int pesoTotal;
    private int numeroPasajeros;

    //Fechas , se pasan por el formato a continuacion
    private LocalDate fechaFabricacion = LocalDate.now();
    LocalDate ultimaRevision = LocalDate.now();

    //Pasar fechas a String 
    private DateTimeFormatter formatofechas = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //String que llevara el constructor
    private String fechaFabrica = fechaFabricacion.format(formatofechas);
    private String fechaMantenimiento = ultimaRevision.format(formatofechas);

    public Elevador() {
    }

    public Elevador(String estado, String planta, String fecha, String fecha2) {
        this.numSerie = generarNumeroSerie();
        this.capacidadMaxima = pesoMaximo();
        this.capacidadMaximaPersonas = personasPerminitas();
        this.estado = estado.equals("funcionando")
                || estado.equals("subiendo")
                || estado.equals("bajando")
                || estado.equals("subiendo")
                || estado.equals("parado")
                || estado.equals("averiado")
                ? estado : "funcionando";

        this.planta = planta.equals("baja") || planta.equals("cero") || planta.equals("ocho") ? planta : "baja";
        this.fechaFabrica = fecha;
        this.fechaMantenimiento = fecha2;
    }

    //Metodo para generar rumero aleatorios
    private static String generarNumeroSerie() {

        String numero = RandomStringUtils.randomNumeric(8);

        return numero;
    }

    //Metodo para poner la que sea 800 kilos la capacidad Maxima
    private int pesoMaximo() {
        int capacidad;

        capacidad = 800;

        return capacidad;
    }

    private int personasPerminitas() {
        int capacidadPersonas;

        capacidadPersonas = 10;

        return capacidadPersonas;
    }

    //Metodos para el estado inicial y en la planta en la que se crean
    public void estadoOriginal() {

        this.estado = "null";
    }

    public void plantaOriginal() {

        this.planta = "baja";
    }

    @Override
    public String toString() {
        return "Elevador{" + "numSerie=" + numSerie
                + "\n, capacidadMaxima=" + capacidadMaxima
                + "\n, capacidadMinima=" + capacidadMinima
                + "\n, capacidadMaximaPersonas=" + capacidadMaximaPersonas
                + "\n, estado=" + estado
                + "\n, planta=" + planta
                + "\n, fechaFabrica=" + fechaFabricacion
                + "\n, fechaMantenimiento=" + ultimaRevision + '}';
    }

    //Los 3 get y setters que pide para que se puedan cambiar
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public LocalDate getUltimaRevision() {
        return ultimaRevision;
    }

    public void setUltimaRevision(LocalDate ultimaRevision) {
        this.ultimaRevision = ultimaRevision;
    }

    //Metodo de meter personas en el ascensor, hay que tener en cuenta el numero de pasajeros,peso y la planta
    public void viaje(Elevador elevador, int numeroPasajeros, int pesoTotal, String planta) {
        //NO se toman valores negativos 
        numeroPasajeros = Math.abs(numeroPasajeros);
        pesoTotal = Math.abs(pesoTotal);

    }

    public void mover(Elevador elevador) {
        
        
        elevador.viaje(elevador, numeroPasajeros, pesoTotal, this.planta);
        if (numeroPasajeros > 10 || pesoTotal > 800) {

            throw new IllegalArgumentException();//expecion
        } else {

            if (this.planta.equals("ocho")) {

                this.estado = "subiendo";

            } else if (this.planta.equals("baja")) {

                this.estado = "bajando";
                
            } else if (this.planta.equals("cero")) {
                this.estado = "bajando";
                
            }
        }

    }

}
