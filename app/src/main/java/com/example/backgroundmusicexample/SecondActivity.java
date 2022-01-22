package com.example.backgroundmusicexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnStop = findViewById(R.id.btnStop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "PLAY";
                Intent myService = new Intent(SecondActivity.this, BackgroundSoundService.class);
                myService.setAction(action);
                startService(myService);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "STOP";
                Intent myService = new Intent(SecondActivity.this, BackgroundSoundService.class);
                myService.setAction(action);
                startService(myService);

            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(App.instance().settings.getBoolean("lastState_playingMusic",false))
        {
            String action = "PLAY_AND_SEEK";
            Intent myService = new Intent(SecondActivity.this, BackgroundSoundService.class);
            myService.setAction(action);
            startService(myService);
        }
    }
}