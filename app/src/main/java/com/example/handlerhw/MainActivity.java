package com.example.handlerhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler;
    private Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler();
        startBtn = findViewById(R.id.start_btn);
    }

    public void start(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Log.d("TAG", "Start" + i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i == 5){
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                startBtn.setText("50%");
                            }
                        });
                    }
                }
            }
        }).start();

    }

}
