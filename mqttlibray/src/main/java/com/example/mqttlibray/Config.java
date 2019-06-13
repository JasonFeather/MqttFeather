package com.example.mqttlibray;

import android.annotation.SuppressLint;
import android.os.Build;

/**
 * Created by dell on 2019/6/6.
 */

public class Config {
    public static  String host="tcp://139.224.44.24:1883";
    public static String  USERNAME="admin";
    public static String PASSWORD="12345qwert";
    public static String RESPONSE_TOPIC="tokudu/ss";
    public static String PUBLISH_TOPIC="tokudu/ss";
    @SuppressLint("MissingPermission")
    public static String CLIENTID=Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ? Build.getSerial() : Build.SERIAL;//客户端ID，一般以客户端唯一标识符表示，这里用设备序列号表示;

//    @SuppressLint("MissingPermission")
//    public static void isDebug(boolean isdebug){
//        if (!isdebug){
//            host="tcp://139.224.44.24:1883";
//            USERNAME="admin";
//            PASSWORD="12345qwert";
//            RESPONSE_TOPIC="123456";
//            PUBLISH_TOPIC="123456";
//            CLIENTID="123456";
//        }else {
//            host="tcp://139.224.44.24:1883";
//            USERNAME="admin";
//            PASSWORD="12345qwert";
//            RESPONSE_TOPIC="123456";
//            PUBLISH_TOPIC="123456";
//            CLIENTID="123456";
//        }
//    }
}
