package patrones_creacionales.singleton;

/**
 * SINGLETON THREAD-SAFE
 *  ¿Qué es el Thread-Safe? Es la solución a una problemática que rompería
 *  el patrón Singleton. Imaginemos que 2 hilos (llamemoslos 'usuarios)
 *  llegan al mismo tiempo por primera vez, sin protección, ambos podrían
 *  crear su propia instancia al mismo tiempo, y esto rompería el patrón Singlenton.
 *
 *  SOLUCIÓN: Usar "synchronized" para que solo un hilo a la vez pueda entrar
 *  en la zona crítica de creación.
 *  --------------------------------------------------------------------------------
 *
 *  Caso de uso: GestorConexionBD
 *  En ese caso de uso REAL del Singleton: Gestionaremos la conexión de una base de datos.
 *  EL objetivo no es abrir una conexión diferente para cada usuario si tenemos 500 usuarios.
 *  Con una conexión reutilizable tendríamos suficiente.
 */

public class GestorConexionBD {

    /**
     * 'volatile' garantiza que todos los hilos vean el valor actualizado
     * de la variable, es una parte del mecanismo thread-safe.
     */
    private static volatile GestorConexionBD instancia = null;

    // - Simulamos datos de conexión
    private final String urlBaseDatos;
    private final String usuario;
    private int totalConexionesAbiertas;
    private boolean conectado;

    // - Constructor privado --| nadie puede hacer "new GestorConexionBD()"
    private GestorConexionBD() {
        System.out.println("🔌 [GestorConexionBD] Inicializando gestor de base de datos...");
        this.urlBaseDatos = "jdbc:mysql://localhost:3306/miapp";
        this.usuario = "admin";
        this.totalConexionesAbiertas = 0;
        this.conectado = false;
        System.out.println("[GestorConexionBD] Gestor listo.");
    }

    /**
     * Método getInstance() (ejecuta el thread-safe) con Double-Checked Locking
     *
     * Se comprueba dos veces si la instancia es null:
     *  - 1ª comprobación (fuera del synchrnizaed): evita bloquear si ya existe -> rápido
     *  - 2ª comprobación (dentro del synchronized): evita la doble creación entre hilos -> seguro
     */
    public static GestorConexionBD getInstance() {
        // - 1ª comprobación (sin bloqueo)
        if(instancia == null){
            // - Solo un hilo entra aquí a la vez
            synchronized (GestorConexionBD.class){
                // - 2ª comprobación (con bloqueo)
                if(instancia == null){
                    instancia = new GestorConexionBD();
                }
            }
        }
        return instancia;
    }

    /**
     * Métodos que simulan operaciones reales con la BD
     */

    public void conectar(){
        if(!conectado){
            System.out.println("🟢 Conectando a: " + urlBaseDatos + " como usuario '" + usuario + "'...");
            conectado = true;
            totalConexionesAbiertas++;
            System.out.println("✅ ¡Conexión establecida! (Total conexiones históricas: " + totalConexionesAbiertas + ")");
        } else {
            System.out.println("ℹ️  Ya estás conectado. Reutilizando la conexión existente.");
        }
    }

    public void desconectar(){
        if(conectado){
            System.out.println("🔴 Desconectando de la base de datos...");
            conectado = false;
        }
    }

    public void ejecutarConsulta(String sql){
        if (!conectado) {
            System.out.println("❌ Error: no hay conexión activa. Llama a conectar() primero.");
            return;
        }
        System.out.println("📊 Ejecutando consulta: " + sql);
        System.out.println("   → Resultado: [datos simulados de la BD]");
    }

    public boolean isConectado() {
        return conectado;
    }

    public String getUrlBaseDatos() {
        return urlBaseDatos;
    }

    @Override
    public String toString() {
        return "🗄️  GestorBD → URL: " + urlBaseDatos +
                " | Estado: " + (conectado ? "🟢 Conectado" : "🔴 Desconectado") +
                " | Conexiones históricas: " + totalConexionesAbiertas;
    }
}
