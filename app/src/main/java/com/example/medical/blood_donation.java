package com.example.medical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class blood_donation extends AppCompatActivity {
    //define variables and objects
    Button calc;
    TextView result;
    RadioButton male;
    RadioButton female;
    CalendarView date;
    int finalmonth;
    String finaldate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_blood_donation);
        //attach every object to its corresponding id
        calc = findViewById(R.id.button28);
        result = findViewById(R.id.textView24);
        male = findViewById(R.id.radioButton23);
        female = findViewById(R.id.radioButton24);
        date = findViewById(R.id.calendarView);
        Calendar calendar = Calendar.getInstance();
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
        date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, final int year, final int month, final int dayOfMonth) {
                //what will happen when the user choose a date
                calc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //what will happen when the user click the button
                        final boolean rmale = male.isChecked(); //state of male radiobutton
                        final boolean rfemale = female.isChecked(); //state of male radiobutton
                        if (rmale && !rfemale) {
                            //male condition
                            finalmonth = month + 4;
                            finaldate = dayOfMonth + "/" + finalmonth + "/" + year;
                            result.setText(finaldate);
                        } else if (!rmale && rfemale) {
                            //female condition
                            finalmonth = month + 5;
                            finaldate = dayOfMonth + "/" + finalmonth + "/" + year;
                            result.setText(finaldate);
                        }
                        if (!rmale && !rfemale) {
                            Toast.makeText(blood_donation.this,
                                    "please select gender", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(blood_donation.this, health_calculator.class);
                startActivity(navi);
            }
        });
    }
}
