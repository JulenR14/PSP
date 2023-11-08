package org.example.Ejercicio1;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Town town = new Town(15);
        Garden garden1 = new Garden(1, town);
        Garden garden2 = new Garden(2, town);
        Garden garden3 = new Garden(3, town);

        garden1.start();
        garden2.start();
        garden3.start();

        garden1.join();
        garden2.join();
        garden3.join();

    }
}