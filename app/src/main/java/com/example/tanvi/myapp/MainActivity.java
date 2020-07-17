package com.example.tanvi.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 private TextView text;
private CheckBox user;
    private CheckBox admin;

    private Button btn;
    private EditText pass;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (TextView)findViewById(R.id.textView);
        user=(CheckBox)findViewById(R.id.ucheckBox);
        admin=(CheckBox)findViewById(R.id.acheckBox);

        btn=(Button)findViewById(R.id.GO);
        pass=(EditText)findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.isChecked()){
                    ufunct(view);

                    }
                   else if(admin.isChecked()){
                    afunct(pass.getText().toString());
                }
            }
        });

    }

    public void ufunct(View view) {
        Intent uintent = new Intent(this,UserMain2Activity.class);
        startActivity(uintent);


    }

    public void afunct(String pass1) {
        if (pass1.equals("admin")){
            Intent aintent = new Intent(this, AdminMain2Activity.class);
        startActivity(aintent);
    }

    }
}
