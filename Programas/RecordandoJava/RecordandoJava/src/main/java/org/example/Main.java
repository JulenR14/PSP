package org.example;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        //isntanciacion de los dos arrays de 10 posiciones
        int[] diezNumeros = new int[100];

        long start = System.nanoTime();

        Utilidades.rellenarArrayNumerosAleatorios(diezNumeros);

        //llamamos al metodo que devuelve el array rellenado y lo recorremos
        Arrays.stream(diezNumeros).forEach(numero -> {
            if(Utilidades.naive(numero)){
                System.out.println("Numero - " + numero + " - Es primo.");
            }else{
                System.out.println("Numero - " + numero + " - No es primo.");
            }
        });

        long end = System.nanoTime();


        double diff = end-start;

        System.out.println("Segundos : " + String.format("%.3f", (diff/1000000000))
                + ", Milisegundos : " + (diff/1000000)
                + ", Nanosegundos : " + diff);
    }
}