package org.example;

import java.net.*;
import java.io.*;

import static java.lang.Thread.sleep;

public class TCPClient {
    public static void main(String[] args)  throws IOException {
        Socket socket = null;
        BufferedReader input = null;
        PrintWriter output = null;

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce un mensaje :");
        String userInput = stdIn.readLine();
        // Creamos un socket en el lado cliente, enlazado con un
        // servidor que está en la misma máquina que el cliente
        // y que escucha en el puerto 4444
        try {
            socket = new Socket("localhost", 4444);
            // Obtenemos el canal de entrada
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Obtenemos el canal de salida
            output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        } catch (IOException e) {
            System.err.println("No puede establer canales de E/S para la conexión");
            System.exit(-1);
        }

        try {

            // La envia al servidor
            output.println(userInput);
            // Envía a la salida estándar la respuesta del servidor
            String response = input.readLine();
            System.out.println("Respuesta servidor: " + response);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Libera recursos
        output.close();
        input.close();
        stdIn.close();
        socket.close();

    }
}