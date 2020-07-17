package com.example.tanvi.myapp;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class dish4 extends AppCompatActivity {
    private Switch s4;
    private TextToSpeech ts4;
    private TextView soup;
    private ImageButton sp;
    private Button b4;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish4);


        s4=(Switch)findViewById(R.id.s4);
        soup=(TextView)findViewById(R.id.soup);
        sp=(ImageButton)findViewById(R.id.sp);
        b4=(Button)findViewById(R.id.b4);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        ts4=new TextToSpeech(dish4.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    ts4.setLanguage(Locale.US);
                }
            }
        });


        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = soup.getText().toString();
                Toast.makeText(dish4.this, toSpeak,Toast.LENGTH_SHORT).show();
                ts4.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        s4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(s4.isChecked()){

                    String dish4="Red Lentil And Roasted Tomato Soup";
                    myRef.child("dish4").setValue(dish4);
                    Toast.makeText(dish4.this,"You selected Red Lentil And Roasted Tomato Soup",Toast.LENGTH_LONG).show();
                }
            }
        });





        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void onPause() {
        if (ts4 != null) {
            ts4.stop();
            ts4.shutdown();
        }
        super.onPause();
    }


}
