package com.example.mqttlibray;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by dell on 2019/6/6.
 */

public class MineMqttService extends Service implements MyMqttResultLinter{
    MqttDecorator mqttDecorator;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         mqttDecorator = new MqttDecorator(this);
        mqttDecorator.init();
        mqttDecorator.connet(this);
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void ConnectSucess() {
        Log.e("mqtt","mqtt_ConnectSucess");
        try {
            mqttDecorator.subscribe(Config.PUBLISH_TOPIC,2);
        }catch (Exception e){
        }
    }

    @Override
    public void connectFailure(String message) {
        Log.e("mqtt","mqtt_connectFailure");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        MqControl.refresh(topic,message.toString());
        Toast.makeText(this,topic+"______"+message.toString(),Toast.LENGTH_LONG).show();
    }
}
