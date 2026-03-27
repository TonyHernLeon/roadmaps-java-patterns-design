package patrones_creacionales.factory_method;

/**
 * CREADOR ABSATRACTO: El Corazón del patrón Factory Method.
 *
 * Esta clase abstracta define el 'Factory Method': crearVehiculo().
 * NO SABE QUE TIPO DE VEHICULO CREAR, pero sabe que ALGUIEN LO CREARÁ
 *
 * 'crearVehiculo(String nombre) está marcado como 'abstract' para que cada
 * subclase, de forma 'OBLIGATORIA' defina como crear el Vehiculo.
 *
 * Tenemos una 'lógica de negocio' (entregarVehiculo()) la cual usa Vehiculo
 * SIN IMPORTA si es Coche o Moto, y ahí está la magia.
 */
public abstract class FabricaVehiculo {

    /*+ FACTORY METHOD.
        * Este es el método que cada subclase debe implementar.
        * La subclase decide que tipo de vehículo crea.
     */
    public abstract Vehiculo crearVehiculo(String nombre);

    /*+
        * La lógica de negocio, donde se trabaja con Vehiculo (interface),
        * no importando que sea Coche o Moto.
     */
    public void entregarVehiculo(String nombre){
        System.out.println("\n|======================================|");
        System.out.println("** Se inicia el proceso de fabricación... **");

        Vehiculo vehiculo = this.crearVehiculo(nombre);

        System.out.println("** Se realiza una prueba diagnostica... **");
        vehiculo.arrancar();
        System.out.println("** ¡Vehiculo listo para la entrega!");
        System.out.println("|======================================|\n");
    }
}
