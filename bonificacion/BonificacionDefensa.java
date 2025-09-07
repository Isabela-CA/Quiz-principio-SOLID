/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bonificacion;

import modelo.Equipo;
import modelo.Jugador;

/**
 *
 * @author USER
 */
public class BonificacionDefensa implements EstrategiaBonificacion {
    public String calcular(Jugador jugador) {
        return "Bonificación estándar para Defensa: " + jugador.getNombre();
    }

    @Override
    public double calcular(Equipo equipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
