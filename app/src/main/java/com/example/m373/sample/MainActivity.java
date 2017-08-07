package com.example.m373.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.startBtn);
        btnStop = findViewById(R.id.stopBtn);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == btnStart){
            startService(new Intent(this, MusicPlayback.class));
        }else{
            stopService(new Intent(this, MusicPlayback.class));
        }

    }
}
