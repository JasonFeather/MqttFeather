package com.example.mqttlibray;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by dell on 2019/6/6.
 */

public class MqttDecorator implements IMqtt {
    private Context context;
    private MqttAndroidClient mqttAndroidClient;
    private MqttConnectOptions mMqttConnectOptions;
    private boolean doConnect;
    public MqttDecorator(Context context){
        this.context=context;
    }

    @Override
    public void init() {
        mqttAndroidClient = new MqttAndroidClient(context, Config.host, Config.CLIENTID);
        mMqttConnectOptions = new MqttConnectOptions();
        mMqttConnectOptions.setCleanSession(true); //设置是否清除缓存
        mMqttConnectOptions.setConnectionTimeout(10); //设置超时时间，单位：秒
        mMqttConnectOptions.setKeepAliveInterval(20); //设置心跳包发送间隔，单位：秒
        mMqttConnectOptions.setUserName(Config.USERNAME); //设置用户名
        mMqttConnectOptions.setPassword(Config.PASSWORD.toCharArray()); //设置密码
        // 最后的遗嘱
        try {
            mMqttConnectOptions.setWill(Config.PUBLISH_TOPIC, "Failure".getBytes(), 2, false);
        } catch (Exception e) {
            doConnect = false;
        }


    }

    @Override
    public void connet(final MyMqttResultLinter myMqttResultLinter) {
        if (!mqttAndroidClient.isConnected()) {
            final IMqttActionListener iMqttActionListener = new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    myMqttResultLinter.ConnectSucess();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    myMqttResultLinter.connectFailure(exception.toString());
                }
            };
            doClientConnection(iMqttActionListener);
            mqttAndroidClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    doClientConnection(iMqttActionListener);
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    myMqttResultLinter.messageArrived(topic, message);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            }); //设置监听订阅消息的回调
        }
    }

    @Override
    public void close() {
        mqttAndroidClient.close();
    }

    @Override
    public void subscribe(String topic, int qos) throws MqttException {
        mqttAndroidClient.subscribe(topic, qos);//订阅主题，参数：主题、服务质量
    }

    /**
     * 连接MQTT服务器
     */
    private void doClientConnection(IMqttActionListener mqttActionListener){
        try {
            mqttAndroidClient.connect(mMqttConnectOptions, null, mqttActionListener);
        }catch (Exception e){

        }

    }



}
