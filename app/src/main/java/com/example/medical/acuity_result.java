package com.example.medical;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class acuity_result extends AppCompatActivity {
    Button return_acuity, home_acuity, repeat_acuity;
    TextView acuity_result, acuity_instructions, acuity_action;
    String unhealthy = "You need to see a doctor";
    String healthy = "Your vision is normal";
    String superhealthy = "Your vision is perfect";
    String instruction_u = "You must decrease the brightness as much as possible";
    String instruction_h = "You better turn on blue light filter";
    String instruction_s = "You can enjoy whatever settings you want";
    String action_u = "Brightness decreased to 20%";
    String action_h = "Brightness decreased to 50%";
    String action_s = "Brightness decreased to 70%";
    Context context;
    int brightness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_acuity_result);
        return_acuity = findViewById(R.id.return_acuity);
        home_acuity = findViewById(R.id.home_acuity);
        repeat_acuity = findViewById(R.id.repeat_acuity);
        acuity_result = findViewById(R.id.acuity_result);
        acuity_instructions = findViewById(R.id.acuity_instructions);
        acuity_action = findViewById(R.id.acuity_action);
        Intent navi = getIntent();
        int result = Objects.requireNonNull(navi.getExtras()).getInt("score", 0);
        context = getApplicationContext();
        brightness =
                Settings.System.getInt(context.getContentResolver(),
                        Settings.System.SCREEN_BRIGHTNESS, 0);
        if (result<=10){
            Settings.System.putInt(context.getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS, brightness*20/100);
            Toast.makeText(this, "brightness decreased", Toast.LENGTH_SHORT).show();
            acuity_result.setText(unhealthy);
            acuity_instructions.setText(instruction_u);
            acuity_action.setText(action_u);
        }
        else if (result > 11 && result<=25){
            Settings.System.putInt(context.getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS, brightness*50/100);
            Toast.makeText(this, "brightness decreased", Toast.LENGTH_SHORT).show();
            acuity_result.setText(healthy);
            acuity_instructions.setText(instruction_h);
            acuity_action.setText(action_h);
        }
        else if(result>25) {
            Settings.System.putInt(context.getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS, brightness*70/100);
            Toast.makeText(this, "brightness decreased", Toast.LENGTH_SHORT).show();
            acuity_result.setText(superhealthy);
            acuity_instructions.setText(instruction_s);
            acuity_action.setText(action_s);
        }
        return_acuity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(acuity_result.this, vision.class);
                startActivity(navio);
            }
        });
        repeat_acuity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(acuity_result.this, acuity.class);
                startActivity(navio);
            }
        });
        home_acuity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navio = new Intent(acuity_result.this, Home.class);
                startActivity(navio);
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(acuity_result.this, acuity.class);
                startActivity(navi);
            }
        });
    }
}