package com.example.mqttlibray;

import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by dell on 2019/6/6.
 */

public interface MyMqttResultLinter {
    void ConnectSucess();
    void connectFailure(String message);
    void messageArrived(String topic, MqttMessage message);

}
