package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        String ruta = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

        LanzadorProcesos lp = new LanzadorProcesos();

        lp.ejecutar(ruta);

        System.out.println("Finalizado");

    }
}