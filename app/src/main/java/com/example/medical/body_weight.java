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

public class body_weight extends AppCompatActivity {
    //define variables and objects
    RadioButton male;
    RadioButton female;
    EditText height;
    Button calc;
    TextView result;
    DecimalFormat percision = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_body_weight);
        //attach every object to its corresponding id
        male = findViewById(R.id.radioButton7);
        female = findViewById(R.id.radioButton22);
        height = findViewById(R.id.editText25);
        calc = findViewById(R.id.button29);
        result = findViewById(R.id.textView31);
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
        final double[] bw = new double[1];
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //what will happen when the user click the button
                final boolean rmale = male.isChecked(); //state of male radiobutton
                final boolean rfemale = female.isChecked(); //state of male radiobutton
                final float height_number = Float.parseFloat(height.getText().toString());
                if(rmale && !rfemale){
                    //male condition
                    bw[0] = 50 + 2.3 * (height_number-152.4)/(2.54); //Ideal body weight equation
                    result.setText(percision.format(bw[0]));
                }
                else if(!rmale && rfemale){
                    //male condition
                    bw[0] = 45.5 + 2.3 * (height_number-152.4)/(2.54); //Ideal body weight equation
                    result.setText(percision.format(bw[0]));
                }
                else if (!rmale && !rfemale) {
                    Toast.makeText(body_weight.this,
                            "please select gender", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(body_weight.this, health_calculator.class);
                startActivity(navi);
            }
        });
    }
}
