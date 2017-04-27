package com.example.adityasi.fireapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_activity extends AppCompatActivity implements View.OnClickListener{

    private Button btn2;
    private EditText mail2;
    private EditText pass2;
    private TextView user2;
    //private ProgressBar progressBar;
    private ProgressDialog progressBar;

    //Firebase object for authentication
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

       /* if(firebaseAuth.getCurrentUser()!=null){
            //new profile activity
            finish();
            startActivity( new Intent( getApplicationContext(),profile_activity.class));
        }*/

        progressBar= new ProgressDialog(this);

        firebaseAuth= FirebaseAuth.getInstance();

        btn2= (Button)findViewById(R.id.btn2);
        mail2= (EditText)findViewById(R.id.editText3);
        pass2= (EditText)findViewById(R.id.editText4);
        user2= (TextView)findViewById(R.id.textView5);

        btn2.setOnClickListener(this);
        user2.setOnClickListener(this);





        progressBar.setMessage(" Registering User .....");
        progressBar.show();


    }

    private void loggedin(){

        String email= mail2.getText().toString().trim();
        String password= pass2.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this," Enter a valid Email address",Toast.LENGTH_SHORT).show();

            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this," Enter the Password",Toast.LENGTH_SHORT).show();

            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.dismiss();

                if(task.isSuccessful())
                {
                    //new profile activity
                    finish();
                    startActivity( new Intent( getApplicationContext(),profile_activity.class));
                   // Toast.makeText(login_activity.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(login_activity.this,"Login not Successfull",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        if(view==btn2)
        {
            loggedin();
        }

        else if(view==user2)
        {
            //login activity will be opened
            finish();
            startActivity( new Intent(this, MainActivity.class));
        }
    }
}
