package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.TemperatureControlTemplate;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class color_result extends AppCompatActivity {
    TextView rcolor, settings;
    Button repeat_color, return_color, home_color;
    int score;
    String unhealthy = "You need to see a doctor";
    String healthy = "Your vision is normal";
    String colorblind = "Turn on Color Correction setting";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_color_result);
        rcolor = findViewById(R.id.rcolor);
        settings = findViewById(R.id.settings);
        repeat_color = findViewById(R.id.repeat_color);
        return_color = findViewById(R.id.return_color);
        home_color = findViewById(R.id.home_color);
        Intent navi = getIntent();
        score = Objects.requireNonNull(navi.getExtras()).getInt("score",0);
        if(score<=6){
            rcolor.setText(unhealthy);
            settings.setText(colorblind);
        }
        else {
            rcolor.setText(healthy);
            settings.setText("");
        }
        return_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(color_result.this, vision.class);
                startActivity(navio);
            }
        });
        repeat_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(color_result.this, color.class);
                startActivity(navio);
            }
        });
        home_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(color_result.this, Home.class);
                startActivity(navio);
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(color_result.this, color.class);
                startActivity(navi);
            }
        });
    }
}