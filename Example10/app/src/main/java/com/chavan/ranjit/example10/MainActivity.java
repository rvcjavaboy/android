package com.chavan.ranjit.example10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp=(Spinner)findViewById(R.id.spinner);
        img=(ImageView)findViewById(R.id.imageView);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Animation an = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                    img.startAnimation(an);

                }else if(i==1){
                    Animation an = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                    img.startAnimation(an);


                }
                else if(i==2){
                    Animation an = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
                    img.startAnimation(an);


                }else{
                    Animation an = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                    img.startAnimation(an);


                }






            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }






}
