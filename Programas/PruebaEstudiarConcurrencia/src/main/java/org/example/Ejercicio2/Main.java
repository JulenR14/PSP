package org.example.Ejercicio2;

public class Main {
    public static void main(String[] args) {

        Town2 town2 = new Town2(10);
        Gardener gardener1 = new Gardener(1, town2);
        Gardener gardener2 = new Gardener(2, town2);
        Gardener gardener3 = new Gardener(3, town2);

        Citizen citizen1 = new Citizen(town2);
        Citizen citizen2 = new Citizen(town2);
        Citizen citizen3 = new Citizen(town2);
        Citizen citizen4 = new Citizen(town2);
        Citizen citizen5 = new Citizen(town2);

        gardener1.start();
        gardener2.start();
        gardener3.start();

        citizen1.start();
        citizen2.start();
        citizen3.start();
        citizen4.start();
        citizen5.start();

        try {
            gardener1.join();
            gardener2.join();
            gardener3.join();
            citizen1.join();
            citizen2.join();
            citizen3.join();
            citizen4.join();
            citizen5.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
