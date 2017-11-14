package com.chavan.ranjit.phonecall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View v){
        EditText e=(EditText)findViewById(R.id.editText);
        Toast.makeText(getApplicationContext(),"Calling to " + e.getText().toString() + "..." , Toast.LENGTH_LONG).show();

        //============================================
        //	Intnet used to call on Custom Number (As per EditText1 value)
        //  First add (CALL_PHONE) permission before using following code
        //===========================================
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},100);

            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:" + e.getText().toString() ));
        startActivity(i);
    }
}
