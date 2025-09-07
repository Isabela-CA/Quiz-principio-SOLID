### Desarrollo QUIZ

ISABELA CARRILLO AZAIN

BRAYAN JAVIER MANTILLA MENDOZA

### 1.  Principio SINGLE RESPONSIBILITY PRINCIPLE (SRP)

Fragmento de código donde se viola el principio.

```java
public class GestorCampeonato {
    public void registrarParticipantes() { ... }
    public void calcularBonificaciones() { ... }
    public void generarReportes(String formato) { ... }
}
```

La clase GestorCampeonato **hace demasiadas cosas**:  
- Gestiona equipos y árbitros.  
- Calcula bonificaciones.  
- Genera reportes en diferentes formatos.  

Esto viola SRP porque cualquier cambio en cálculo de bonificaciones o en reportes forzaría a modificar `GestorCampeonato`.  

### Refactorización
Es necesario crear clases separadas para que NO se vea perjudicado el funcionamiento del código
- `RegistroParticipantes` para registrar equipos y árbitros.  
- `CalculadoraBonificaciones` para cálculo de bonificaciones.  
- `GeneradorReportes` para la generación de reportes.  

```java
class RegistroParticipantes {
    public void registrar(List<Equipo> equipos, List<Arbitro> arbitros) {
        System.out.println("=== Registro de Participantes ===");

        System.out.println("\nEquipos:");
        for (Equipo e : equipos) {
            System.out.println("Equipo: " + e.getNombre());
            for (Jugador j : e.getJugadores()) {
                System.out.println("  Jugador: " + j.getNombre());
            }
        }

        System.out.println("\nÁrbitros:");
        for (Arbitro a : arbitros) {
            System.out.println("Árbitro: " + a.getNombre());
        }
    }
}

// --- Clase para calcular bonificaciones ---
class CalculadoraBonificaciones {
    public void calcular(List<Equipo> equipos) {
        System.out.println("\n=== Cálculo de Bonificaciones ===");
        for (Equipo e : equipos) {
            double bonificacion = e.getJugadores().size() * 100.0;
            System.out.println("Equipo " + e.getNombre() + " recibe $" + bonificacion);
        }
    }
}

// --- Clase para generar reportes ---
class GeneradorReportes {
    public void generar(String formato, List<Equipo> equipos, List<Arbitro> arbitros) {
        System.out.println("\n=== Reporte en formato " + formato + " ===");

        System.out.println("\nResumen de Equipos:");
        for (Equipo e : equipos) {
            System.out.println("- " + e.getNombre() + " (" + e.getJugadores().size() + " jugadores)");
        }

        System.out.println("\nResumen de Árbitros:");
        for (Arbitro a : arbitros) {
            System.out.println("- " + a.getNombre());
        }

        System.out.println(">>> Reporte generado exitosamente en formato " + formato);
    }
}
```

---

### 2. **Principio Abierto/Cerrado (OCP)**  
Fragmento de código donde se viola el principio

```java
public void generarReportes(String formato) {
    if (formato.equalsIgnoreCase("TEXTO")) {
        ...
    } else if (formato.equalsIgnoreCase("HTML")) {
        ...
    }
}
```

###  Refactorización
Creamos una interfaz `Reporte` y clases concretas para cada formato:  

```java
interface Reporte {
    void generar(List<Equipo> equipos, List<Arbitro> arbitros);
}

class ReporteTexto implements Reporte {
    public void generar(List<Equipo> equipos, List<Arbitro> arbitros) { ... }
}

class ReporteHtml implements Reporte {
    public void generar(List<Equipo> equipos, List<Arbitro> arbitros) { ... }
}
```

### 3.  Principio de Sustitución de Liskov (LSP)

En el código original, `GestorCampeonato` usaba condicionales para cambiar el comportamiento de los reportes según el formato.

```java
public void generarReportes(String formato) {
    if (formato.equalsIgnoreCase("TEXTO")) { ... }
    else if (formato.equalsIgnoreCase("HTML")) { ... }
}
```
Se espera que cualquier “generador de reportes” produzca un reporte válido, pero la implementación estaba acoplada a `if/else`. Si un nuevo tipo no cumple exactamente las expectativas, se rompe el flujo.

### Refactorización

Se crea una interfaz común `Reporte` y cada implementación (`ReporteTexto`, `ReporteHtml`) cumple con el mismo contrato. Así, cualquier clase nueva puede sustituir a otra sin problemas.

```java
interface Reporte {
    void generar(List<Equipo> equipos, List<Arbitro> arbitros);
}

class ReporteTexto implements Reporte {
    @Override
    public void generar(List<Equipo> equipos, List<Arbitro> arbitros) {
        System.out.println("--- Reporte del Campeonato (TEXTO) ---");
        for (Equipo e : equipos) {
            System.out.println("Equipo: " + e.getNombre());
        }
        for (Arbitro a : arbitros) {
            System.out.println("Árbitro: " + a.getNombre());
        }
    }
}

class ReporteHtml implements Reporte {
    @Override
    public void generar(List<Equipo> equipos, List<Arbitro> arbitros) {
        System.out.println("<html><body>");
        System.out.println("<h1>Reporte del Campeonato</h1>");
        for (Equipo e : equipos) {
            System.out.println("<p>Equipo: " + e.getNombre() + "</p>");
        }
        for (Arbitro a : arbitros) {
            System.out.println("<p>Árbitro: " + a.getNombre() + "</p>");
        }
        System.out.println("</body></html>");
    }
}
```

### 4. Principio de Segregación de Interfaces (ISP)

En el original, había un solo método `generarReportes(String formato)` que obligaba al cliente a conocer formatos innecesarios.

Los clientes de `GestorCampeonato` estan limitados a depender de una interfaz “gorda” (un único método con lógica para todos los formatos). Esto no es flexible.

### Refactorización

En lugar de una sola interfaz para todos los reportes, cada implementación se limita a lo que sabe hacer: generar su propio tipo de reporte. Así el cliente sólo depende de la interfaz Reporte que es mínima

```java
interface Reporte {
    void generar(List<Equipo> equipos, List<Arbitro> arbitros);
}
```
