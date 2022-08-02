package com.example.beekaboo.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Intent serviceIntent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startbutton=(Button)findViewById(R.id.button);
        Button mediumbutton=(Button)findViewById(R.id.mediumBtn);
        Button hardbutton=(Button)findViewById(R.id.hardBtn);

        Button exitbutton=(Button)findViewById(R.id.exit);


                startbutton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        QuestionsActivity.correct=0;
                        QuestionsActivity.wrong=0;
                        serviceIntent2 = new Intent(getApplicationContext(), BtnAudioClick.class);
                        startService(new Intent(getApplicationContext(),BtnAudioClick.class));
                        Intent intent=new Intent(getApplicationContext(),QuestionsActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                 mediumbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediumQuestionActivity.correct=0;
                MediumQuestionActivity.wrong=0;
                serviceIntent2 = new Intent(getApplicationContext(), BtnAudioClick.class);
                startService(new Intent(getApplicationContext(),BtnAudioClick.class));
                Intent mintent=new Intent(getApplicationContext(),MediumQuestionActivity.class);
                startActivity(mintent);
                finish();
            }
             });


        hardbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HardQuestionActivity.correct=0;
                HardQuestionActivity.wrong=0;
                serviceIntent2 = new Intent(getApplicationContext(), BtnAudioClick.class);
                startService(new Intent(getApplicationContext(),BtnAudioClick.class));
                Intent hintent=new Intent(getApplicationContext(),HardQuestionActivity.class);
                startActivity(hintent);
                finish();
            }
        });


        exitbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        serviceIntent2 = new Intent(getApplicationContext(), BtnAudioClick.class);
                        startService(new Intent(getApplicationContext(),BtnAudioClick.class));
                        Intent intent=new Intent(getApplicationContext(),StartActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}
