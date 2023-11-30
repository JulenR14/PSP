import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] mensaje = "time".getBytes();
            InetAddress serverHost = InetAddress.getByName("localhost");
            int serverPort = 6789;

            DatagramPacket sendDatagram = new DatagramPacket(mensaje, mensaje.length, serverHost, serverPort);

            socket.send(sendDatagram);

            byte[] respuesta = new byte[1000];
            DatagramPacket respuestaDatagram = new DatagramPacket(respuesta, respuesta.length);
            socket.receive(respuestaDatagram);

            System.out.println("La hora que envia el servidor es : " + new String(respuestaDatagram.getData()).substring(0, 5));

            socket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
