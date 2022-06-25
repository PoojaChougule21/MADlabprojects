package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText emailText,passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailText=findViewById(R.id.editTextEmail);
        passwordText=findViewById(R.id.editTextPassword);
    }
    public void signup(View view)
    {
        String email=emailText.getText().toString();
        String password=passwordText.getText().toString();
        if(!isvalidpassword(password))
        {
            Toast.makeText(this,"password does not match",Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent=new Intent(this,loginActivity.class);
        intent.putExtra("email",email);
        intent.putExtra("password",password);
        startActivity(intent);

        }
        Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern schar=Pattern.compile("^.*[^a-zA-Z0-9].*$");
    private Boolean isvalidpassword(String password)
    {
        if(password.length()<8)
        {
            return false;
        }
        if(!lowercase.matcher(password).matches()){
            return false;
        }
        if(!uppercase.matcher(password).matches()){
            return false;
        }
        if(!number.matcher(password).matches()){
            return false;
        }
        if(!schar.matcher(password).matches()){
            return false;
        }
        return true;
    }
}