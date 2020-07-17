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
import android.widget.Toast;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class OrderFoodMainActivity extends AppCompatActivity {
    private Switch s1;
   private TextToSpeech ts1;
    private TextView hummus;
    private ImageButton hp;
    private Button n1;
    private Button b1;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_food_main);
        s1=(Switch)findViewById(R.id.hnp);
        hummus=(TextView)findViewById(R.id.e1);
        hp=(ImageButton)findViewById(R.id.hp);
        n1=(Button)findViewById(R.id.n1);
        b1=(Button)findViewById(R.id.b1);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();


        ts1=new TextToSpeech(OrderFoodMainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    ts1.setLanguage(Locale.US);
                }
            }
        });

        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = hummus.getText().toString();
                Toast.makeText(OrderFoodMainActivity.this, toSpeak,Toast.LENGTH_SHORT).show();
                ts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(s1.isChecked()){

                    String dish1="Hummus and Pita";
                    myRef.child("dish1").setValue(dish1);
                    Toast.makeText(OrderFoodMainActivity.this,"You selected Hummus and Pita",Toast.LENGTH_LONG).show();
                }
            }
        });



        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dish2(view);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    public void onPause() {
        if (ts1 != null) {
            ts1.stop();
            ts1.shutdown();
        }
        super.onPause();
    }

    public void dish2(View view){
 Intent dish2=new Intent(this, com.example.tanvi.myapp.dish2.class);
 startActivity(dish2);
    }
}
