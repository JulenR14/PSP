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
        int posibilidadTurbo;
        int probabilidadChocar;
        boolean comprobarValor = true;

        System.out.print("Escribe la cantidad de corredores que quieres: ");

        try {
            cantidadCorredores = Integer.parseInt(bf.readLine());

            for (int i = 0; i < cantidadCorredores; i++) {
                comprobarValor = true;
                System.out.print("Escribe el simbolo del corredor " + (i + 1) + ": ");
                simbolo = bf.readLine();
                System.out.print("Escribe la velocidad base del corredor " + (i + 1) + ": ");
                velocidadBase = Integer.parseInt(bf.readLine());
                if(!valorCorrecto(velocidadBase)){
                    System.out.print("El valor de la velocidad base no es correcto, debe ser menor o igual a 5");
                    i--;
                    comprobarValor = false;
                }
                System.out.print("Escribe la posibilidad de turbo del corredor " + (i + 1) + ": ");
                posibilidadTurbo = Integer.parseInt(bf.readLine());
                if(!valorCorrecto(posibilidadTurbo)){
                    System.out.print("El valor de la posibilidad de turbo no es correcto, debe ser menor o igual a 5");
                    i--;
                    comprobarValor = false;
                }
                System.out.print("Escribe la probabilidad de chocar del corredor " + (i + 1) + ": ");
                probabilidadChocar = Integer.parseInt(bf.readLine());
                if(!valorCorrecto(probabilidadChocar)){
                    System.out.println("El valor de la probabilidad de chocar no es correcto, debe ser menor o igual a 5");
                    i--;
                    comprobarValor = false;
                }

                if(comprobarValor && (velocidadBase + posibilidadTurbo + probabilidadChocar) <= 10){
                    Corredor corredor = new Corredor(simbolo, velocidadBase, posibilidadTurbo, probabilidadChocar);
                    listaCorredores.add(corredor);
                }else{
                    System.err.println("La suma de los valores no puede ser mayor a 10");
                    i--;
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
