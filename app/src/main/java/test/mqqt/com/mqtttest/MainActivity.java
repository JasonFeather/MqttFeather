package test.mqqt.com.mqtttest;

import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mqttlibray.MqControl;
import com.example.mqttlibray.MyMqttResultLinter;
import com.example.mqttlibray.OnMqReceiveListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMqReceiveListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Manifest.permission.INTERNET");
        strings.add("Manifest.permission.WRITE_EXTERNAL_STORAGE");
        ActivityCompat.requestPermissions(this, strings.toArray(new String[strings.size()]), 1);
        //请在权限申请成功后调用
        MqControl.startMqqt(this);
        MqControl.addOnMqReceiveListener(this);
    }

    @Override
    public void onReceive(String topic, String message) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MqControl.removeOnMqReceiveListener(this);
    }
}
