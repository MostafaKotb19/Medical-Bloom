package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Objects;

public class water_intake extends AppCompatActivity {
    TextView result;
    Button calc;
    EditText age;
    EditText weight;
    final double[] water = new double[1];
    DecimalFormat percision = new DecimalFormat("0.00");
    private int notificationId = 1;
    int notification_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_water_intake);
        result = findViewById(R.id.textView26);
        calc = findViewById(R.id.button27);
        age = findViewById(R.id.editText13);
        weight = findViewById(R.id.editText24);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float weight_number = Float.parseFloat(weight.getText().toString());
                float age_number = Float.parseFloat(age.getText().toString());
                if (age_number < 30) {
                    age_number = 40;
                }
                final float finalAge_number = age_number;
                water[0] = ((weight_number * finalAge_number) / 28.3) / 33.814;
                String water_t= percision.format(water[0]) +" "+ "Litres";
                result.setText(water_t);
                notification_time = (12*60*60*1000)/(int)(water[0]/0.240);
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(water_intake.this, "My Notification")
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Medical Bloom - drinking reminder")
                        .setContentText("You need to drink a cup of water now")
                        .setAutoCancel(true);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(water_intake.this);
                notificationManager.notify(notificationId, mBuilder.build());
                for (int j = 0; j<8; j++){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(water_intake.this, "My Notification")
                                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                                    .setContentTitle("Notification title")
                                    .setContentText("Content text")
                                    .setAutoCancel(true);
                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(water_intake.this);
                            notificationManager.notify(notificationId, mBuilder.build());
                        }
                    }, notification_time);
                }
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(water_intake.this, health_calculator.class);
                startActivity(navi);
            }
        });
    }
}
