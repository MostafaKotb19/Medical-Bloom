package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class astigmatism_result extends AppCompatActivity {
    Button return_astigmatism, home_astigmatism, repeat_astigmatism;
    TextView astigmatism_result;
    String unhealthy = "You need to see a doctor";
    String healthy = "Your vision is normal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_astigmatism_result);
        return_astigmatism = findViewById(R.id.return_astigmatism);
        home_astigmatism = findViewById(R.id.home_astigmatism);
        repeat_astigmatism = findViewById(R.id.repeat_astigmatism);
        astigmatism_result = findViewById(R.id.astigmatism_result);
        Intent navi = getIntent();
        String result = Objects.requireNonNull(navi.getExtras()).getString("result", "");
        if (result.equals("h")){
            astigmatism_result.setText(healthy);
        }
        else if (result.equals("u")){
            astigmatism_result.setText(unhealthy);
        }
        return_astigmatism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(astigmatism_result.this, vision.class);
                startActivity(navio);
            }
        });
        repeat_astigmatism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(astigmatism_result.this, astigmatism.class);
                startActivity(navio);
            }
        });
        home_astigmatism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(astigmatism_result.this, Home.class);
                startActivity(navio);
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(astigmatism_result.this, astigmatism.class);
                startActivity(navi);
            }
        });
    }
}