# 🔒 Singleton

## ¿Qué problema resuelve? (Explicación Dummy)

Imagina que en tu empresa solo hay **una impresora** compartida. No importa cuántos
empleados intenten usarla, todos se conectan a **la misma impresora**. No se crea
una impresora nueva por cada empleado.

Eso es el Singleton: **garantizar que solo exista UNA instancia de una clase**,
y proporcionar un punto de acceso global a ella.

**Ejemplos del mundo real:**
- La configuración de una aplicación (un solo objeto con todos los ajustes)
- La conexión a una base de datos (no queremos abrir 1000 conexiones)
- Un sistema de logs (todos los módulos escriben en el mismo fichero)
- El carrito de compra en una sesión de usuario

---

## ¿Cuándo usarlo?

- Cuando necesitas exactamente **una sola instancia** de una clase en toda la app.
- Cuando esa instancia necesita ser accesible desde cualquier parte del código.
- Cuando crear el objeto varias veces sería costoso (BD, ficheros, configuración...).

---

## Los 3 ingredientes obligatorios

```
┌─────────────────────────────────────────────────────────┐
│                   MiClaseSingleton                      │
├─────────────────────────────────────────────────────────┤
│ - instancia: MiClaseSingleton  ← (2) Variable estática │
├─────────────────────────────────────────────────────────┤
│ - MiClaseSingleton()           ← (1) Constructor PRIVADO│
│ + getInstance(): MiClaseSingleton ← (3) Puerta de acceso│
│ + otrosMetodos()                                        │
└─────────────────────────────────────────────────────────┘
```

| # | Ingrediente | ¿Por qué? |
|---|---|---|
| 1 | Constructor `private` | Nadie de fuera puede hacer `new MiClase()` |
| 2 | Variable `static` privada | Guarda la única instancia dentro de la propia clase |
| 3 | Método `getInstance()` estático | La única puerta de entrada para obtener la instancia |

---

## Archivos de este paquete

| Archivo | Descripción |
|---|---|
| `ConfiguracionApp.java` | Singleton básico. Configuración global de la app |
| `GestorConexionBD.java` | Singleton thread-safe (Double-Checked Locking). Caso real |
| `Main.java` | Demuestra que siempre es el mismo objeto en memoria |

---

## ¿Cómo ejecutarlo?

1. Coloca los archivos en `patrones_creacionales/singleton/`
2. Ejecuta `Main.java`

**Lo que verás:**
```
→ Obteniendo instancia por PRIMERA vez:
⚙️  [ConfiguracionApp] Cargando configuración por primera vez...
✅ [ConfiguracionApp] ¡Configuración lista!

→ Obteniendo instancia por SEGUNDA vez:
→ Obteniendo instancia por TERCERA vez:
(No aparece nada — no se crea ningún objeto nuevo)

Hashcode config1: 123456789
Hashcode config2: 123456789   ← ¡El mismo número!
Hashcode config3: 123456789   ← ¡El mismo número!
```

El **hashCode** es como el DNI del objeto en memoria. Si los tres son iguales,
es 100% el mismo objeto. Esa es la prueba definitiva. ✅

---

## Dos versiones del Singleton

### Versión Simple (ConfiguracionApp)
```java
public static ConfiguracionApp getInstance() {
    if (instancia == null) {
        instancia = new ConfiguracionApp();
    }
    return instancia;
}
```
✅ Fácil de entender  
⚠️ No es segura si varios hilos llegan a la vez (no thread-safe)

### Versión Thread-Safe (GestorConexionBD)
```java
private static volatile GestorConexionBD instancia = null;

public static GestorConexionBD getInstance() {
    if (instancia == null) {
        synchronized (GestorConexionBD.class) {
            if (instancia == null) {
                instancia = new GestorConexionBD();
            }
        }
    }
    return instancia;
}
```
✅ Segura con múltiples hilos (aplicaciones reales)  
✅ Eficiente: solo bloquea cuando realmente hace falta  
📌 Usa `volatile` + `synchronized` + doble comprobación

---

## Ventajas ✅

- Acceso global controlado a un recurso compartido.
- La instancia solo se crea cuando se necesita (lazy initialization).
- Ahorra recursos (no se crean objetos innecesarios).

## Desventajas ⚠️

- Puede dificultar los tests unitarios (es estado global).
- Si se abusa, el código se vuelve difícil de mantener.
- En sistemas multi-hilo necesita cuidado extra (usar la versión thread-safe).

---

## Relación con otros patrones

> El **Abstract Factory**, **Builder** y **Prototype** a menudo se implementan
> como Singletons. Por ejemplo: la fábrica de objetos suele ser única en toda la app.

---

*Patrón creacional — GoF (Gang of Four)*
