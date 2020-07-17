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

public class dish3 extends AppCompatActivity {
    private Switch s3;
    private TextToSpeech ts3;
    private TextView tab;
    private ImageButton t;
    private Button n3;
    private Button b3;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish3);

        s3=(Switch)findViewById(R.id.s3);
        tab=(TextView)findViewById(R.id.tab);
        t=(ImageButton)findViewById(R.id.t);
        n3=(Button)findViewById(R.id.n3);
        b3=(Button)findViewById(R.id.b3);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        ts3=new TextToSpeech(dish3.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    ts3.setLanguage(Locale.US);
                }
            }
        });


        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = tab.getText().toString();
                Toast.makeText(dish3.this, toSpeak,Toast.LENGTH_SHORT).show();
                ts3.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(s3.isChecked()){

                    String dish3="Tabbouleh";
                    myRef.child("dish3").setValue(dish3);
                    Toast.makeText(dish3.this,"You selected Tabbouleh",Toast.LENGTH_LONG).show();
                }
            }
        });



        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dish4(view);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void onPause() {
        if (ts3 != null) {
            ts3.stop();
            ts3.shutdown();
        }
        super.onPause();
    }

    public void dish4(View view){
        Intent dish4=new Intent(this, com.example.tanvi.myapp.dish4.class);
        startActivity(dish4);
    }
}
