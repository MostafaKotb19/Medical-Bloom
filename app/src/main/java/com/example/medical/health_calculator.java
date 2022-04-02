package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Objects;

public class health_calculator extends AppCompatActivity {
    //define variables and objects
    Button body_mass;
    Button calories;
    Button heart_rate;
    Button blood_donation;
    Button water;
    Button ideal_weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_health_calculator);
        //attach every object to its corresponding id
        body_mass = findViewById(R.id.button11);
        calories = findViewById(R.id.button10);
        heart_rate = findViewById(R.id.button12);
        blood_donation = findViewById(R.id.button8);
        water = findViewById(R.id.button9);
        ideal_weight = findViewById(R.id.button13);
        //what will happen when the user click the button
        body_mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                body_massn();
            }
        });
        calories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caloriesn();
            }
        });
        heart_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heart_raten();
            }
        });
        blood_donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blood_donationn();
            }
        });
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watern();
            }
        });
        ideal_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ideal_weightn();
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(health_calculator.this, Home.class);
                startActivity(navi);
            }
        });
    }
    //navigating between activities
    private void body_massn(){
        Intent second = new Intent(this, body_mass_index.class);
        startActivity(second);
    }
    private void caloriesn(){
        Intent second = new Intent(this, daily_calories_need.class);
        startActivity(second);
    }
    private void heart_raten(){
        Intent second = new Intent(this, target_heart_rate.class);
        startActivity(second);
    }
    private void blood_donationn(){
        Intent second = new Intent(this, blood_donation.class);
        startActivity(second);
    }
    private void watern(){
        Intent second = new Intent(this, water_intake.class);
        startActivity(second);
    }
    private void ideal_weightn(){
        Intent second = new Intent(this, body_weight.class);
        startActivity(second);
    }
}