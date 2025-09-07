/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reportes;

import java.util.List;
import modelo.Arbitro;
import modelo.Equipo;

/**
 *
 * @author USER
 */
public interface Reporte {
    String generar(List<Equipo> equipos, List<Arbitro> arbitros);    
}
