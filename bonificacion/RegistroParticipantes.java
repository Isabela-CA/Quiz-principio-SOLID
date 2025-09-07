package bonificacion;


import java.util.List;
import modelo.Arbitro;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Posicion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class RegistroParticipantes {
    private List<Equipo> equipos;
    private List<Arbitro> arbitros;

    public RegistroParticipantes(List<Equipo> equipos, List<Arbitro> arbitros) {
        this.equipos = equipos;
        this.arbitros = arbitros;
    }

    public void registrar() {
        Equipo equipoA = new Equipo("Los Ganadores");
        equipoA.agregarJugador(new Jugador("Juan Pérez", Posicion.DELANTERO));
        equipoA.agregarJugador(new Jugador("Pedro Pan", Posicion.PORTERO));
        equipos.add(equipoA);

        Equipo equipoB = new Equipo("Los Retadores");
        equipoB.agregarJugador(new Jugador("Alicia Smith", Posicion.DEFENSA));
        equipos.add(equipoB);

        arbitros.add(new Arbitro("Miguel Díaz"));
    }
}
