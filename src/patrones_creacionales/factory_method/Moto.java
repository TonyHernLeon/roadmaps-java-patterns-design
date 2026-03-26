package patrones_creacionales.factory_method;

/**
 * PRODUCTO CONCRETO: Coche
 *
 * Ejemplo de implemantación de la interfaz 'Vehículo'
 * donde el objeto 'Coche' hará suyos los métodos de la interfaz
 * y los ejecutará como este necesite.
 *
 */
public class Coche implements Vehículo{
    String modelo;

    /** Construtor */
    public Coche(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void arrancar() {
        System.out.println("El coche con el modelo "+ modelo +" se ha arranca.");
    }

    @Override
    public void describirse() {
        System.out.println(("Soy un coche modelo: "+ modelo));
    }
}
