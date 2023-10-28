package org.example;

import java.util.ArrayList;

public class Carrera {
    private ArrayList<Corredor> listaCorredores;
    private ArrayList<ChocarCorredor> hilosChocar = new ArrayList<>();

    private ArrayList<CorrerHilo> hilosCorredores = new ArrayList<>();
    private int valorFinal = 100;
    private boolean terminarCarrera = false;

    public Carrera(ArrayList<Corredor> listaCorredores){
        this.listaCorredores = listaCorredores;
        for (Corredor corredor : listaCorredores){
            this.hilosCorredores.add(new CorrerHilo(corredor, valorFinal));
            this.hilosChocar.add(new ChocarCorredor(corredor, valorFinal));
        }
    }

    public Carrera(){}

    public ArrayList<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    public void setListaCorredores(ArrayList<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    public ArrayList<ChocarCorredor> getHilosChocar() {
        return hilosChocar;
    }

    public void setHilosChocar(ArrayList<ChocarCorredor> hilosChocar) {
        this.hilosChocar = hilosChocar;
    }

    public ArrayList<CorrerHilo> getHilosCorredores() {
        return hilosCorredores;
    }

    public void setHilosCorredores(ArrayList<CorrerHilo> hilosCorredores) {
        this.hilosCorredores = hilosCorredores;
    }

    public int getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(int valorFinal) {
        this.valorFinal = valorFinal;
    }

    public boolean getTerminarCarrera() {
        return terminarCarrera;
    }

    public void setTerminarCarrera(boolean terminarCarrera) {
        this.terminarCarrera = terminarCarrera;
    }

    public void empezarCarrera(){
        for(CorrerHilo hilo : hilosCorredores){
            hilo.start();
        }
        for(ChocarCorredor hilo : hilosChocar){
            hilo.start();
        }
    }

    public void terminarCarrera(){
        try {
            for(CorrerHilo hilo : hilosCorredores){
                hilo.join();
            }
            for(ChocarCorredor hilo : hilosChocar){
                hilo.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.terminarCarrera = true;
    }

    public void showRace(){
        StringBuilder sb = new StringBuilder();
        System.out.println("\n".repeat(20));
        System.out.println("-".repeat(this.valorFinal+3));
        for (Corredor runner : this.listaCorredores) {
            sb.setLength(0);
            sb.append("|").append(" ".repeat(runner.getPosicion())).append(runner.getSimbolo());
            sb.append(" ".repeat(this.valorFinal - runner.getPosicion())).append("|");
            System.out.println(sb);
        }
        System.out.println("-".repeat(this.valorFinal+3));
    }
}
