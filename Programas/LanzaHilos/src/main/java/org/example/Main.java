package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int NUM_HILOS=500;
        EjecutarTareaCompleja op;
        for (int i=0; i<NUM_HILOS; i++)
        {
            op=new EjecutarTareaCompleja ("Operacion "+i);
            Thread hilo=new Thread(op);
            hilo.start();
        }

    }
}