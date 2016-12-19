package com.example.owner.rootingchecker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkIfDeviceRooted();

    }

    private void checkIfDeviceRooted() {

        if(isDeviceRooted()) {
            Toast.makeText(this, "루팅된 디바이스입니다", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "루팅이 안된 디바이스입니다", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isDeviceRooted() {
        Process p = null;
        try {
            p=Runtime.getRuntime().exec("su");
        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
        return true;
    }
}
