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

public class acuity extends AppCompatActivity {
    RadioButton up, down, right, left;
    Button next;
    ImageView direction;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_acuity);
        Toast.makeText(this, "Get your phone 25 cm away from you", Toast.LENGTH_LONG).show();
        up = findViewById(R.id.up);
        down = findViewById(R.id.down);
        right = findViewById(R.id.right);
        left = findViewById(R.id.left);
        next = findViewById(R.id.next2);
        direction = findViewById(R.id.direction);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                down.setChecked(false);
                left.setChecked(false);
                right.setChecked(false);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up.setChecked(false);
                left.setChecked(false);
                right.setChecked(false);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up.setChecked(false);
                down.setChecked(false);
                right.setChecked(false);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up.setChecked(false);
                down.setChecked(false);
                left.setChecked(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up1).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up2).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up3).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up4).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up5).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up6).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up7).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up8).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up9).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up10).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up11).getConstantState())
                        && up.isChecked()) {
                    score++;
                } else if ((direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down1).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down2).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down3).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down4).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down5).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down6).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down7).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down8).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down9).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down10).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down11).getConstantState())
                        && down.isChecked()) {
                    score++;
                } else if ((direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left1).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left2).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left3).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left4).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left5).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left6).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left7).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left8).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left9).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left10).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left11).getConstantState())
                        && left.isChecked()) {
                    score++;
                } else if ((direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right1).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right2).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right3).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right4).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right5).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right6).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right7).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right8).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right9).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right10).getConstantState()
                        || direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right11).getConstantState())
                        && right.isChecked()) {
                    score++;
                }
                if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up1).getConstantState()) {
                    direction.setImageResource(R.drawable.down1);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down1).getConstantState()) {
                    direction.setImageResource(R.drawable.left1);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left1).getConstantState()) {
                    direction.setImageResource(R.drawable.right2);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right2).getConstantState()) {
                    direction.setImageResource(R.drawable.down2);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down2).getConstantState()) {
                    direction.setImageResource(R.drawable.up2);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up2).getConstantState()) {
                    direction.setImageResource(R.drawable.left3);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left3).getConstantState()) {
                    direction.setImageResource(R.drawable.right3);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right3).getConstantState()) {
                    direction.setImageResource(R.drawable.down3);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down3).getConstantState()) {
                    direction.setImageResource(R.drawable.up4);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up4).getConstantState()) {
                    direction.setImageResource(R.drawable.left4);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left4).getConstantState()) {
                    direction.setImageResource(R.drawable.right4);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right4).getConstantState()) {
                    direction.setImageResource(R.drawable.down5);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down5).getConstantState()) {
                    direction.setImageResource(R.drawable.right5);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right5).getConstantState()) {
                    direction.setImageResource(R.drawable.left5);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left5).getConstantState()) {
                    direction.setImageResource(R.drawable.up6);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up6).getConstantState()) {
                    direction.setImageResource(R.drawable.down6);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down6).getConstantState()) {
                    direction.setImageResource(R.drawable.right6);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right6).getConstantState()) {
                    direction.setImageResource(R.drawable.left7);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left7).getConstantState()) {
                    direction.setImageResource(R.drawable.down7);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down7).getConstantState()) {
                    direction.setImageResource(R.drawable.right7);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right7).getConstantState()) {
                    direction.setImageResource(R.drawable.down8);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down8).getConstantState()) {
                    direction.setImageResource(R.drawable.up8);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up8).getConstantState()) {
                    direction.setImageResource(R.drawable.left8);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left8).getConstantState()) {
                    direction.setImageResource(R.drawable.right9);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right9).getConstantState()) {
                    direction.setImageResource(R.drawable.down9);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down9).getConstantState()) {
                    direction.setImageResource(R.drawable.up9);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up9).getConstantState()) {
                    direction.setImageResource(R.drawable.down10);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down10).getConstantState()) {
                    direction.setImageResource(R.drawable.left10);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left10).getConstantState()) {
                    direction.setImageResource(R.drawable.right10);
                }else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.right10).getConstantState()) {
                    direction.setImageResource(R.drawable.up11);
                }else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.up11).getConstantState()) {
                    direction.setImageResource(R.drawable.left11);
                }else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.left11).getConstantState()) {
                    direction.setImageResource(R.drawable.down11);
                } else if (direction.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.down11).getConstantState()) {
                    Intent navi = new Intent(acuity.this, acuity_result.class);
                    navi.putExtra("score", score);
                    startActivity(navi);
                }
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(acuity.this, vision.class);
                startActivity(navi);
            }
        });
    }
}