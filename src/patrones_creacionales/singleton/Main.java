package patrones_creacionales.singleton;

public class Main {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║       PATRÓN SINGLETON - DEMO            ║");
        System.out.println("╚══════════════════════════════════════════╝");

        // ================================================================
        // DEMO 1: ConfiguracionApp — La prueba de que es el mismo objeto
        // ================================================================
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📌 DEMO 1: Singleton de Configuración");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        System.out.println("→ Obteniendo instancia por PRIMERA vez:");
        ConfiguracionApp config1 = ConfiguracionApp.getInstance();

        System.out.println("\n→ Obteniendo instancia por SEGUNDA vez:");
        ConfiguracionApp config2 = ConfiguracionApp.getInstance();

        System.out.println("\n→ Obteniendo instancia por TERCERA vez:");
        ConfiguracionApp config3 = ConfiguracionApp.getInstance();

        System.out.println("\n--- PRUEBA DEFINITIVA ---");
        System.out.println("¿config1 == config2? → " + (config1 == config2));
        System.out.println("¿config2 == config3? → " + (config2 == config3));
        System.out.println("Hashcode config1: " + config1.hashCode());
        System.out.println("Hashcode config2: " + config2.hashCode());
        System.out.println("Hashcode config3: " + config3.hashCode());
        System.out.println("(Si los 3 números son iguales, es el mismo objeto en memoria) ✅");

        System.out.println("\n--- EFECTO: cambiar desde config1 afecta a config2 ---");
        System.out.println("Estado antes: " + config1);
        config1.setIdioma("English");
        config1.setTema("Claro");
        config1.setVolumen(50);
        System.out.println("\nLeyendo desde config2 (sin haber cambiado nada en config2!):");
        System.out.println(config2);

        // ================================================================
        // DEMO 2: GestorConexionBD — Caso de uso real
        // ================================================================
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📌 DEMO 2: Singleton de Base de Datos (Thread-Safe)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        System.out.println("→ El módulo de USUARIOS pide conexión:");
        GestorConexionBD bdUsuarios = GestorConexionBD.getInstance();
        bdUsuarios.conectar();
        bdUsuarios.ejecutarConsulta("SELECT * FROM usuarios WHERE activo = 1");

        System.out.println("\n→ El módulo de PEDIDOS pide conexión:");
        GestorConexionBD bdPedidos = GestorConexionBD.getInstance();
        bdPedidos.conectar();
        bdPedidos.ejecutarConsulta("SELECT * FROM pedidos WHERE estado = 'pendiente'");

        System.out.println("\n→ El módulo de INFORMES pide conexión:");
        GestorConexionBD bdInformes = GestorConexionBD.getInstance();
        bdInformes.conectar();
        bdInformes.ejecutarConsulta("SELECT COUNT(*) FROM ventas");

        System.out.println("\n--- PRUEBA: ¿Son el mismo objeto los 3 módulos? ---");
        System.out.println("bdUsuarios == bdPedidos?  → " + (bdUsuarios == bdPedidos));
        System.out.println("bdPedidos  == bdInformes? → " + (bdPedidos  == bdInformes));

        System.out.println("\nEstado final del gestor:");
        System.out.println(bdUsuarios);
        bdUsuarios.desconectar();

        System.out.println("\n✅ ¡Demo completada!");
    }
}
