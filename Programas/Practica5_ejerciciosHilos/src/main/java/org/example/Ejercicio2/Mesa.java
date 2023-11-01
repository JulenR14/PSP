package org.example.Ejercicio2;

public class Mesa {
    boolean palillosLibres[];

    public Mesa(){
        palillosLibres = new boolean[5];
        for(int i = 0; i < 5; i++){
            palillosLibres[i] = true;
        }
    }

    public synchronized boolean cogerPalillos(int palillo1, int palillo2){
        boolean cogidos = false;
        if(this.palillosLibres[palillo1] && this.palillosLibres[palillo2]){
            this.palillosLibres[palillo1] = false;
            this.palillosLibres[palillo2] = false;
            cogidos = true;
        }
        return cogidos;
    }

    public synchronized void soltarPalillos(int palillo1, int palillo2){
        this.palillosLibres[palillo1] = true;
        this.palillosLibres[palillo2] = true;
    }
}
