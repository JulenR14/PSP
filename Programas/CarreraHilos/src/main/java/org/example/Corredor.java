package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Corredor {
    private String simbolo;
    private int velocidadBase;
    private int posibilidadTurbo;
    private int probabilidadChocar;
    private int posicion;

    public Corredor(String simbolo, int velocidadBase, int valorTurbo, int probabilidadChocar) {
        this.simbolo = simbolo;
        this.velocidadBase = velocidadBase;
        this.posibilidadTurbo = valorTurbo;
        this.probabilidadChocar = probabilidadChocar;
        this.posicion = 0;
    }

    public synchronized boolean avanzar(int valorFinal){
        if(this.posicion < valorFinal) {
            if (Math.random() < this.posibilidadTurbo / 10.) {
                this.posicion += velocidadBase;
            }
            this.posicion += velocidadBase;
        }
        return this.posicion < valorFinal;
    }

    public synchronized boolean retroceder(int valorFinal){
        if(this.posicion < valorFinal) {
            if (Math.random() < this.probabilidadChocar/ 10.) {
                this.posicion -= velocidadBase;
            }
        }
        return this.posicion < valorFinal;
    }

    public String toString(){
        return this.simbolo;
    }
}
