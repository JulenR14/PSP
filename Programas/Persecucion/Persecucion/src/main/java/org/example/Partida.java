package org.example;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.models.Enemigo;
import org.example.models.Jugador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase partida que contiene los objetos jugador y enemigo
 * y los métodos para jugar
 */
public class Partida {

    //Atributos
    private Jugador jugador;
    private Enemigo enemigo1;
    private Enemigo enemigo2;
    private Enemigo enemigo3;
    private int movimientosJugador = 0;

    ObservableList<String> listaMovimientos = FXCollections.observableArrayList();

    //Constructor que instancia los objetos jugador y enemigo
    public Partida() {
        this.jugador = new Jugador();
        this.enemigo1 = new Enemigo();
        this.enemigo2 = new Enemigo();
        this.enemigo3 = new Enemigo();
    }

    //Método que muestra las coordenadas de los objetos
    public void mostrarCoordenadas(){
        System.out.println("Jugador: (" + this.jugador.getPosicionX() + ", " + this.jugador.getPosicionY() + ")");
        System.out.println("Enemigo: (" + this.enemigo1.getPosicionX() + ", " + this.enemigo1.getPosicionY() + ")");
        System.out.println("Enemigo: (" + this.enemigo2.getPosicionX() + ", " + this.enemigo2.getPosicionY() + ")");
        System.out.println("Enemigo: (" + this.enemigo3.getPosicionX() + ", " + this.enemigo3.getPosicionY() + ")");
    }

    /**
     * Método que inicia la partida y contiene el bucle del juego
     * @throws IOException
     */
    public void jugar() throws IOException {
        System.out.println("Posiciones iniciales de la partida : ");
        this.mostrarCoordenadas();

        //Añadimos los observadores a la lista de movimientos
        this.listaMovimientos.addListener(enemigo1);
        this.listaMovimientos.addListener(enemigo2);
        this.listaMovimientos.addListener(enemigo3);
        String movimiento = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.print("Muevete (Movimientos: a,s,d,w) o exit: para salir: ");
            movimiento = br.readLine();
            this.moverJugador(movimiento);
            this.listaMovimientos.add(this.jugador.getPosicionX() + "," + this.jugador.getPosicionY());
            this.movimientosJugador++;
            this.mostrarCoordenadas();
        }while(!this.comprobarMuerte());

        System.out.println("------------------PARTIDA TERMINADA------------------");
        System.out.println("Has muerto en " + this.movimientosJugador + " movimientos");
    }

    /**
     * Método que comprueba si el jugador ha muerto
     * @return
     */
    public boolean comprobarMuerte(){
        if(this.jugador.getPosicionX() == this.enemigo1.getPosicionX() && this.jugador.getPosicionY() == this.enemigo1.getPosicionY()
                || this.jugador.getPosicionX() == this.enemigo2.getPosicionX() && this.jugador.getPosicionY() == this.enemigo2.getPosicionY()
                || this.jugador.getPosicionX() == this.enemigo3.getPosicionX() && this.jugador.getPosicionY() == this.enemigo3.getPosicionY()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que mueve el jugador en función del movimiento
     * @param movimiento
     */
    public void moverJugador(String movimiento){
        switch (movimiento){
            case "a":
                this.jugador.setPosicionX(this.jugador.getPosicionX() - 1);
                break;
            case "s":
                this.jugador.setPosicionY(this.jugador.getPosicionY() - 1);
                break;
            case "d":
                this.jugador.setPosicionX(this.jugador.getPosicionX() + 1);
                break;
            case "w":
                this.jugador.setPosicionY(this.jugador.getPosicionY() + 1);
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Movimiento no valido");
                break;
        }

        //Comprobamos si el jugador ha llegado al máximo de posiciones para no sobrepasarlas
        if (this.jugador.comprobarMaximo(this.jugador.getPosicionX())){
            this.jugador.setPosicionX(30);
            System.out.println("Has llegado al limite del mapa en el eje X");
        }
        if (this.jugador.comprobarMaximo(this.jugador.getPosicionY())){
            this.jugador.setPosicionY(30);
            System.out.println("Has llegado al limite del mapa en el eje Y");
        }
    }
}
