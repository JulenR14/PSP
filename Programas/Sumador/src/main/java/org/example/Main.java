package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Sumador s = new Sumador();
        int n1 = Integer.parseInt("5");
        int n2 = Integer.parseInt("7");
        int resultado = s.sumar(n1, n2);
        System.out.println(resultado);
    }
}