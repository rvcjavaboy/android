package com.example.ranjit.emulator;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS},100);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }


    }

    public void OnSend(View v){

        String send=((EditText)findViewById(R.id.phone)).getText().toString();

        String message=((EditText)findViewById(R.id.msg)).getText().toString();

        if(send.length()!=10){
            Toast.makeText(this,"Invalid Phone no .",Toast.LENGTH_SHORT).show();
            ( (EditText)findViewById(R.id.phone)).requestFocus();
        }else if(message.equals(" ")){
            Toast.makeText(this,"enter message first .",Toast.LENGTH_SHORT).show();
            ( (EditText)findViewById(R.id.msg)).requestFocus();

        }else{

            SmsManager s=SmsManager.getDefault();
            PendingIntent pi;
            String msg = "android.telephony.SmsManager.STATUS_ON_ICC_SENT";
            PendingIntent piSent = PendingIntent.getBroadcast(MainActivity.this, 0,new Intent(msg), 0);
            s.sendTextMessage(send,null,message,piSent,null);
            Toast.makeText(this,"Message Send Successfully .",Toast.LENGTH_LONG).show();

        }





    }


}
