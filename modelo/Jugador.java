/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Jugador {
    private String nombre;
    private Posicion posicion;
    
    public Jugador(String nombre, Posicion posicion){
        this.nombre = nombre;
        this.posicion = posicion;
    }
    public String getNombre() {
        return nombre;
    }
    public Posicion getPosicion() {
        return posicion;
    }    

}
