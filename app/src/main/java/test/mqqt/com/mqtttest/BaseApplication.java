package test.mqqt.com.mqtttest;

import android.app.Application;

import com.example.mqttlibray.ConfigMqqtBean;
import com.example.mqttlibray.MqControl;

/**
 * Created by dell on 2019/6/13.
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ConfigMqqtBean build = new ConfigMqqtBean.Builder().setHost("").setUsername("").setPassword("").setClientid("").setClientid("").build();
        MqControl.setConfig(build);
    }
}
