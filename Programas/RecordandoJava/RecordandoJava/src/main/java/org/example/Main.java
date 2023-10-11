package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //isntanciacion de los dos arrays de 10 posiciones
        int[] diezNumeros = new int[10];
        Boolean[] diezBooleanos = new Boolean[10];

        //llamamos al metodo que devuelve el array rellenado y lo recorremos
        Arrays.stream(Utilidades.rellenarArrayNumerosAleatorios(diezNumeros))
                .forEach(System.out::println);
    }
}