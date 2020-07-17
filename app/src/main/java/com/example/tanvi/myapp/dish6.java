package com.example.tanvi.myapp;

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

public class dish6 extends AppCompatActivity {
    private Switch s6;
    private TextToSpeech ts6;
    private TextView fal;
    private ImageButton f;
    private Button b6;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish6);

        s6=(Switch)findViewById(R.id.s6);
        fal=(TextView)findViewById(R.id.fal);
        f=(ImageButton)findViewById(R.id.f);
        b6=(Button)findViewById(R.id.b6);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        ts6=new TextToSpeech(dish6.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    ts6.setLanguage(Locale.US);
                }
            }
        });


        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = fal.getText().toString();
                Toast.makeText(dish6.this, toSpeak,Toast.LENGTH_SHORT).show();
                ts6.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        s6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(s6.isChecked()){

                    String dish6="Falafel";
                    myRef.child("dish6").setValue(dish6);
                    Toast.makeText(dish6.this,"You selected Falafel",Toast.LENGTH_LONG).show();
                }
            }
        });





        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void onPause() {
        if (ts6 != null) {
            ts6.stop();
            ts6.shutdown();
        }
        super.onPause();
    }
}
