package patrones_creacionales.factory_method;

/**
 * PRODUCTO ABSTRACTO
 *
 * Con esta interfaz generamos el "contrato" que todas las subclases tienen que cumplir
 * No importa el objecto que sea, en el ambito de 'Vehículos' podemos hablar de 'Coche',
 * 'Moto', 'Quad'... todos deben saber hacer lo que se indica aquí.
 *
 * Usamos una interfaz, porque no nos interesa que el código que usa vehículos sepa, ni le importe,
 * si es un coche, una moto, un avión... Sola sabe que es un 'Vehículo'
 */
public interface Vehiculo {

    // - Todos los vehículos sabrán arrancar, pero cada uno a su manera.
    void arrancar();

    // - Todos los vehículos sabrán dar información sobre ellos mismos
    void describirse();
}
