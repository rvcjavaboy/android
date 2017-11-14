package com.chavan.ranjit.student;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView l=(ListView)findViewById(R.id.listView);
        DBHelper db1=new DBHelper(this);
        String s[]=showStudent(db1);
        if(s!=null) {
            ArrayAdapter<String> adpter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, s);
            l.setAdapter(adpter);
        }



    }

    public String[] showStudent(DBHelper helper){

    db=helper.getReadableDatabase();
    String proj[]={"id","firstname","lastname"};
        Cursor cursor = db.query("Student",proj, null, null, null, null, null);
        String s[]=null;
        if(cursor.getCount()>0) {
           s = new String[cursor.getCount()];
            for(int i=0;i<cursor.getCount();i++){

                cursor.moveToNext();

               s[i]=cursor.getInt(0)+" \t"+cursor.getString(1)+" \t"+cursor.getString(2);

            }

        }
        return  s;
    } protected void onResume() {

        super.onResume();
        ListView l=(ListView)findViewById(R.id.listView);
        DBHelper db1=new DBHelper(this);
        String s[]=showStudent(db1);
        if(s!=null) {
            ArrayAdapter<String> adpter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, s);
            l.setAdapter(adpter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_select) {
            return true;
        }else if(id==R.id.action_insert){

            Intent i=new Intent(this,Insert.class);
            startActivity(i);


        }else if(id==R.id.action_update){
            Intent i=new Intent(this,update.class);
            startActivity(i);


        }
        else if(id==R.id.action_delete){
        Intent i=new Intent(this,Delete.class);
        startActivity(i);


    }


        return super.onOptionsItemSelected(item);
    }
}
