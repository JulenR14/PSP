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

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getVelocidadBase() {
        return velocidadBase;
    }

    public void setVelocidadBase(int velocidadBase) {
        this.velocidadBase = velocidadBase;
    }

    public int getPosibilidadTurbo() {
        return posibilidadTurbo;
    }

    public void setPosibilidadTurbo(int posibilidadTurbo) {
        this.posibilidadTurbo = posibilidadTurbo;
    }

    public int getProbabilidadChocar() {
        return probabilidadChocar;
    }

    public void setProbabilidadChocar(int probabilidadChocar) {
        this.probabilidadChocar = probabilidadChocar;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public synchronized boolean avanzar(int valorFinal){
        if(this.posicion < valorFinal) {
            if ((int) (Math.random() * 10) < this.posibilidadTurbo) {
                this.posicion += (velocidadBase * 2);
            } else {
                this.posicion += velocidadBase;
            }
        }
        return this.posicion < valorFinal;
    }

    public synchronized void retroceder(){
        if((this.posicion - velocidadBase) >= 0){
            this.posicion -= velocidadBase;
        }else{
            this.posicion = 0;
        }
    }

    public String toString(){
        return this.simbolo;
    }
}
