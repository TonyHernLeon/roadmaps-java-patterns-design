package patrones_creacionales.singleton;

/**
 *  # SINGLETON: ConfiguracionApp
 *
 *  Esta clase representa la configuración global de una aplicación.
 *  Solo puede existir UNA instancia de esta clase en todo el programa.
 *
 *  Esto es debido a que si hubiera dos objetos de configuración, podrían
 *  tener distintos valores, y por lo tanto se generaría conflictos en la
 *  aplicación.
 *
 *  ---------------------------------------------------------------------
 *  * Los 3 necesarios para en un Singleton:
 *      1. Constructor PRIVADO -> Nadie de fuera puede hacer "new ConfiguracionApp().
 *      2. Variable estática privada -> guarda LA única instancia dentro de la clase
 *      3. Método estático público "getInstance()" -> la única puerta de entrada
 *  ---------------------------------------------------------------------
 */
public class ConfiguracionApp {
    private static ConfiguracionApp instancia = null;

    //- Datos de la configuración de ejemplo
    private String idioma;
    private String tema;
    private String version;
    private int volumen;

    private ConfiguracionApp() {
        System.out.println(" [ConfiguracionApp] Cargando configuracion por primera vez...");

        this.idioma = "Español";
        this.tema = "Oscuro";
        this.version = "1.0.0";
        this.volumen = 75;

        System.out.println(" [ConfiguracionApp] ¡Configuración Lista!");
    }

    public static ConfiguracionApp  getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracionApp();
        }
        return instancia;
    }
    // ---------------------------------------------------------------
    // Getters y Setters normales
    // ---------------------------------------------------------------
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) {
        System.out.println("🌍 Cambiando idioma de '" + this.idioma + "' a '" + idioma + "'");
        this.idioma = idioma;
    }

    public String getTema() { return tema; }
    public void setTema(String tema) {
        System.out.println("🎨 Cambiando tema de '" + this.tema + "' a '" + tema + "'");
        this.tema = tema;
    }

    public int getVolumen() { return volumen; }
    public void setVolumen(int volumen) {
        System.out.println("🔊 Cambiando volumen de " + this.volumen + " a " + volumen);
        this.volumen = volumen;
    }

    public String getVersion() { return version; }

    @Override
    public String toString() {
        return "📋 Configuración actual → " +
                "Idioma: " + idioma +
                " | Tema: " + tema +
                " | Volumen: " + volumen +
                " | Versión: " + version;
    }
}


