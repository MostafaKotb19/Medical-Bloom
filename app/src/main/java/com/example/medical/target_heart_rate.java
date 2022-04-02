package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

public class target_heart_rate extends AppCompatActivity {
    Button calc;
    TextView result;
    RadioButton little;
    RadioButton moderate;
    RadioButton intense;
    EditText age;
    EditText rhr;
    DecimalFormat percision = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_target_heart_rate);
        calc = findViewById(R.id.button7);
        result = findViewById(R.id.textView20);
        little = findViewById(R.id.radioButton11);
        moderate = findViewById(R.id.radioButton20);
        intense = findViewById(R.id.radioButton21);
        age = findViewById(R.id.editText12);
        rhr = findViewById(R.id.editText14);
        little.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moderate.setChecked(false);
                intense.setChecked(false);
            }
        });
        moderate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                little.setChecked(false);
                intense.setChecked(false);
            }
        });
        intense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moderate.setChecked(false);
                little.setChecked(false);
            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float rhr_number = Float.parseFloat(rhr.getText().toString());
                final float age_number = Float.parseFloat(age.getText().toString());
                final boolean rlittle = little.isChecked();
                final boolean rmoderate = moderate.isChecked();
                final boolean rintense = intense.isChecked();
                final double[] thr = new double[1];
                if(rlittle && rmoderate && rintense) {
                    Toast.makeText(target_heart_rate.this, "error in choosing workout intensity", Toast.LENGTH_SHORT).show();
                }
                if(rlittle && !rmoderate && !rintense){
                    thr[0]=((207- (age_number * 0.5) - rhr_number) * 0.5) + rhr_number;
                    result.setText(percision.format(thr[0]));
                }
                else if(!rlittle && rmoderate && !rintense){
                    thr[0]=((207- (age_number * 0.7) - rhr_number) * 0.5) + rhr_number;
                    result.setText(percision.format(thr[0]));
                }
                else if(!rlittle && !rmoderate && rintense){
                    thr[0]=((207- (age_number * 0.85) - rhr_number) * 0.5) + rhr_number;
                    result.setText(percision.format(thr[0]));
                }
                else if(!rlittle && !rmoderate && !rintense) {
                    Toast.makeText(target_heart_rate.this, "please choose workout intensity", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(target_heart_rate.this, health_calculator.class);
                startActivity(navi);
            }
        });
    }
}
