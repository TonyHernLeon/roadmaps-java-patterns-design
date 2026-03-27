package patrones_creacionales.factory_method;

/**
 * CREADOR CONCRETO: FabricaMotos
 *
 * En esta fábrica conocen SU TRABAJO, que es fabricar MOTOS
 * Por lo que implementa el Factory Method y devuelve el objeto de tipo Moto
 *
 * Fíjate que el método devuelve "Vehiculo" (la interfaz), no "Moto".
 * Eso es la clave: el contrato es general, la implementación es específica.
 *
 */
public class FabricaMotos extends FabricaVehiculo {

    @Override
    public Vehiculo crearVehiculo(String nombre) {
        System.out.println("[FabricaMotos]: Creando una moto de la marca: "+nombre);
        return new Moto(nombre, Boolean.FALSE); // # Aquí decidimos que creamos una Moto.
    }
}
