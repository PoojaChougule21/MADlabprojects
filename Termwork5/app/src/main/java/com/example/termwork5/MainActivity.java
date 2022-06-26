package com.example.termwork5;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView lblcounter;
    Button btnStart, btnstop;
    int counter=0;
    boolean running=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblcounter=(TextView) findViewById(R.id.textView3);
        btnStart=(Button) findViewById(R.id.button);
        btnstop=(Button) findViewById(R.id.button2);
        btnstop.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        if (v.equals(btnStart))
        {
            counter=0;
            running=true;
            new MyCounter().start();

        }
        else if(v.equals(btnstop))
        {
            running=false;
        }
    }
    Handler handler=new Handler()
    {
        public void handleMessage(Message m)
        {
            lblcounter.setText(String.valueOf(m.what));
        }
    };
    class MyCounter extends Thread{
        public void run()
        {
            while(running)
            {
                counter++;
                handler.sendEmptyMessage(counter);
                try { Thread.sleep(1000);}
                catch (Exception e) { }

            }
        }
    }
}
