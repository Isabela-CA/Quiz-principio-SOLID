/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplicacion;

import java.util.ArrayList;
import java.util.List;
import modelo.Arbitro;
import modelo.Equipo;
import bonificacion.CalculadoraBonificaciones;
import bonificacion.RegistroParticipantes;
import reportes.Reporte;

/**
 *
 * @author USER
 */
public class GestorCampeonato {
    private List<Equipo> equipos = new ArrayList<>();
    private List<Arbitro> arbitros = new ArrayList<>();
    private RegistroParticipantes registro;
    private CalculadoraBonificaciones calculadora;

    public GestorCampeonato() {
        this.registro = new RegistroParticipantes(equipos, arbitros);
        this.calculadora = new CalculadoraBonificaciones();
    }

    public void ejecutar() {
        registro.registrar();
        calculadora.calcularBonificaciones(equipos);
    }

    public void generarReportes(Reporte reporte) {
        System.out.println(reporte.generar(equipos, arbitros));
    }
}
