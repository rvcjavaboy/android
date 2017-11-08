package com.chavan.ranjit.example5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAddItem(View V){

        Bundle b=new Bundle();
        b.putString("items",((EditText)findViewById(R.id.text)).getText().toString());

        Intent i=new Intent(this,ListItem.class);
        i.putExtras(b);
        startActivity(i);
    }
}
