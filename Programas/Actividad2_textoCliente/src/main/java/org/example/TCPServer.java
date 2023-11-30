package org.example;

import java.io.*;
import java.net.*;
import java.util.Base64;

public class TCPServer {
    public static final int PORT = 4444;

    public static void main(String[] args) throws IOException {
        // Establece el puerto en el que escucha peticiones
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + PORT);
            System.exit(-1);
        }

        Socket clientSocket = null;
        BufferedReader input = null;
        PrintWriter output = null;

        System.out.println("Escuchando: " + serverSocket);
        try {
            // Se bloquea hasta que recibe alguna petición de un cliente
            // abriendo un socket para el cliente
            clientSocket = serverSocket.accept();
            System.out.println("Connexión acceptada: "+ clientSocket);
            // Establece canal de entrada
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // Establece canal de salida
            output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),true);

            String s = input.readLine();
            String mensajeBase64 = Base64.getEncoder().encodeToString(s.getBytes());
            System.out.println("Texto del cliente a encriptar : " + s);
            output.println("#" + mensajeBase64 + "#");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // Libera recursos
        output.close();
        input.close();
        clientSocket.close();
        serverSocket.close();
    }
}