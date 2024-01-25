package org.example.models;

import lombok.Data;

@Data
public class Jugador {
    //Atributos
    private String nombre;
    private int posicionX;
    private int posicionY;

    //Constructor que instancia directamente el nombre y las posiciones
    public Jugador() {
        this.nombre = "Jugador";
        this.posicionX = (int) Math.floor(Math.random() * 30);
        this.posicionY = (int) Math.floor(Math.random() * 30);
    }

    /**
     * Método que comprueba si el jugador ha llegado al máximo de posiciones
     * @param posicion
     * @return
     */
    public boolean comprobarMaximo(int posicion){
        boolean maximo = false;
        if(posicion >= 30){
            maximo = true;
        }
        return maximo;
    }
}
