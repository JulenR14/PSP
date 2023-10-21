package org.example.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> elementos = new ArrayList<>();

        Thread productor = new Thread(() -> {
            for (int i=1; i <= 10; i++) {
                if (!elementos.isEmpty()){
                    try {
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        System.err.println("Error en el productor: " + e.getMessage());
                    }
                }
                elementos.add(i);
                System.out.println("Producto añadido.");
            }
        });

        Thread consumidor = new Thread(() -> {
            for (int i=1; i <= 10; i++){
                if (elementos.isEmpty()){
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        System.err.println("Error en el consumidor: " + e.getMessage());
                    }
                }
                elementos.clear();
                System.out.println("Consumidor ha consumido.");
            }
        });

        productor.start();
        consumidor.start();

        try{
            productor.join();
            consumidor.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

}
