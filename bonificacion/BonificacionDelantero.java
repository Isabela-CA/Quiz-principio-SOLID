/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bonificacion;

import modelo.Equipo;
import modelo.Jugador;
import modelo.Posicion;

/**
 *
 * @author USER
 */
public class BonificacionDelantero implements EstrategiaBonificacion {

    @Override
    public double calcular(Equipo equipo) {
        double bonificacion = 0.0;
        for (Jugador j : equipo.getJugadores()) {
            if (j.getPosicion() == Posicion.DELANTERO) {
                bonificacion += 200.0; // Bonificación especial para delanteros
            }
        }
        return bonificacion;
    }
}
