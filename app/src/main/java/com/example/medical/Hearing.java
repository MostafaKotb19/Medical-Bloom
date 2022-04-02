package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Objects;

public class Hearing extends AppCompatActivity {
    private int duration = 3; // seconds
    private int sampleRate = 8000;
    private int numSamples = duration * sampleRate;
    private double[] sample = new double[numSamples];
    private double freqOfTone = 1;
    private byte[] generatedSnd = new byte[2 * numSamples];

    Button play;
    Button heard;
    Button submit;
    Button dleft;
    Button left;
    Button right;
    Button dright;
    TextView frequency;
    TextView range;
    SeekBar frequencylevel;

    double min=0, max=0, difference;
    String text, text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_hearing);
        play = findViewById(R.id.play);
        heard = findViewById(R.id.heard);
        submit = findViewById(R.id.submit);
        dleft = findViewById(R.id.dleft);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        dright = findViewById(R.id.dright);
        frequency = findViewById(R.id.frequency);
        range = findViewById(R.id.range);
        frequencylevel = findViewById(R.id.seekBar);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navi = new Intent(Hearing.this, Home.class);
                startActivity(navi);
            }
        });
        frequencylevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text = progress+ " Hz";
                frequency.setText(text);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        heard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frequencylevel.getProgress()>=10000){
                    max=frequencylevel.getProgress();
                }
                else if(frequencylevel.getProgress()<10000){
                    min=frequencylevel.getProgress();
                }
                text2 = min+"-"+max+"Hz";
                range.setText(text2);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difference = max-min;
                if(difference>=10000){
                    Intent navi = new Intent(Hearing.this, Hearing_result.class);
                    navi.putExtra("result","h");
                    navi.putExtra("max",max);
                    navi.putExtra("min",min);
                    startActivity(navi);
                }
                else if (difference<10000){
                    Intent navi = new Intent(Hearing.this, Hearing_result.class);
                    navi.putExtra("result","u");
                    navi.putExtra("max",max);
                    navi.putExtra("min",min);
                    startActivity(navi);
                }
            }
        });
        dleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frequencylevel.setProgress(frequencylevel.getProgress()-1000);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frequencylevel.setProgress(frequencylevel.getProgress()-100);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frequencylevel.setProgress(frequencylevel.getProgress()+100);
            }
        });
        dright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frequencylevel.setProgress(frequencylevel.getProgress()+1000);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freqOfTone = frequencylevel.getProgress();
                genTone();
                playSound();
            }
        });
    }
    void genTone(){
        // fill out the array
        for (int i = 0; i < numSamples; ++i) {
            sample[i] = Math.sin(2 * Math.PI * i / (sampleRate/freqOfTone));
        }

        // convert to 16 bit pcm sound array
        // assumes the sample buffer is normalised.
        int idx = 0;
        for (final double dVal : sample) {
            // scale to maximum amplitude
            final short val = (short) ((dVal * 32767));
            // in 16 bit wav PCM, first byte is the low order byte
            generatedSnd[idx++] = (byte) (val & 0x00ff);
            generatedSnd[idx++] = (byte) ((val & 0xff00) >>> 8);

        }
    }
    void playSound(){
        final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                sampleRate, AudioFormat.CHANNEL_CONFIGURATION_MONO,
                AudioFormat.ENCODING_PCM_16BIT, numSamples,
                AudioTrack.MODE_STATIC);
        audioTrack.write(generatedSnd, 0, generatedSnd.length);
        audioTrack.play();
    }
}