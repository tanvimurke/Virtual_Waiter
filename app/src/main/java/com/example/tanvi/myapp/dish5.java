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

public class dish5 extends AppCompatActivity {
    private Switch s5;
    private TextToSpeech ts5;
    private TextView kebab;
    private ImageButton k;
    private Button n5;
    private Button b5;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish5);

        s5=(Switch)findViewById(R.id.s5);
        kebab=(TextView)findViewById(R.id.kebab);
        k=(ImageButton)findViewById(R.id.k);
        n5=(Button)findViewById(R.id.n5);
        b5=(Button)findViewById(R.id.b5);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        ts5=new TextToSpeech(dish5.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    ts5.setLanguage(Locale.US);
                }
            }
        });


        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = kebab.getText().toString();
                Toast.makeText(dish5.this, toSpeak,Toast.LENGTH_SHORT).show();
                ts5.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        s5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(s5.isChecked()){

                    String dish5="Chicken kebab";
                    myRef.child("dish5").setValue(dish5);
                    Toast.makeText(dish5.this,"You selected Chicken Kebab",Toast.LENGTH_LONG).show();
                }
            }
        });



        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dish6(view);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void onPause() {
        if (ts5 != null) {
            ts5.stop();
            ts5.shutdown();
        }
        super.onPause();
    }

    public void dish6(View view){
        Intent dish6=new Intent(this, com.example.tanvi.myapp.dish6.class);
        startActivity(dish6);
    }
}
