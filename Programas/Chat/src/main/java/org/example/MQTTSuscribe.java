package org.example;

import org.eclipse.paho.client.mqttv3.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MQTTSuscribe {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter topic: ");
        String topic = "coca";
        String topicPrivado = "coca/privado";
        Path path = Path.of("src/main/resources/coca.txt");
        Path pathpriv = Path.of("src/main/resources/cocaprivado.txt");

        String publisherId = UUID.randomUUID().toString();
        IMqttClient publisher = null;
        try {
            publisher = new MqttClient("tcp://ec2-184-72-89-48.compute-1.amazonaws.com:1883", publisherId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(false);
        options.setConnectionTimeout(10);
        try {
            publisher.connect(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

        publisher.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable throwable) {
                System.out.println("Connection to Solace brojer lost!" + throwable.getMessage());
            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                if (topic.equals("coca")){
                    System.out.println("Escribiendo en el archivo");
                    Files.writeString(path, new String(mqttMessage.getPayload()) + "\n");
                }else if (topic.equals("cocaprivado")){
                    System.out.println("Escribiendo en el archivo privado");
                    Files.writeString(pathpriv, new String(mqttMessage.getPayload()) + "\n");
                }
                System.out.println("\nReceived a Message!" +
                        "\n\tTime:    " + LocalDateTime.now() +
                        "\n\tTopic:   " + topic +
                        "\n\tMessage: " + new String(mqttMessage.getPayload()) +
                        "\n\tQoS:     " + mqttMessage.getQos() + "\n");
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {}
        });

        try {
            publisher.subscribe("coca", 0);
            publisher.subscribe("cocaprivado", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}