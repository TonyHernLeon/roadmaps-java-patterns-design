package patrones_creacionales.factory_method;

/**
 * PRODUCTO CONCRETO: Coche
 *
 * Ejemplo de implemantación de la interfaz 'Vehículo'
 * donde el objeto 'Coche' hará suyos los métodos de la interfaz
 * y los ejecutará como este necesite.
 *
 */
public class Coche implements Vehiculo {
    String modelo;
    Boolean tieneRemolque;

    /** Construtor */
    public Coche(String modelo,  Boolean tieneRemolque) {
        this.modelo = modelo;
        this.tieneRemolque = tieneRemolque;
    }

    @Override
    public void arrancar() {
        System.out.println("El coche con el modelo "+ this.modelo +" se ha arranca.");
    }

    @Override
    public void describirse() {
        String tieneRemolqueString = tieneRemolque == Boolean.TRUE ? "Si":"No";
        System.out.println(("Soy un coche modelo: "+this.modelo+" y "+tieneRemolqueString+" remolque."));
    }
}
