package org.example;

public class Utilidades {

    public static int[] rellenarArrayNumerosAleatorios(int[] numeros){
        for (int contador = 0; contador < numeros.length; contador++){
            numeros[contador] = (int)(Math.random() * ((Integer.MAX_VALUE - (Integer.MAX_VALUE*0.1))+1));
        }

        return numeros;
    }

}
