/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bonificacion;

import java.util.List;
import modelo.Equipo;

/**
 *
 * @author USER
 */
public class CalculadoraBonificaciones {
    private EstrategiaBonificacion estrategia;

    public CalculadoraBonificaciones() {
        this.estrategia = new BonificacionDelantero(); // estrategia por defecto
    }

    public void setEstrategia(EstrategiaBonificacion estrategia) {
        this.estrategia = estrategia;
    }

    public void calcularBonificaciones(List<Equipo> equipos) {
        System.out.println("\n=== Cálculo de Bonificaciones ===");
        for (Equipo e : equipos) {
            double bonificacion = estrategia.calcular(e);
            System.out.println("Equipo " + e.getNombre() + " recibe $" + bonificacion);
        }
    }
}
