package org.example.models;

import javafx.collections.ListChangeListener;
import lombok.Data;

@Data
public class Enemigo implements ListChangeListener<String> {

    //Atributos
    private String nombre;
    private int posicionX;
    private int posicionY;

    //Constructor que instancia directamente el nombre y las posiciones
    public Enemigo() {
        this.nombre = "Enemigo";
        this.posicionX = (int) Math.floor(Math.random() * 30);
        this.posicionY = (int) Math.floor(Math.random() * 30);
    }

    /**
     * Método que escucha los cambios de la lista de movimientos del jugador
     * cuando se añade un movimiento del jugador se ejecuta este método
     * y mueve el enemigo hacia el jugador
     * @param change
     */
    @Override
    public void onChanged(Change<? extends String> change) {
        //Almacenamos en dos variables las posiciones del jugador actualizadas
        int pJugadorX = Integer.parseInt(change.getList().get(change.getList().size()-1).split(",")[0]);
        int pJugadorY = Integer.parseInt(change.getList().get(change.getList().size()-1).split(",")[1]);

        //realizamos todas las comprobaciones para mover el enemigo hacia el jugador
        if (this.posicionX == pJugadorX || this.posicionY == pJugadorY){
            if (this.posicionY == pJugadorY){
                if ((this.posicionX - pJugadorX) >= 2){
                    this.posicionX -= 2;
                }else if ((this.posicionX - pJugadorX) <= -2){
                    this.posicionX += 2;
                }
            }
            if (this.posicionX == pJugadorX){
                if ((this.posicionY - pJugadorY) >= 2){
                    this.posicionY -= 2;
                }else if ((this.posicionY - pJugadorY) <= -2){
                    this.posicionY += 2;
                }
            }
        }else{
            if(this.posicionX > pJugadorX){
                this.posicionX -= 1;
            } else {
                this.posicionX += 1;
            }
            if(this.posicionY > pJugadorY){
                this.posicionY -= 1;
            } else {
                this.posicionY += 1;
            }
        }

        //Comprobamos si el enemigo ha llegado al máximo de posiciones para no sobrepasarlas
        if (this.comprobarMaximo(this.posicionX)){
            this.posicionX = 30;
        }
        if (this.comprobarMaximo(this.posicionY)){
            this.posicionY = 30;
        }
    }

    /**
     * Método que comprueba si el enemigo ha llegado al máximo de posiciones
     * @param posicion
     * @return booleano que indica si ha llegado al máximo
     */
    public boolean comprobarMaximo(int posicion){
        boolean maximo = false;
        if(posicion >= 30){
            maximo = true;
        }
        return maximo;
    }
}
