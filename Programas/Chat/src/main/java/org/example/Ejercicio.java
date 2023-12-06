package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio {
    public static void main(String[] args) throws IOException {
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Elige una opción: ");
            System.out.println("1. Ver el chat");
            System.out.println("2. Publicar un mensaje");
            System.out.println("3. Salir");
            int opcion = Integer.parseInt(br.readLine());
            switch (opcion) {
                case 1:
                    System.out.println("Escribe que chat quieres leer:");
                    System.out.println("- /chat/todos/");
                    System.out.println("- /chat/alejandro/julen");
                    System.out.println("- /chat/julen/alejandro");
                    System.out.print("Escribe aquí: ");
                    String chat = br.readLine();
                    MQTTSuscribe.leerchat(chat);
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
