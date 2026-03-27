package patrones_creacionales.factory_method;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     PATRÓN FACTORY METHOD - DEMO         ║");
        System.out.println("╚══════════════════════════════════════════╝");

        /** * ###################################################
            * ## EJEMPLO 1: FabricaCoches. Usamos la fabrica de coches.
            * Ejemplo claro de Polimorfismo, la variable es del tipo FabricaVehiculo
            * (el padre asbtracto) pero apunta a FabricaCoches (El concreto)
            * ####################################################
         */
        System.out.println("\n ## EJEMPLO 1: Fabricando un coche.");
        FabricaVehiculo fabrica = new FabricaCoches();
        fabrica.entregarVehiculo("Toyota Corolla TS");

        /**  * ###################################################
             * ## EJEMPLO 2: FabricaMotos. Cambiamos a la fabrica de motos
             *  Como podemos ver, este ejemplo es igual al anterior, lo único
             *  que ahora creremos motos. ¡Pero no cambiamos nada del proceso!
             * ####################################################
         */
        System.out.println("\n ## EJEMPLO 2: Fabricando una moto.");
        fabrica = new FabricaMotos();
        // # Reutilizamos el objeto fabrica para que ahora sea una fabrica de Motos
        fabrica.entregarVehiculo("Kawasaki z900");

        /**  * ###################################################
             * ## EJEMPLO 3: Fabricando Vehiculos en bucle...
             *  Aquí podemos comprobar el poder real de Factory Method
             *  ya que trataremos a todos como FabricaVehiculo
             * ####################################################
         */
        System.out.println("\n ## EJEMPLO 3: Línea de producción mixta.");
        FabricaVehiculo[] lineaDeProduccion = {new FabricaCoches(),
                new FabricaMotos(),
                new FabricaCoches(),
                new FabricaMotos()
        };
        String[] nombres = {"Seat Ibiza", "Yamaha MT07","Toyota GR86", "KTM 990"};
        for (int i = 0; i < lineaDeProduccion.length; i++) {
            lineaDeProduccion[i].entregarVehiculo(nombres[i]);
        }
        System.out.println("¡Producción del día completada!");

    }
}