package org.example;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MQTTPublish {
    public static void main(String[] args)  throws IOException {
        String publisherId = UUID.randomUUID().toString();
        IMqttClient publisher;
        try {
            publisher = new MqttClient("tcp://ec2-184-72-89-48.compute-1.amazonaws.com:1883",publisherId);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        try {
            publisher.connect(options);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message: ");
        String message = scanner.nextLine();
        System.out.println("Enter topic: ");
        String topic = scanner.nextLine();
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            Future<Boolean> result = executorService.submit(new MQTTPublisher(publisher, message, topic));
            if (result.get()) {
                System.out.printf("MQTT message sended");
            } else {
                System.out.printf("MQTT message NOT sended");
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            publisher.disconnect();
            publisher.close();
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }
}
