package com.chavan.ranjit.example5;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        ListView l=(ListView)findViewById(R.id.prod);
        ArrayList<Integer> elements=new ArrayList<Integer>();
        Intent i = getIntent();
        Integer value=Integer.parseInt(i.getStringExtra("items"));


        for(int i1=1;i1<=value;i1++)
            elements.add(i1);


        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1,elements);

        l.setAdapter(adapter);



    }
}
