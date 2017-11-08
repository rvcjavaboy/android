package com.chavan.ranjit.example4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate invoked");
    }

    public void onClickButtonSubmit(View v){
        String name="rvcinfo9600@gmail.com",password="123456";


        String formname=((EditText)findViewById(R.id.uname)).getText().toString();
        String formpass=((EditText)findViewById(R.id.pass)).getText().toString();

        if(formname.equals(name)&&formpass.equals(password)){
            Intent url=new Intent("android.intent.action.VIEW");
            url.setData(Uri.parse("http://www.facebook.com"));
            startActivity(url);

        }else{
            Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
        }

    }



}



