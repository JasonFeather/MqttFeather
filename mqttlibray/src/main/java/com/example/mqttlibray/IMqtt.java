package com.example.mqttlibray;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Created by dell on 2019/6/6.
 */

public interface IMqtt {
    void  init();
    void  connet(MyMqttResultLinter myMqttResultLinter) throws MqttException;
    void close();
    void subscribe(String topic,int qos)throws MqttException;
}
