package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InterfazUsuario {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static ArrayList<Corredor> agregarCorredores() {
        int cantidadCorredores;
        ArrayList<Corredor> listaCorredores = new ArrayList<>();
        String simbolo;
        int velocidadBase;
        int valorTurbo;
        int probabilidadChocar;
        boolean comprobarValor = true;

        System.out.println("Escribe la cantidad de corredores que quieres: ");

        try {
            cantidadCorredores = bf.read();

            for (int i = 0; i < cantidadCorredores; i++) {
                comprobarValor = true;
                System.out.println("Escribe el simbolo del corredor " + (i + 1) + ": ");
                simbolo = bf.readLine();
                System.out.println("Escribe la velocidad base del corredor " + (i + 1) + ": ");
                velocidadBase = bf.read();
                if(!valorCorrecto(velocidadBase)){
                    System.out.println("El valor de la velocidad base no es correcto, debe ser menor o igual a 5");
                    i--;
                    comprobarValor = false;
                }
                System.out.println("Escribe el valor turbo del corredor " + (i + 1) + ": ");
                valorTurbo = bf.read();
                if(!valorCorrecto(valorTurbo)){
                    System.out.println("El valor de la velocidad turbo no es correcto, debe ser menor o igual a 5");
                    i--;
                    comprobarValor = false;
                }
                System.out.println("Escribe la probabilidad de chocar del corredor " + (i + 1) + ": ");
                probabilidadChocar = bf.read();
                if(!valorCorrecto(probabilidadChocar)){
                    System.out.println("El valor de la probabilidad de chocar no es correcto, debe ser menor o igual a 5");
                    i--;
                    comprobarValor = false;
                }
                Corredor corredor = new Corredor(simbolo, velocidadBase, valorTurbo, probabilidadChocar);
                if(comprobarValor){
                    listaCorredores.add(corredor);
                }
            }

            return listaCorredores;
        } catch (IOException e) {
            System.err.println("Error al leer la cantidad de corredores");
            throw new RuntimeException(e);
        }
    }

    private static boolean valorCorrecto(int valor){
        boolean correcto = false;
        if(valor <= 5){
            correcto = true;
        }
        return correcto;
    }
}
