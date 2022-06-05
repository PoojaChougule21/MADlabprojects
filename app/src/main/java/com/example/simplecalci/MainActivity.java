package com.example.simplecalci;

import static com.example.simplecalci.R.id.textView2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText1);
        e2=findViewById(R.id.editText2);
        tv1=findViewById(R.id.textView2);
    }
    public void add(View view)
    {
        int a1=Integer.parseInt(e1.getText().toString());
        int a2=Integer.parseInt(e2.getText().toString());
        int result=a1+a2;
        tv1.setText(" "+result);
    }
    public void sub(View view)
    {
        int a1=Integer.parseInt(e1.getText().toString());
        int a2=Integer.parseInt(e2.getText().toString());
        int result=a1-a2;
        tv1.setText(" "+result);
    }
    public void mul(View view)
    {
        int a1=Integer.parseInt(e1.getText().toString());
        int a2=Integer.parseInt(e2.getText().toString());
        int result=a1*a2;
        tv1.setText(" "+result);
    }
    public void div(View view)
    {
        int a1=Integer.parseInt(e1.getText().toString());
        int a2=Integer.parseInt(e2.getText().toString());
        int result=a1/a2;
        tv1.setText(" "+result);
    }
}