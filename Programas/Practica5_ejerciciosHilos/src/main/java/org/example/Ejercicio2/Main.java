package org.example.Ejercicio2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        ArrayList<Filosofo> filosofos = new ArrayList<Filosofo>(){{
            add(new Filosofo("Socrates", mesa, 0, 1));
            add(new Filosofo("Platon", mesa, 1, 2));
            add(new Filosofo("Aristoteles", mesa, 2, 3));
            add(new Filosofo("Descartes", mesa, 3, 4));
            add(new Filosofo("Kant", mesa, 4, 0));
        }};

        Thread hilos[] = new Thread[5];
        for(int i = 0; i < 5; i++){
            hilos[i] = new Thread(filosofos.get(i));
            hilos[i].start();
        }
    }
}
