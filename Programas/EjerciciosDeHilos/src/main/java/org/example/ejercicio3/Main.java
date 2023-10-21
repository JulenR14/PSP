package org.example.ejercicio3;

import org.example.ejercicio1.Contador;

public class Main {

    public static void main(String[] args) {

        Contador contador = new Contador();

        Thread hilo1 = new Thread(() -> {
            bucleFor500(contador);
        });
        Thread hilo2 = new Thread(() -> {
            bucleFor500(contador);
        });
        Thread hilo3 = new Thread(() -> {
            bucleFor500(contador);
        });
        Thread hilo4 = new Thread(() -> {
            bucleFor500(contador);
        });

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("El contador final : " + contador.getContador());
    }

    public static void bucleFor500(Contador contador){
        for (int i = 0; i < 500; i++){
            contador.incrementarContador();
        }
    }

}
