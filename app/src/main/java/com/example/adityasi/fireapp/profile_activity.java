package com.example.adityasi.fireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile_activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn3;
    private TextView user3;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        /*if(firebaseAuth.getCurrentUser()==null){
            //new profile activity
            finish();
            startActivity( new Intent( getApplicationContext(),login_activity.class));
        }*/


        btn3= (Button)findViewById(R.id.btn3);
        user3= (TextView)findViewById(R.id.textView4);

        firebaseAuth= FirebaseAuth.getInstance();

        btn3.setOnClickListener(this);

        FirebaseUser firebaseUser= firebaseAuth.getCurrentUser();
        user3.setText("Welcome "+ firebaseUser.getEmail());
    }

    @Override
    public void onClick(View view) {

    }
}
