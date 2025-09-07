/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportes;

import java.util.List;
import modelo.Arbitro;
import modelo.Equipo;

/**
 *
 * @author USER
 */
public class ReporteTexto implements Reporte{
    public String generar(List<Equipo> equipos, List<Arbitro> arbitros) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== Reporte en formato TEXTO ===\n");

        sb.append("\nResumen de Equipos:\n");
        for (Equipo e : equipos) {
            sb.append("- ").append(e.getNombre())
              .append(" (").append(e.getJugadores()).append(" jugadores)\n");
        }

        sb.append("\nResumen de Árbitros:\n");
        for (Arbitro a : arbitros) {
            sb.append("- ").append(a.getNombre()).append("\n");
        }
        return sb.toString();
    }
}
