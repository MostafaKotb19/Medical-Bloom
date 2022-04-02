package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class Hearing_result extends AppCompatActivity {

    String result, text;
    Double max,min;
    TextView result_t;
    TextView result_n;
    TextView action_hear;
    String healthy = "Your hearing is fine, no need for doctor check-up";
    String unhealthy = "Your hearing is not okay; you must see a doctor";
    Button home, repeat;
    AudioManager audioManager;
    String action_h = "Volume decreased to 50%";
    String action_u = "Volume decreased to 80%";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_hearing_result);
        Intent navi = getIntent();
        result = Objects.requireNonNull(navi.getExtras()).getString("result","");
        max = Objects.requireNonNull(navi.getExtras()).getDouble("max",0.0);
        min = Objects.requireNonNull(navi.getExtras()).getDouble("min",0.0);
        result_n = findViewById(R.id.result_n);
        result_t = findViewById(R.id.result_t);
        repeat = findViewById(R.id.repeat);
        home = findViewById(R.id.home);
        action_hear = findViewById(R.id.action_hear);
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        text = min+"-"+max+"Hz";
        result_n.setText(text);
        if(result.equals("h")){
            result_t.setText(healthy);
            action_hear.setText(action_h);
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)*50/100,0);
        }
        else if (result.equals("u")){
            result_t.setText(unhealthy);
            action_hear.setText(action_u);
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)*80/100,0);
        }
        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(Hearing_result.this, Hearing.class);
                startActivity(navio);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(Hearing_result.this, Home.class);
                startActivity(navio);
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(Hearing_result.this, Hearing.class);
                startActivity(navi);
            }
        });
    }
}