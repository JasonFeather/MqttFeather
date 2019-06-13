package com.example.mqttlibray;

import android.content.Context;
import android.content.Intent;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.ArrayList;

/**
 * Created by dell on 2019/6/12.
 */

public class MqControl {
    private   static  ArrayList<OnMqReceiveListener> list= new ArrayList<OnMqReceiveListener>();
    public static  void addOnMqReceiveListener(OnMqReceiveListener onMqReceiveListener){
        list.add(onMqReceiveListener);
    }
    public static void refresh(String topic, String message){
        for (OnMqReceiveListener mqReceiveListener:list){
            mqReceiveListener.onReceive(topic,message);
        }
    }
    public static  void removeOnMqReceiveListener(OnMqReceiveListener onMqReceiveListener){
        if(list.contains(onMqReceiveListener)){
            list.remove(onMqReceiveListener);
        }
    }
    public static void startMqqt(Context context){
        Intent intent = new Intent(context, MineMqttService.class);
        context.startService(intent);
    }

    public static void setConfig(ConfigMqqtBean configBean){
        Config.host=configBean.getHost();
        Config.USERNAME=configBean.getUsername();
        Config.PUBLISH_TOPIC=configBean.getPublish_topic();
        Config.RESPONSE_TOPIC=configBean.getResponse_topic();
        Config.CLIENTID=configBean.getClientid();
        Config.PASSWORD=configBean.getPassword();
    }

}
