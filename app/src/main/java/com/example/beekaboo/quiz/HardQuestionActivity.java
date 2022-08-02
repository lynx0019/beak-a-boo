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

public class HardQuestionActivity extends AppCompatActivity {

    TextView textview;
    TextView tv;
    public static CountDownTimer countDownTimer;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private Intent serviceIntent;
    private Intent serviceIntent2;
    String questions[] = {
            "When I click on an icon to open a file what is the input device I use?",
            "What device can be used to input sound?",
            "The operating program does what?",
            "What does System Software consist of?",
            "In the simplest terms, a computer is a machine that stores and processes what?",
            "Which leading computer software bussnies created programes like Spread Sheet, Word and Power point?",
            "What is the only thing that computers understand?",
            "A list of instructions that enable a computer to perform a specific task is _.",
            "A device that can be used to measure a physical property by detecting some type of information from the physical world.",
            "Requests package is very popular HTTP library for _____",
            "What is a raspberry pi and how does it work?",
            "What circuits in which signals vary continuously with time?",
            "Which type of file does the SharedPreferences object save data to?",
            "In a key-value pair, what is the key that uniquely identifies the preference?",
            "What is the full form of DBMS?",
            "Who created the first DBMS?",
            "Which type of data can be stored in the database?",
            "Which of the following is a feature of DBMS?",
            "Which of the following is not a function of the database?",
            "What is the full form of AI?",
            "Who is the inventor of Artificial Intelligence?",
            "Which of the following is the branch of Artificial Intelligence?",
            "What is the goal of Artificial Intelligence?",
            "Which of the following is not a type of Artificial Intelligence agent?",
            "What is IoT?",
            "Who coined the term “Internet of Things”? ",
            "Which of the following is not an IoT platform?",
            "Which layer is used for wireless connection in IoT devices?",
            "Which of the following is not a sensor in IoT?",


    };
    String answers[] = {"Mouse","Microphone","A program that manages all other programs on the computer","The operating system","Data","Microsoft","Machine Code","Computer Program","Sensor","Python","A small, low cost, single-board computer", "Print", "Analog Circuit", "XML","String","Database Management System", "Charles Bachman","All of the above","Single-user Access only","Analysing code","Artificial Intelligence", "John McCarthy", "Machine Learning", "To explain various sorts of intelligence", "Unity-based AI agent","network of physical objects embedded with sensors","Kevin Aston", "Flipkart","Data link layer","LED"};
    String opt[] = {
            "Screen","Mouse","Keyboard","Word",
            "Screen","Mouse","Speakers","Microphone",
            "Goftware that is embedded in a hardware device","A specific type of software developed to allow interaction with hardware devices","A program that manages all other programs on the computer","None of the above",
            "The operating system","Graphics software","Private software","Drivers",
            "The operating system","Data","Games","Pictures",
            "Google","Apple","Microsoft","Dell",
            "Machine Code","Low level languages","High level languages","Algorithms",
            "Computer Program","Algorithm","Machine code","Binary code",
            "Sensor","Actuators","Controllers","Led",
            "C","Embedded C","Python","Java",
            "A small, low cost, single-board computer","A python function for conditional logic","An object-oriented programming language","A cloud-based service for teaching Iot ",
            "Print","Return","For","From",
            "Analog Circuit","Passive Circuit","Digital Circuit","Active Circuit",
            "Src","Res","XML","Dat",
            "Int","String","Float","Boolean",
            "Data of Binary Management System","Database Management System","Database Management Service","Data Backup Management System",
            "Edgar Frank Codd","Charles Bachman","Charles Babbage","Sharon B. Codd",
            "Image oriented data","Text, files containing data","Data in the form of audio or video","All of the above",
            "Minimum Duplication and Redundancy of Data","High Level of Security","Single-user Access only","Support ACID Property",
            "Managing stored data","Manipulating data","Security for stored data","Analysing code",
            "Artificially Intelligent","Artificial Intelligence","Artificially Intelligence","Advanced Intelligence",
            "Geoffrey Hinton","Andrew Ng","John McCarthy","Jürgen Schmidhuber",
            "Machine Learning","Cyber forensics","Full-Stack Developer","Network Design",
            "To solve artificial problems","To extract scientific causes","To explain various sorts of intelligence","To solve real-world problems",
            "Learning AI agent","Goal-based AI agent","Simple reflex AI agent","Unity-based AI agent",
            "network of physical objects embedded with sensors","network of virtual objects","network of objects in the ring structure","network of sensors",
            "Kevin Aston","John Wright","Edward Jameson","George Garton",
            "Amazon Web Services","Microsoft Azure","Salesforce","Flipkart",
            "Application layer","Network layer","Data link layer","Transport layer",
            "BMP280","DHT11","Photoresistor","LED"


    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_hard);

        textview = (TextView) findViewById(R.id.timer);

        long duration = TimeUnit.MINUTES.toMillis(3);
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
                Intent exitintent=new Intent(HardQuestionActivity.this,TimesUpActivity.class);
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
                    serviceIntent = new Intent(getApplicationContext(), AudioClicker.class);
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
                    countDownTimer.cancel();
                    textview.setVisibility(View.GONE);
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultHardActivity.class);
                    startActivity(in);
                    finish();
                }
                radio_g.clearCheck();
            }
        });


    }

}