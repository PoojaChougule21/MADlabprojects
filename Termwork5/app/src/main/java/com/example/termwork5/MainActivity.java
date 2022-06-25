package com.example.termwork5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView lblCounter;
    Button btnStart, btnStop;
    int counter=0;
    boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblCounter=(TextView) findViewById(R.id.textView3);
        btnStart=(Button) findViewById(R.id.button);
        btnStop=(Button) findViewById(R.id.button2);
        btnStop.setOnClickListener((View.OnClickListener) this);
        btnStart.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View v)
    {
        if(v.equals(btnStart))
        {
            counter=0;
            running=true;
            new MyCounter().Start();
        }
        else if(v.equals(btnStop))
        {
            running=false;
        }
    }
    Handler handler=new Handler()
    {
        public void handleMessage(Message m)
        {
            lblCounter.setText(String.valueOf(m.what));
        }
    };
    class Mycounter extends Thread{
        public void run()
        {
            while(running)
            {
                counter++;
                handler.sendEmptyMessage(counter);
                try{Thread.sleep(1000);}
                catch (Exception e){}
            }
        }
    }

    private class MyCounter {
        public void Start() {
        }
    }
}