package patrones_creacionales.factory_method;

/**
 * PRODUCTO CONCRETO: Moto
 *
 * Ejemplo de implemantación de la interfaz 'Vehículo'
 * donde el objeto 'Moto' hará suyos los métodos de la interfaz
 * y los ejecutará como este necesite.
 *
 */
public class Moto implements Vehículo{
    String marca;
    Boolean tieneSideCar;

    /** Construtor */
    public Moto(String modelo, Boolean tieneSideCar) {
        this.marca = modelo;
        this.tieneSideCar = tieneSideCar;
    }

    @Override
    public void arrancar() {
        System.out.println("La moto de la marca "+ this.marca +" se ha arranca.");
    }

    @Override
    public void describirse() {
        String tieneSideCarString = this.tieneSideCar == Boolean.TRUE ? "Si":"No";
        System.out.println(("Soy una moto de la marca: "+ this.marca +" y "+tieneSideCarString+" tiene sidecar"));
    }
}
