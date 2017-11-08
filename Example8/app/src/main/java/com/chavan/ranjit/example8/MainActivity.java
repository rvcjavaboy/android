package com.chavan.ranjit.example8;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Chronometer ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch=(Chronometer)findViewById(R.id.chronometer2);
    }




    public void OnClickToast(View v){

      final   String  t=((EditText)findViewById(R.id.editText)).getText().toString();
        if(t.equals("")||t==null){

            Toast.makeText(getApplicationContext(),"Please Enter Interval time",Toast.LENGTH_SHORT).show();
        }else{

          final  int time=Integer.parseInt(((EditText)findViewById(R.id.editText)).getText().toString());
            CountDownTimer c=new CountDownTimer(time*60*1000,1000) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    Toast toast=Toast.makeText(getApplicationContext(),"Toast Showing after "+t+ "second", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    ch.stop();
                }
            };
            c.start();
            ch.start();
        }




 /*       int time=Integer.parseInt(((EditText)findViewById(R.id.editText)).getText().toString());


        try{
            Thread.sleep(time*1000);
            Toast toast=Toast.makeText(getApplicationContext(),"Toast Showing after "+time*1000+ "second", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();


        }catch(Exception e){
            e.printStackTrace();
        }*/



    }
}
