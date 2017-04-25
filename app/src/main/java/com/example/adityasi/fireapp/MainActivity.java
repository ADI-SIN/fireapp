package com.example.adityasi.fireapp;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

   // private FirebaseAnalytics mFirebaseAnalytics;
   // private Firebase ref;
    private Button btn;
    private EditText mail;
    private EditText pass;
    private TextView user;
    //private ProgressBar progressBar;
    private ProgressDialog progressBar;

    //Firebase object for authentication
    private FirebaseAuth firebaseAuth;

    String email=" ";
    String password=" ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

       // Firebase.setAndroidContext(this);
        //ref=new Firebase("https://fireapp-47f8f.firebaseio.com/");

        progressBar= new ProgressDialog(this);

        firebaseAuth= FirebaseAuth.getInstance();

        btn= (Button)findViewById(R.id.btn);
        mail= (EditText)findViewById(R.id.editText);
        pass= (EditText)findViewById(R.id.editText2);
        user= (TextView)findViewById(R.id.textView3);


       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //   Firebase child= ref.child("Nmae");
               // child.setValue("Aditya");
            }
        });*/

        btn.setOnClickListener(this);
        user.setOnClickListener(this);



        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Registration not Successfull",Toast.LENGTH_SHORT).show();
                }
            }
        });

        progressBar.setMessage(" Registering User .....");
        progressBar.show();
    }

    private void register(){

        String email1= mail.getText().toString().trim();
        String password1= pass.getText().toString().trim();

        if(TextUtils.isEmpty(email1)){
            Toast.makeText(this," Enter a valid Email address",Toast.LENGTH_SHORT).show();

            return;
        }

        if(TextUtils.isEmpty(password1)){
            Toast.makeText(this," Enter the Password",Toast.LENGTH_SHORT).show();

            return;
        }
    }

    @Override
    public void onClick(View view) {

        if(view==btn)
        {
            register();
        }

        else if(view==user)
        {
            //login activity will be opened
        }

    }



}
