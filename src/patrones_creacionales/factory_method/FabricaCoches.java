package patrones_creacionales.factory_method;

/**
 * CREADOR CONCRETO: FabricaCoches
 *
 * En esta fábrica conocen SU TRABAJO, que es fabricar COCHES
 * Por lo qeu implementa el Factory Method y devuelve el objeto de tipo Coche
 *
 * Si mañana la fabrica quisiera cambiar la forma en la que fabrica los coches,
 * podría cambiarla y el resto del código no se enteraría.
 *
 */
public class FabricaCoches extends FabricaVehiculo {

    @Override
    public Vehiculo crearVehiculo(String nombre) {
        System.out.println("[FabricaCoche]: Creando el coche: "+nombre);
        return new Coche(nombre, Boolean.FALSE);
    }
}
