package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Objects;

public class workout extends AppCompatActivity {
    Button abs, full, back, shoulders, legs, back_n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_workout);
        abs = findViewById(R.id.abs);
        full = findViewById(R.id.full_body);
        back_n = findViewById(R.id.back_n);
        shoulders = findViewById(R.id.shoulders);
        legs = findViewById(R.id.legs);
        back = findViewById(R.id.back);
        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(workout.this, abs.class);
                startActivity(navi);
            }
        });
        full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(workout.this, full_body.class);
                startActivity(navi);
            }
        });
        back_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(workout.this, back.class);
                startActivity(navi);
            }
        });
        shoulders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(workout.this, shoulders.class);
                startActivity(navi);
            }
        });
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(workout.this, legs.class);
                startActivity(navi);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(workout.this, Home.class);
                startActivity(navi);
            }
        });
    }
}