package com.example.beekaboo.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity{
    private Intent serviceIntent;
    private Intent serviceIntent2;

    private Button btnStart, btnStop;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final Button startBtn = (Button) findViewById(R.id.button);
        final Button exitBtn = (Button) findViewById(R.id.close);
        final Button scoreboardBtn = (Button) findViewById(R.id.scoreboard);
        final Button stopBtn = (Button) findViewById(R.id.stop);
        final Button start = (Button) findViewById(R.id.start);



        serviceIntent = new Intent(getApplicationContext(), Services.class);
        startService(new Intent(getApplicationContext(),Services.class));


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceIntent2 = new Intent(getApplicationContext(), BtnAudioClick.class);
                startService(new Intent(getApplicationContext(),BtnAudioClick.class));

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        scoreboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceIntent2 = new Intent(getApplicationContext(), BtnAudioClick.class);
                startService(new Intent(getApplicationContext(),BtnAudioClick.class));
                Intent sintent = new Intent(getApplicationContext(), ScoreboardActivity.class);
                startActivity(sintent);
                finish();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceIntent2 = new Intent(getApplicationContext(), BtnAudioClick.class);
                startService(new Intent(getApplicationContext(),BtnAudioClick.class));
                startService(new Intent(getApplicationContext(),Services.class));
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceIntent2 = new Intent(getApplicationContext(), BtnAudioClick.class);
                startService(new Intent(getApplicationContext(),BtnAudioClick.class));
                stopService(new Intent(getApplicationContext(),Services.class));
            }
        });
    }


}
