# MqttLibrary
#### mqtt集成,运用一些设计模式,和服务方式,方便在各个页面直接调用直接调用。
#### 集成方式
```java
 //1,添加网络权限:
 <uses-permission android:name="android.permission.INTERNET" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />


// 2.在Application中配置添加配置信息
 ConfigMqqtBean admin = new ConfigMqqtBean.Builder()
         .setUsername("admin")      //用户名
         .setPassword("12345qwert")  //用户密码
         .setHost("tcp://139.224.44.24:1883")  //地址
         .setClientid("123456")              //clientiD
         .setPublish_topic("123456")         //订阅主题
         .build();
 MqControl.setConfig(admin);

// 3.开启matt
 MqControl.startMqqt(this);

 //4.在需要监听的页面做mqtt监听

 MqControl.addOnMqReceiveListener(this);

 //在监听中获取回调
 @Override
 public void onReceive(String topic, String message) {
 }

// 5.注销监听
 @Override
 protected void onDestroy() {
     super.onDestroy();
     MqControl.removeOnMqReceiveListener(this);
 }


```
