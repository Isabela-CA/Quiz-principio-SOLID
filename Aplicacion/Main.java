/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplicacion;

import reportes.ReporteHtml;
import reportes.ReporteTexto;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
        GestorCampeonato gestor = new GestorCampeonato();

        gestor.ejecutar();

        // Generar reportes
        gestor.generarReportes(new ReporteTexto());
        gestor.generarReportes(new ReporteHtml());
    }
}
