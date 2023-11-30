import java.net.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

                String hora = "";
                if ("time".equals(new String(receivedDatagram.getData()).substring(0, 4))){
                    hora = String.format("%02d:%02d", LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
                }
                System.out.println("El mensaje es: " + new String(receivedDatagram.getData()).substring(0, 4));
                System.out.print("Datagrama recibido del host: " + receivedDatagram.getAddress());
                System.out.println(" desde el puerto remoto: " + receivedDatagram.getPort());


                // Construimos el DatagramPacket para enviar la respuesta
                DatagramPacket responseDatagram = new DatagramPacket(hora.getBytes(), hora.length(), receivedDatagram.getAddress(), receivedDatagram.getPort());

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