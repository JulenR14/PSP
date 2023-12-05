package org.example;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.concurrent.Callable;

public class MQTTPublisher implements Callable<Boolean>{
    IMqttClient client;
    String message;
    String topic;

    public MQTTPublisher(IMqttClient client, String message, String topic) {
        this.client = client;
        this.message = message;
        this.topic = topic;
    }

    @Override
    public Boolean call() throws Exception {
        Thread.sleep(1000);
        if (!client.isConnected()) {
            return false;
        }
        byte[] payload = message.getBytes();
        MqttMessage msg = new MqttMessage(payload);
        msg.setQos(0);
        msg.setRetained(true);
        client.publish(topic, msg);
        return true;
    }
}
