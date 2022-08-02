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
import java.util.concurrent.TimeUnit;

public class MediumQuestionActivity extends AppCompatActivity {

    public static CountDownTimer countDownTimer;
    TextView textview;
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private Intent serviceIntent;
    private Intent serviceIntent2;
    String questions[] = {
            "In the process of communication the first step is?",
            "How many printing characters are there in ASCII?",
            "Logarithm table was invented by?",
            "Logarithm table was invented by?",
            "URL stands for",
            "UPS stands for",
            "Flip flop circuit store _ of data?",
            "A computer executes Programs in the sequence of",
            "Which of the following is in the ascending order of Data hierarchy?",
            "Who is known as the inventor of Computer mouse?",
            "Which one is the current fastest supercomputer in India?",
            "Internet is an example of __.",
            "Which of the following uses UDP as the transport protocol?",
            "The full form of BCD is ______",
            "What is an example of system software?",
            "What does system software consist of?",
            "The following file types are all video formats except",
            "The following are compressed file formats",
            "CACHES are usually built out of",
            "COBOL stands for "

    };
    String answers[] = {"Encoding","94","John Napier","Sunway TaihuLight","Uniform Resource Locator","Uninterruptible Power Supply","One bit","Decode, Fetch, Execute","Bit-Byte-Field-Record-File-Database","Douglas Engelbart","Sahasra T","Wide Area Network","DNS","Binary Coded Decimal","Firmware","The operating system","Mov",".zip, .jpeg, .mp3","SRAMS","Common Business Oriented Language"};
    String opt[] = {
            "Encoding","Message","Decoding","Receiving",
            "62","79","85","94",
            "John Douglas","John Doe","John Harrison","John Napier",
            "Tianhe-2","Titan","Trinity","Sunway TaihuLight",
            "Uniform Resource Locator","Universal Resource Locator","Unique Resource Locator","Uniform Reserve Locator",
            "Universal Power Supply","Universal Power Source","Uninterruptible Power Standby","Uninterruptible Power Supply ",
            "One bit","One byte","8 bit","8 byte",
            "Decode, Fetch, Execute","Execute, Decode, Fetch","Fetch, Decode, Execute","Store, Fetch, Execute",
            "Bit-Byte-Record-Field-Database-File","Byte-Bit-Record-File-Field-Database","Bit-Byte-Field-Record-File-Database","Field-Byte-Bit-Record-Database-File",
            "Douglas Engelbart","Herman Hollerith","Tom Cranston","Jack Kilby",
            "Aaditya","SAGA-220","Sahasra T ","HP Apollo 6000 ",
            "Local Area Network ","Metropolitan Area Network","Wide Area Network","Storage Network",
            "HTTP","SMTP","DNS","Telnet",
            "Bit Coded Decimal","Binary Coded Decimal","Bit Coded Digit","Binary Coded Digit",
            "Adobe Photoshop","Firmware","Microsoft Word","Notepad",
            "The operating system","Private Software","Graphics Software","Public Software",
            "Mov","Xls","Aiff","Wav",
            ".zip, .jp eg, .mp3 ",".txt, .psd",".wav, .docx",".exl, .cpt",
            "SRAMS","DRAMS","PROM","EEPROM",
            "Common Bulck Language ","Common Block Oriented Language","Common Business Oriented Language","None of the above"



    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_medium);

        textview = (TextView) findViewById(R.id.timer);

        long duration = TimeUnit.MINUTES.toMillis(2);


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
                Intent exitintent=new Intent(MediumQuestionActivity.this,TimesUpActivity.class);
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
                    Intent in = new Intent(getApplicationContext(),ResultMediumActivity.class);
                    startActivity(in);
                    finish();
                }
                radio_g.clearCheck();
            }
        });


    }

}