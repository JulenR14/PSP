import java.net.*;
import java.io.*;

public class UDPServer {

    public static void main(String args[]) {

        try {

            DatagramSocket socketUDP = new DatagramSocket(6789);
            byte[] buffer = new byte[1000];

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket receivedDatagram = new DatagramPacket(buffer, buffer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(receivedDatagram);

                System.out.println("El mensaje es: " + new String(receivedDatagram.getData()));
                System.out.print("Datagrama recibido del host: " + receivedDatagram.getAddress());
                System.out.println(" desde el puerto remoto: " + receivedDatagram.getPort());

                // Construimos el DatagramPacket para enviar la respuesta
                DatagramPacket responseDatagram = new DatagramPacket(receivedDatagram.getData(), receivedDatagram.getLength(), receivedDatagram.getAddress(), receivedDatagram.getPort());

                // Enviamos la respuesta, que es un eco
                socketUDP.send(responseDatagram);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

}