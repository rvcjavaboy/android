package com.chavan.ranjit.message;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    ListView li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li=(ListView)findViewById(R.id.listmsg);
        String names[]=readMessage();
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        li.setAdapter(adp);


    }




    public String[] readMessage(){
        ArrayList<String> address=new ArrayList<String>();
        String names="";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_SMS},100);
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},100);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }
        Uri uriSMSURI = Uri.parse("content://sms/inbox");
        Cursor cur = getContentResolver().query(uriSMSURI, null, null, null, null);

        while (cur.moveToNext())
        {
            String phone = cur.getString(cur.getColumnIndex("address"));
            String name = cur.getString(cur.getColumnIndexOrThrow("body"));
            address.add(phone+"\n"+name);
        }

        ListIterator li=address.listIterator();
        while(li.hasNext()){
            names=names+","+li.next().toString();

        }


        return names.split(",");
    }
}
