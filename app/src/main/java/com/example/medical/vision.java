package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Objects;

public class vision extends AppCompatActivity {
    Button acuity, color, astigmatism;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_vision);
        color = findViewById(R.id.color);
        acuity = findViewById(R.id.acuity);
        astigmatism = findViewById(R.id.astigmatism);
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(vision.this, color.class);
                startActivity(navi);
            }
        });
        acuity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(vision.this, acuity.class);
                startActivity(navi);
            }
        });
        astigmatism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(vision.this, astigmatism_instructions.class);
                startActivity(navi);
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(vision.this, Home.class);
                startActivity(navi);
            }
        });
    }
}