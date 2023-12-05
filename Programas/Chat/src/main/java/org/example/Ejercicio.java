package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio {
    public static void main(String[] args) throws IOException {
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Elige una opción: ");
            System.out.println("1. Suscribirse a un topic");
            System.out.println("2. Publicar un mensaje");
            System.out.println("3. Salir");
            int opcion = Integer.parseInt(br.readLine());
            switch (opcion) {
                case 1:
                    MQTTSuscribe.main(args);
                    break;
                case 2:
                    MQTTPublish.main(args);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}
