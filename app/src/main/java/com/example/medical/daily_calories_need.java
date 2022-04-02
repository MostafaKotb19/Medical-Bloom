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

public class daily_calories_need extends AppCompatActivity {
    //define variables and objects
    Button calc;
    EditText height;
    EditText weight;
    EditText age;
    RadioButton male;
    RadioButton female;
    RadioButton sedentary;
    RadioButton active;
    RadioButton exactive;
    RadioButton vractive;
    RadioButton light;
    RadioButton moderate;
    TextView result;
    DecimalFormat percision = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_daily_calories_need);
        //attach every object to its corresponding id
        calc = findViewById(R.id.button26);
        height = findViewById(R.id.editText4);
        weight = findViewById(R.id.editText18);
        age = findViewById(R.id.editText16);
        male = findViewById(R.id.radioButton12);
        female = findViewById(R.id.radioButton13);
        sedentary = findViewById(R.id.radioButton14);
        active = findViewById(R.id.radioButton17);
        exactive = findViewById(R.id.radioButton18);
        vractive = findViewById(R.id.radioButton19);
        light = findViewById(R.id.radioButton15);
        moderate = findViewById(R.id.radioButton16);
        result = findViewById(R.id.textView23);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setChecked(false);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setChecked(false);
            }
        });
        sedentary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                active.setChecked(false);
                vractive.setChecked(false);
                exactive.setChecked(false);
                light.setChecked(false);
                moderate.setChecked(false);
            }
        });
        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sedentary.setChecked(false);
                vractive.setChecked(false);
                exactive.setChecked(false);
                light.setChecked(false);
                moderate.setChecked(false);
            }
        });
        exactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sedentary.setChecked(false);
                vractive.setChecked(false);
                active.setChecked(false);
                light.setChecked(false);
                moderate.setChecked(false);
            }
        });
        vractive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sedentary.setChecked(false);
                exactive.setChecked(false);
                active.setChecked(false);
                light.setChecked(false);
                moderate.setChecked(false);
            }
        });
        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sedentary.setChecked(false);
                exactive.setChecked(false);
                active.setChecked(false);
                vractive.setChecked(false);
                moderate.setChecked(false);
            }
        });
        moderate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sedentary.setChecked(false);
                exactive.setChecked(false);
                active.setChecked(false);
                vractive.setChecked(false);
                light.setChecked(false);
            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //what will happen when the user click the button
                final boolean rmale = male.isChecked();
                final boolean rfemale = female.isChecked();
                final boolean rsedentary = sedentary.isChecked();
                final boolean ractive = active.isChecked();
                final boolean rexactive = exactive.isChecked();
                final boolean rvractive = vractive.isChecked();
                final boolean rlight = light.isChecked();
                final boolean rmoderate = moderate.isChecked();
                //converting from string to height
                float height_number = Float.parseFloat(height.getText().toString());
                float weight_number = Float.parseFloat(weight.getText().toString());
                float age_number = Float.parseFloat(age.getText().toString());
                double bmr = 0;
                final double[] calories = new double[1];
                if (rmale && !rfemale){
                    //male condition
                    bmr=(10*weight_number)+(6.25*height_number)
                            -(5*age_number)+ 5;}
                else if (!rmale && rfemale){
                    //female condition
                    bmr=(10*weight_number)+(6.25*height_number)
                            -(5*age_number)-161;}
                else if(!rmale && !rfemale) {
                    Toast.makeText(daily_calories_need.this, "please select gender", Toast.LENGTH_SHORT).show();
                }
                final double finalBmr = bmr;
                if(rsedentary){ calories[0] = finalBmr * 1.2;
                    result.setText(percision.format(calories[0]));}
                else if (rlight){ calories[0] = finalBmr * 1.375;
                    result.setText(percision.format(calories[0]));}
                else if (rmoderate){ calories[0] = finalBmr * 1.465;
                    result.setText(percision.format(calories[0]));}
                else if (ractive){
                    calories[0] = finalBmr * 1.55;
                    result.setText(percision.format(calories[0]));
                }
                else if (rvractive){
                    calories[0] = finalBmr * 1.725;
                    result.setText(percision.format(calories[0]));
                }
                else if (rexactive){
                    calories[0] = finalBmr * 1.9;
                    result.setText(percision.format(calories[0]));
                }
                else {
                    Toast.makeText(daily_calories_need.this, "please select activity level", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(daily_calories_need.this, health_calculator.class);
                startActivity(navi);
            }
        });
    }
}
