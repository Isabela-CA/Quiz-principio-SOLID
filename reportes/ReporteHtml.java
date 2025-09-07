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
public class ReporteHtml implements Reporte {
    public String generar(List<Equipo> equipos, List<Arbitro> arbitros) {
        StringBuilder html = new StringBuilder();
        html.append("<html><body>\n");
        html.append("<h1>Reporte del Campeonato</h1>\n");

        html.append("<h2>Equipos</h2><ul>\n");
        for (Equipo e : equipos) {
            html.append("<li>").append(e.getNombre())
                    .append(" (").append(e.getJugadores()).append(" jugadores)</li>\n");
        }
        html.append("</ul>\n");

        html.append("<h2>Árbitros</h2><ul>\n");
        for (Arbitro a : arbitros) {
            html.append("<li>").append(a.getNombre()).append("</li>\n");
        }
        html.append("</ul>\n");

        html.append("</body></html>");
        return html.toString();
    }
    
}
