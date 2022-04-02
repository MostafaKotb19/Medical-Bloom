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

public class body_mass_index extends AppCompatActivity {
    //define variables and objects
    EditText height;
    EditText weight;
    Button calc;
    TextView result;
    TextView bmi_result;
    RadioButton male,female;
    DecimalFormat percision = new DecimalFormat("0.00");
    String under = "Underweight";
    String normal = "Normal";
    String over = "Overweight";
    String obese = "Obese";
    String extreme = "Extremely Obese";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_body_mass_index);
        //attach every object to its corresponding id
        height = findViewById(R.id.editText6);
        weight = findViewById(R.id.editText7);
        calc = findViewById(R.id.button14);
        result = findViewById(R.id.textView11);
        bmi_result = findViewById(R.id.bmi_result);
        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);
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
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //what will happen when the user click the button
                float height_number = Float.parseFloat(height.getText().toString());
                height_number = height_number / 100; //from cm to m
                float weight_number = Float.parseFloat(weight.getText().toString());
                double bmi = weight_number / (Math.pow(height_number, 2)); //equation of body mass index
                result.setText(percision.format(bmi));
                final boolean rmale = male.isChecked(); //state of male radiobutton
                final boolean rfemale = female.isChecked(); //state of male radiobutton
                if (!rmale && !rfemale) {
                    Toast.makeText(body_mass_index.this,
                            "please select gender", Toast.LENGTH_SHORT).show();
                }
                if (bmi < 18.5) {
                    bmi_result.setText(under);
                } else if (bmi >= 18.5 && bmi < 25) {
                    bmi_result.setText(normal);
                } else if (bmi >= 25 && bmi < 30) {
                    bmi_result.setText(over);
                } else if (bmi >= 30 && bmi < 35) {
                    bmi_result.setText(obese);
                } else if (bmi >= 35) {
                    bmi_result.setText(extreme);
                }
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(body_mass_index.this, health_calculator.class);
                startActivity(navi);
            }
        });
    }
}
