package com.example.mqttlibray;

import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by dell on 2019/6/12.
 */

public interface OnMqReceiveListener {
    void onReceive(String topic, String message);
}
