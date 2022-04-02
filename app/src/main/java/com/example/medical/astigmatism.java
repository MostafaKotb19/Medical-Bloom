package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Objects;

public class astigmatism extends AppCompatActivity {
    Button same, different;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_astigmatism);
        same = findViewById(R.id.same);
        different = findViewById(R.id.different);
        same.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(astigmatism.this, astigmatism_result.class);
                navi.putExtra("result", "h");
                startActivity(navi);
            }
        });
        different.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(astigmatism.this, astigmatism_result.class);
                navi.putExtra("result", "u");
                startActivity(navi);
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(astigmatism.this, astigmatism_instructions.class);
                startActivity(navi);
            }
        });
    }
}