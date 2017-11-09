package com.chavan.ranjit.cars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li=(ListView)findViewById(R.id.list);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b=new Bundle();
                b.putString("keys",li.getItemAtPosition(i).toString());
                Intent i1=new Intent(getApplicationContext(),CarsInfo.class);
                i1.putExtras(b);
                startActivity(i1);


            }
        });

    }
}
