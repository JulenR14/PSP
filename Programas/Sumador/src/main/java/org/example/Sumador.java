package org.example;

public class Sumador {

    public int sumar(int n1, int n2) {
        int resultado = 0;
        for (int i = n1; i<=n2 ;i++){
            resultado = resultado+i;
        }
        return resultado;
    }

}
