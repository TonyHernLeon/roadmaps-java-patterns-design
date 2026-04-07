# 🧬 Prototype

## ¿Qué problema resuelve? (Explicación Dummy)

Imagina que eres diseñador gráfico y tienes un logo perfectamente maquetado
con capas, efectos y colores. Cuando necesitas una variante, no empiezas de
cero: haces **"Duplicar capa"** y modificas la copia.

Eso es el Prototype: **clonar un objeto ya construido** para obtener uno nuevo
sin tener que pasar por todo el proceso de construcción otra vez.

**¿Cuándo construir desde cero es "caro"?**
- Cargar datos de una base de datos
- Leer ficheros de configuración del disco
- Calcular estadísticas complejas al inicializar
- Descargar recursos de red

Con Prototype, ese coste se paga **una sola vez** (al crear el prototipo),
y luego clonas tan rápido como quieras.

---

## ¿Cuándo usarlo?

- Cuando crear un objeto desde cero es muy costoso (tiempo o recursos).
- Cuando necesitas muchos objetos similares con pequeñas variaciones.
- Cuando quieres evitar subclases para cada combinación posible de atributos.
- En videojuegos: spawning de enemigos, generación de mapas, inventario de ítems.

---

## Estructura del patrón

```
«abstract»
Personaje                        ← Prototype Abstracto
  # nombre, vida, ataque...
  + Personaje(otro: Personaje)   ← Constructor de copia
  + clonar(): Personaje *        ← EL MÉTODO CLAVE (abstracto)
       ▲                  ▲
       |                  |
  Guerrero              Mago     ← Prototipos Concretos
  + clonar()            + clonar()
    → new Guerrero(this)  → new Mago(this)


RegistroPersonajes               ← Registro opcional (muy útil)
  - prototipos: Map<String, Personaje>
  + registrar(clave, personaje)
  + obtenerClon(clave): Personaje  ← Devuelve SIEMPRE una copia
```

---

## Archivos de este paquete

| Archivo | Rol en el patrón | Descripción |
|---|---|---|
| `Personaje.java` | Prototype Abstracto | Clase base con el método `clonar()` abstracto |
| `Guerrero.java` | Prototype Concreto | Sabe clonarse; tiene atributo propio `tipoArma` |
| `Mago.java` | Prototype Concreto | Sabe clonarse; tiene `escuelaMagia` y `mana` |
| `RegistroPersonajes.java` | Registro | Almacena prototipos listos para clonar |
| `Main.java` | Cliente | 3 demos progresivas del patrón |

---

## ¿Cómo ejecutarlo?

1. Coloca los archivos en `patrones_creacionales/prototype/`
2. Ejecuta `Main.java`
3. Observa las 3 demos:

```
📌 DEMO 1: Clonación básica
   Original: ⚔️ Guerrero | Thor | Vida: 500 | Arma: Martillo
   Clon:     ⚔️ Guerrero | Thor Jr. | Vida: 300 | Arma: Hacha
   ¿Son el mismo objeto? → false  ✅

📌 DEMO 2: Prototype ahorra tiempo
   Inicialización costosa: se ejecuta UNA vez (100ms)
   3 clones creados en: 0ms  ← ¡Instantáneo!

📌 DEMO 3: Registro de Prototipos
   Spawneando 4 enemigos desde 2 prototipos base...
   ¿enemigo1 == enemigo2? → false  ✅
```

---

## El truco del Constructor de Copia

La implementación más clara del Prototype en Java usa un **constructor de copia**:

```java
// En Guerrero.java:

// Constructor normal (crea desde cero)
public Guerrero(String nombre, int vida, ..., String tipoArma) {
    super(nombre, vida, ...);
    this.tipoArma = tipoArma;
}

// Constructor de copia (clona otro Guerrero)
public Guerrero(Guerrero otro) {
    super(otro);               // Copia los atributos del padre
    this.tipoArma = otro.tipoArma; // Copia los atributos propios
}

// El método clonar() simplemente usa el constructor de copia
@Override
public Personaje clonar() {
    return new Guerrero(this); // "this" = yo mismo → me copio
}
```

---

## ⚠️ Copia Superficial vs Copia Profunda

Esto es muy importante cuando tus objetos tienen listas u otros objetos dentro:

```java
// ❌ COPIA SUPERFICIAL (shallow copy) — PELIGROSA
//    La lista del clon y del original apuntan al MISMO sitio en memoria
this.habilidades = otro.habilidades; // ← Comparten la misma lista

// ✅ COPIA PROFUNDA (deep copy) — SEGURA
//    El clon tiene su PROPIA lista independiente
this.habilidades = new ArrayList<>(otro.habilidades); // ← Lista nueva
```

Nuestro ejemplo usa tipos primitivos (int, String), así que no hay problema.
Pero en proyectos reales, ¡ojo con los objetos anidados!

---

## Ventajas ✅

- Mucho más rápido que construir desde cero cuando la inicialización es costosa.
- Puedes crear objetos sin conocer su clase exacta (trabajas con la interfaz).
- Alternativa a la herencia para crear variantes de objetos.

## Desventajas ⚠️

- Implementar la clonación puede ser complicado con objetos muy anidados.
- Hay que tener cuidado con la diferencia entre copia superficial y profunda.
- Cada clase tiene que implementar su propio método `clonar()`.

---

## 🗺️ Roadmap de Patrones Creacionales

| # | Patrón | Estado |
|---|---|---|
| 1 | Factory Method | ✅ |
| 2 | Singleton | ✅ |
| 3 | **Prototype** | ✅ |
| 4 | Builder | ⏳ Siguiente |
| 5 | Abstract Factory | ⏳ Pendiente |

---

*Patrón creacional — GoF (Gang of Four)*
