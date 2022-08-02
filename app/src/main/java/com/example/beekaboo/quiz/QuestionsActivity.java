package com.example.beekaboo.quiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class QuestionsActivity extends AppCompatActivity {

    public static CountDownTimer countDownTimer;
    TextView textview;
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private Intent serviceIntent;
    private Intent serviceIntent2;

    String questions[] = {
                            "What are the three types of access specifiers in C++?",
                            "Number of bits used by the IPv6 address",
                            "Which one is the first search engine in internet",
                            "Which one is the first web browser invented in 1990",
                            "First computer virus is known as.",
                            "Firewall in computer is used for ",
                            "1024 bit is equal to how many byte.",
                            "Who created the C programming language?",
                            ".gif is an extension of",
                            "Who is known as the father of internet?"
                         };
    String answers[] = {"Public, private, protected","128 bit","Archie","Nexus","Creeper Virus","Security","128 byte","Dennis Ritchie","Image File","Vint Cerf"};
    String opt[] = {
                    "Public, private, protected","Private, Subdue, Public","Public, Special, Protected","Public, static,protected",
                    "32 bit","64 bit","128 bit","256 bit",
                    "Google","Archie","Altavista","WAIS",
                    "Internet Explorer","Mosaic","Mozilla","Nexus",
                    "Rabbit","Creeper Virus","Elk Cloner","SCA Virus",
                    "Security","Data Transmission","Authentication","Monitoring",
                    "1 byte","128 byte","32 byte","64 byte",
                    "Abraham Lincoln","Dennis Ritchie","Albert Scotch","Ken Thompson",
                     "Video File","Image File","Word","Audio File",
                     "Alan Perlis","Jean E. Sammet","Vint Cerf","Steve Lawrence"
                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        textview = (TextView) findViewById(R.id.timer);
        Toast toast = null;
        long duration = TimeUnit.MINUTES.toMillis(1);
        countDownTimer = new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                ,TimeUnit.MILLISECONDS.toMinutes(l)
                ,TimeUnit.MILLISECONDS.toSeconds(l)-
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));

                textview.setText(sDuration);
            }

            @Override
            public void onFinish() {
                textview.setVisibility(View.GONE);
                

                Intent exitintent=new Intent(QuestionsActivity.this,TimesUpActivity.class);
                startActivity(exitintent);
                finish();
            }
        }.start();

        final TextView score = (TextView)findViewById(R.id.textView4);
        Intent intent = getIntent();


        submitbutton=(Button)findViewById(R.id.button3);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    serviceIntent = new Intent(getApplicationContext(), AudioClick.class);
                    startService(new Intent(getApplicationContext(),AudioClick.class));

                    correct++;
                   // Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toast_root));
                    TextView toastText = layout.findViewById(R.id.toast_text);

                    toastText.setText("Correct!");
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);

                    toast.show();

                }

                else {
                    serviceIntent2 = new Intent(getApplicationContext(), AudioClicker.class);
                    startService(new Intent(getApplicationContext(),AudioClicker.class));

                    wrong++;
                    //Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_layout_v2,(ViewGroup) findViewById(R.id.toast_root));
                    TextView toastText = layout.findViewById(R.id.toast_text1);
                  //  ImageView toastImage = layout.findViewById(R.id.toast_image1);

                    toastText.setText("Wrong!");
                  // toastImage.setImageResource(R.drawable.ic_baseline_close_24);
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);

                    toast.show();


                }
                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {

                    marks=correct;
                    countDownTimer.cancel();
                    textview.setVisibility(View.GONE);
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                    finish();

                }
                radio_g.clearCheck();
            }
        });


    }

}