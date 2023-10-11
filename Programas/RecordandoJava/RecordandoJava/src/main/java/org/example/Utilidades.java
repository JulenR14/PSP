package org.example;

public class Utilidades {

    //metodo que recibe un array de integers y devuelve el array completo de numeros(10% mas elevado que permite java)
    public static int[] rellenarArrayNumerosAleatorios(int[] numeros){
        //recorremos un for para completarlo
        for (int contador = 0; contador < numeros.length; contador++){
            numeros[contador] = (int)(Math.random() * ((Integer.MAX_VALUE - (Integer.MAX_VALUE*0.9))+1));
        }

        return numeros;
    }

    //metodo que devuelve si el numero es primo o no
    public static boolean naive(int numero){
        boolean primo = true;

        for (int i = 2; i < numero; i++){
            if(numero % i == 0){
                primo = false;
            }
        }

        return primo;
    }

}
