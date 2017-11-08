package com.chavan.ranjit.example6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner sp=(Spinner)findViewById(R.id.spinner);
        img=(ImageView)findViewById(R.id.imageView);


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0)
                    img.setImageResource(R.drawable.java);
                 else if(i==1)
                     img.setImageResource(R.drawable.android);
                 else if(i==2)
                     img.setImageResource(R.drawable.download);
                 else
                     img.setImageResource(R.drawable.python);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
