package com.example.tanvi.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminMain2Activity extends AppCompatActivity {
    private TextView dish1,dish2,dish3;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference myRef;
    private Button refresh;
    private ListView listView;
    private ArrayList<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main2);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        refresh=(Button)findViewById(R.id.button2);

        listView=(ListView)findViewById(R.id.list1);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
        listView.setAdapter(adapter);

        ValueEventListener valueEventListener=new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String disha=(String) dataSnapshot.child("dish1").getValue(String.class);
                String dishb=(String) dataSnapshot.child("dish2").getValue(String.class);
                String dishc=(String) dataSnapshot.child("dish3").getValue(String.class);
                String dishd=(String) dataSnapshot.child("dish4").getValue(String.class);
                String dishe=(String) dataSnapshot.child("dish5").getValue(String.class);
                String dishf=(String) dataSnapshot.child("dish6").getValue(String.class);
                if(disha!=null){
                    list.add(disha);
                    }
                if(dishb!=null){
                    list.add(dishb);
                }

                if(dishc!=null){
                    list.add(dishc);
                }
                if(dishd!=null){
                    list.add(dishd);
                }
                if(dishe!=null){
                    list.add(dishe);
                }
                if(dishf!=null){
                    list.add(dishf);
                }


                adapter.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        myRef.addListenerForSingleValueEvent(valueEventListener);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.removeValue();
                list.clear();
                adapter.notifyDataSetChanged();
            }
        });

    }
}
