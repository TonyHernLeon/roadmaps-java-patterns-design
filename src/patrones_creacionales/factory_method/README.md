# 🏭 Factory Method

## ¿Qué problema resuelve? (Explicación Dummy)

Imagina que tienes una pizzería. Cuando alguien pide una pizza, tú no preparas
la pizza directamente en el mostrador — tienes una **cocina** que se encarga de eso.

Si mañana decides cambiar la receta de la pizza, solo cambias lo que hace la cocina.
El cliente sigue pidiendo "una pizza" sin saber nada del cambio.

**Eso es Factory Method**: delegar la creación de objetos a subclases, para que
el código que *usa* los objetos no sepa ni le importe *cómo* se crean.

---

## ¿Cuándo usarlo?

- Cuando no sabes de antemano qué tipo exacto de objeto necesitarás crear.
- Cuando quieres que las subclases decidan qué objeto crear.
- Cuando quieres desacoplar el código que *usa* objetos del código que los *crea*.

---

## Estructura del patrón

```
«interface»
Vehiculo                    ← Producto Abstracto
  + arrancar()
  + describir()
     ▲           ▲
     |           |
  Coche        Moto         ← Productos Concretos


«abstract»
FabricaVehiculo             ← Creador Abstracto
  + crearVehiculo() *       ← ¡EL FACTORY METHOD! (abstracto)
  + entregarVehiculo()      ← Usa el factory method internamente
     ▲               ▲
     |               |
FabricaCoches    FabricaMotos  ← Creadores Concretos
  + crearVehiculo()  + crearVehiculo()
    → new Coche()      → new Moto()
```

---

## Archivos de este paquete

| Archivo | Rol en el patrón | Descripción |
|---|---|---|
| `Vehiculo.java` | Producto Abstracto | Interfaz que todos los vehículos deben implementar |
| `Coche.java` | Producto Concreto | Implementación concreta: un coche |
| `Moto.java` | Producto Concreto | Implementación concreta: una moto |
| `FabricaVehiculo.java` | Creador Abstracto | Clase abstracta con el Factory Method |
| `FabricaCoches.java` | Creador Concreto | Fábrica que crea Coches |
| `FabricaMotos.java` | Creador Concreto | Fábrica que crea Motos |
| `patrones_creacionales.factory_method.Main.java` | Cliente | Demuestra el uso del patrón |

---

## ¿Cómo ejecutarlo?

1. Asegúrate de que todos los archivos están en el paquete `patrones_creacionales.factory_method`
2. Ejecuta la clase `patrones_creacionales.factory_method.Main.java`
3. Verás en consola cómo se fabrican diferentes vehículos

**Salida esperada (resumen):**
```
🔩 [FabricaCoches] Creando un coche llamado: Tesla Model 3
✅ Vehículo fabricado: Soy un Coche modelo: Tesla Model 3...
🚗 El coche Tesla Model 3 arranca: ¡BROOOM BROOOM!

🔧 [FabricaMotos] Creando una moto de la marca: Honda CBR
✅ Vehículo fabricado: Soy una Moto de la marca: Honda CBR...
🏍️ La moto Honda CBR arranca: ¡VRUUUM!
```

---

## La regla de oro del Factory Method

> **"Habla con interfaces, no con clases concretas"**

Tu código nunca debería hacer `new Coche()` directamente si puede evitarlo.
En su lugar, pídele a una fábrica que te dé un `Vehiculo`. Así, mañana
puedes añadir `Camion`, `Autobus`, etc. sin tocar el código existente.

---

## Ventajas ✅

- **Abierto/Cerrado**: Puedes añadir nuevos tipos de vehículos sin modificar el código existente.
- **Responsabilidad única**: Cada fábrica se ocupa de crear un solo tipo de objeto.
- **Fácil de testear**: Puedes crear fábricas falsas (mocks) en los tests.

## Desventajas ⚠️

- Puede añadir mucha complejidad si solo tienes un tipo de producto.
- Necesitas crear una subclase de fábrica por cada tipo de producto.

---

*Patrón creacional — GoF (Gang of Four)*