package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
            CalculadoraAreas ca = new CalculadoraAreas(1, 2);
            final int MAX_HILOS = 10000;
            Thread[] hilos = new Thread[MAX_HILOS];
            for (int i = 0; i < MAX_HILOS; i++) {
                hilos[i] = new Thread(ca);
                hilos[i].start();
            }
            for (int i = 0; i < MAX_HILOS; i++) {
                hilos[i].join();
            }
            System.out.println("Total de calculos:" + ca.contador);
    }
}