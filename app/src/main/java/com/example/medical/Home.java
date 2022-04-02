package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;

import java.util.Objects;

public class Home extends AppCompatActivity {
    ImageView vision;
    ImageView hearing;
    ImageView health;
    ImageView workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_home);
        vision = findViewById(R.id.visionT);
        hearing = findViewById(R.id.hearT);
        health = findViewById(R.id.calcT);
        workout = findViewById(R.id.workoutT);
        hearing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(Home.this, Hearing.class);
                startActivity(navi);
            }
        });
        vision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(Home.this, vision.class);
                startActivity(navi);
            }
        });
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(Home.this, health_calculator.class);
                startActivity(navi);
            }
        });
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(Home.this, workout.class);
                startActivity(navi);
            }
        });
    }
}