package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Objects;

public class color extends AppCompatActivity {
    RadioButton one, two, three, four, five, six, seven, eight, nine;
    Button next;
    ImageView number;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_color);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        next = findViewById(R.id.next);
        number = findViewById(R.id.number);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                two.setChecked(false);
                three.setChecked(false);
                four.setChecked(false);
                five.setChecked(false);
                six.setChecked(false);
                seven.setChecked(false);
                eight.setChecked(false);
                nine.setChecked(false);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setChecked(false);
                three.setChecked(false);
                four.setChecked(false);
                five.setChecked(false);
                six.setChecked(false);
                seven.setChecked(false);
                eight.setChecked(false);
                nine.setChecked(false);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setChecked(false);
                two.setChecked(false);
                four.setChecked(false);
                five.setChecked(false);
                six.setChecked(false);
                seven.setChecked(false);
                eight.setChecked(false);
                nine.setChecked(false);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setChecked(false);
                two.setChecked(false);
                three.setChecked(false);
                five.setChecked(false);
                six.setChecked(false);
                seven.setChecked(false);
                eight.setChecked(false);
                nine.setChecked(false);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setChecked(false);
                two.setChecked(false);
                three.setChecked(false);
                four.setChecked(false);
                six.setChecked(false);
                seven.setChecked(false);
                eight.setChecked(false);
                nine.setChecked(false);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setChecked(false);
                two.setChecked(false);
                three.setChecked(false);
                four.setChecked(false);
                five.setChecked(false);
                seven.setChecked(false);
                eight.setChecked(false);
                nine.setChecked(false);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setChecked(false);
                two.setChecked(false);
                three.setChecked(false);
                four.setChecked(false);
                five.setChecked(false);
                six.setChecked(false);
                eight.setChecked(false);
                nine.setChecked(false);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setChecked(false);
                two.setChecked(false);
                three.setChecked(false);
                four.setChecked(false);
                five.setChecked(false);
                six.setChecked(false);
                seven.setChecked(false);
                nine.setChecked(false);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setChecked(false);
                two.setChecked(false);
                three.setChecked(false);
                four.setChecked(false);
                five.setChecked(false);
                six.setChecked(false);
                seven.setChecked(false);
                eight.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color1).getConstantState()
                && one.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color2).getConstantState()
                        && nine.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color3).getConstantState()
                        && six.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color4).getConstantState()
                        && eight.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color5).getConstantState()
                        && six.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color6).getConstantState()
                        && two.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color7).getConstantState()
                        && one.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color8).getConstantState()
                        && five.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color9).getConstantState()
                        && one.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color10).getConstantState()
                        && six.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color11).getConstantState()
                        && three.isChecked()){
                    score++;
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color12).getConstantState()
                        && four.isChecked()){
                    score++;
                }
                if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color1).getConstantState()){
                    number.setImageResource(R.drawable.color2);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color2).getConstantState()){
                    number.setImageResource(R.drawable.color3);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color3).getConstantState()){
                    number.setImageResource(R.drawable.color4);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color4).getConstantState()){
                    number.setImageResource(R.drawable.color5);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color5).getConstantState()){
                    number.setImageResource(R.drawable.color6);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color6).getConstantState()){
                    number.setImageResource(R.drawable.color7);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color7).getConstantState()){
                    number.setImageResource(R.drawable.color8);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color8).getConstantState()){
                    number.setImageResource(R.drawable.color9);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color9).getConstantState()){
                    number.setImageResource(R.drawable.color10);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color10).getConstantState()){
                    number.setImageResource(R.drawable.color11);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color11).getConstantState()){
                    number.setImageResource(R.drawable.color12);
                }
                else if(number.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.color12).getConstantState()){
                    Intent navi = new Intent(color.this, color_result.class);
                    navi.putExtra("score",score);
                    startActivity(navi);
                }
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(color.this, vision.class);
                startActivity(navi);
            }
        });
    }
}