package org.example;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Carrera {
    private ArrayList<Corredor> listaCorredores;
    private ArrayList<ChocarCorredor> hilosChocar;
    private ArrayList<CorrerHilo> hilosCorredores;
    private PosicionesCorredores posicionesCorredores;
    private VerCarrera verCarrera;
    private static final int valorFinal = 50;

    public Carrera(ArrayList<Corredor> listaCorredores){
        this.listaCorredores = listaCorredores;
        this.posicionesCorredores = new PosicionesCorredores();
        this.hilosCorredores = new ArrayList<>();
        this.hilosChocar = new ArrayList<>();
        for (Corredor corredor : listaCorredores){
            this.hilosCorredores.add(new CorrerHilo(corredor, valorFinal, posicionesCorredores));
            this.hilosChocar.add(new ChocarCorredor(corredor, valorFinal));
        }
        this.verCarrera = new VerCarrera(this, posicionesCorredores);
    }

    public void empezarCarrera(){
        for(CorrerHilo hilo : hilosCorredores){
            hilo.start();
        }
        for(ChocarCorredor hilo : hilosChocar){
            hilo.start();
        }
        verCarrera.start();
    }

    public void terminarCarrera(){
        try {
            for(CorrerHilo hilo : hilosCorredores){
                hilo.join();
            }
            for(ChocarCorredor hilo : hilosChocar){
                hilo.join();
            }
            verCarrera.join();

            System.out.println("La carrera ha terminado");
            for(int i = 0; i < posicionesCorredores.tamanoCorredores(); i++){
                System.out.println("El corredor " + posicionesCorredores.getCorredor(i) + " ha quedado en la posicion " + (i+1));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        String mostrar = "\r\n".repeat(10) + "*".repeat(52) + "\r\n";
        for (Corredor runner: this.listaCorredores) {
            mostrar += "*" + " ".repeat(runner.getPosicion()) + runner.getSimbolo() + " ".repeat(Math.max(valorFinal - runner.getPosicion()-1, 0)) + "*\r\n";
        }
        mostrar += "*".repeat(52) + "\r\n";
        return mostrar;
    }
}
