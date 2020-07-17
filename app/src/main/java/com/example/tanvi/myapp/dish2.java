package com.example.tanvi.myapp;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class dish2 extends AppCompatActivity {
    private Switch s2;
    private TextToSpeech ts2;
    private TextView lamb;
    private ImageButton l;
    //private Button n2;
    private Button b2;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish2);

        s2=(Switch)findViewById(R.id.ll);
        lamb=(TextView)findViewById(R.id.llm);
        l=(ImageButton)findViewById(R.id.l);
        //n2=(Button)findViewById(R.id.n2);
        b2=(Button)findViewById(R.id.b2);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        ts2=new TextToSpeech(dish2.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    ts2.setLanguage(Locale.US);
                }
            }
        });


        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = lamb.getText().toString();
                Toast.makeText(dish2.this, toSpeak,Toast.LENGTH_SHORT).show();
                ts2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(s2.isChecked()){

                    String dish2="Lamb Lahmajun";
                    myRef.child("dish2").setValue(dish2);
                    Toast.makeText(dish2.this,"You selected Lamb Lahmajun",Toast.LENGTH_LONG).show();
                }
            }
        });



        /*n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dish3(view);
            }
        });*/

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void onPause() {
       if (ts2 != null) {
           ts2.stop();
           ts2.shutdown();
       }
       super.onPause();
   }

   /* public void dish3(View view){
        Intent dish3=new Intent(this, com.example.tanvi.myapp.dish3.class);
        startActivity(dish3);
    }*/
}
