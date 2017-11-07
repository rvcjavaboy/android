package com.chavan.ranjit.example2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Bundle bundle = getIntent().getExtras();
        String text= bundle.getString("msg");

        TextView edi= (TextView)findViewById(R.id.msg);
        edi.setText(text);

    }
}
