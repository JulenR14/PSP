package org.example;

public class Utilidades {

    //metodo que recibe un array de integers y devuelve el array completo de numeros(10% mas elevado que permite java)
    public static int[] rellenarArrayNumerosAleatorios(int[] numeros){
        //recorremos un for para completarlo
        for (int contador = 0; contador < numeros.length; contador++){
            numeros[contador] = (int)(Math.random() * ((Integer.MAX_VALUE - (Integer.MAX_VALUE*0.1))+1));
        }

        return numeros;
    }

}
