package org.example;

import java.util.ArrayList;

public class VerCarrera extends Thread{
    private Carrera carrera;
    private PosicionesCorredores posicionesCorredores;
    private int corredores;

    public VerCarrera(Carrera carrera, PosicionesCorredores posiciones){
        this.carrera = carrera;
        this.posicionesCorredores = posiciones;
        this.corredores = carrera.getListaCorredores().size();
    }

    @Override
    public void run(){
        while(posicionesCorredores.tamanoCorredores() < corredores){
            try {
                System.out.println(carrera.toString());
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
