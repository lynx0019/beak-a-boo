package com.example.beekaboo.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreboardActivity extends AppCompatActivity {
    TextView easyText, mediumText, hardText;
    public static Intent serviceIntent2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        Button exitbutton=(Button)findViewById(R.id.exit);

        easyText = (TextView)findViewById(R.id.easy);
        mediumText = (TextView)findViewById(R.id.medium);
        hardText = (TextView)findViewById(R.id.hard);
        StringBuffer sb = new StringBuffer();
        sb.append(QuestionsActivity.correct);
        StringBuffer sb1 = new StringBuffer();
        sb1.append(MediumQuestionActivity.correct);
        StringBuffer sb2 = new StringBuffer();
        sb2.append(HardQuestionActivity.correct);

        easyText.setText(sb);
        mediumText.setText(sb1);
        hardText.setText(sb2);



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
