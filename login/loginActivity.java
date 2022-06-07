package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText emailText,passwordText;
    String rEmail,rpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailText=findViewById(R.id.editTextEmail);
        passwordText=findViewById(R.id.editTextPassword);
        rEmail=getIntent().getStringExtra("email");
        rpassword=getIntent().getStringExtra("password");

    }
    public void login(View view){
        String email=emailText.getText().toString();
        String password=passwordText.getText().toString();
        if(rEmail.equals(email)&&rpassword.equals(password))
        {
            Intent intent=new Intent(this,loginsuccess.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"invalid Credential",Toast.LENGTH_LONG).show();
        }
    }
}