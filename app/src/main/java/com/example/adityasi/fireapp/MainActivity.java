package com.example.adityasi.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

   // private FirebaseAnalytics mFirebaseAnalytics;
    private Firebase ref;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Firebase.setAndroidContext(this);
        ref=new Firebase("https://fireapp-47f8f.firebaseio.com/");

        btn= (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Firebase child= ref.child("Nmae");
                child.setValue("Aditya");
            }
        });


    }
}
