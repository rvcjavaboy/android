package com.chavan.ranjit.student;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);





    }public void onClickUpdate(View v){

        SQLiteDatabase db=new DBHelper(this).getReadableDatabase();
        ContentValues c=new ContentValues();
        c.put("firstname",((EditText)findViewById(R.id.fname)).getText().toString());
        c.put("lastname",((EditText)findViewById(R.id.lname)).getText().toString());
        int i=db.update("Student",c,"id="+ ((TextView)findViewById(R.id.id)).getText().toString(),null);

    if(i>0)
        Toast.makeText(this,"Update Sucessfully"+i,Toast.LENGTH_LONG).show();
    else
        Toast.makeText(this,"Id not found ",Toast.LENGTH_LONG).show();

    }
}
