package com.chavan.ranjit.student;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Insert extends AppCompatActivity {
    TextView fname,lname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        fname=(TextView)findViewById(R.id.editText);
        lname=(TextView)findViewById(R.id.editText2);


    }

    public void onClickAdd(View v){
        SQLiteDatabase database;
        database = new DBHelper(this).getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("firstname",fname.getText().toString());
        c.put("lastname",lname.getText().toString());
      long l=  database.insert("student",null,c);
        Toast.makeText(getApplicationContext(),l+"",Toast.LENGTH_LONG).show();
     // database.close();
    }







}
