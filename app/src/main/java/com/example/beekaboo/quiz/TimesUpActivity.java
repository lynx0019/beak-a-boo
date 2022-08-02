package com.example.beekaboo.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TimesUpActivity extends AppCompatActivity {
    private Intent serviceIntent2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timesup);
        final Button exitBtn = (Button) findViewById(R.id.btnExit);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceIntent2 = new Intent(getApplicationContext(), BtnAudioClick.class);
                startService(new Intent(getApplicationContext(),BtnAudioClick.class));
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
