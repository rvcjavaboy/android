package com.chavan.ranjit.student;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
    }

    public void onDelete(View v){

        SQLiteDatabase db=new DBHelper(this).getWritableDatabase();
        int i=db.delete("Student","id="+((TextView)findViewById(R.id.id)).getText().toString(),null);

        if(i>0)
            Toast.makeText(this,"Deleted Sucessfully"+i,Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Id not found ",Toast.LENGTH_LONG).show();

    }
}
