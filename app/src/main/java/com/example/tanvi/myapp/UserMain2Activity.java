package com.example.tanvi.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class UserMain2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button about;
        Button orderfood;
        Button salad;
        Button skew;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main2);

        about=(Button)findViewById(R.id.aboutbutton);
        orderfood=(Button)findViewById(R.id.foodorder);
        salad=(Button)findViewById(R.id.salad);
        skew=(Button)findViewById(R.id.skew);

        orderfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderfoodfunc(view);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aboutfunc(view);
            }

        });

        salad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saladfunc(view);
            }
        });

        skew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skewfunc(view);
            }
        });


    }
    public void aboutfunc(View view){
        Intent aboutintent = new Intent(this,AboutMainActivity.class);
        startActivity(aboutintent);
    }

    public void orderfoodfunc(View view){
        Intent orderfoodintent = new Intent(this,OrderFoodMainActivity.class);
        startActivity(orderfoodintent);
    }

    public void saladfunc(View view){
        Intent salad = new Intent(this,dish3.class);
        startActivity(salad);
    }

    public void skewfunc(View view){
        Intent skew = new Intent(this,dish5.class);
        startActivity(skew);

    }
}
