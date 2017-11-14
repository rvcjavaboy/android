package com.chavan.ranjit.readfile;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tx=(TextView)findViewById(R.id.textView);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }

        try {
            InputStream in=getResources().getAssets().open("s.txt");
            int read;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte b[]=new byte[in.available()];
            while((read=in.read(b,0,b.length))!=-1){

            buffer.write(b,0,read);
            }
            b=buffer.toByteArray();




            String locate= Environment.getExternalStorageDirectory().getPath()+"/s.txt";
            tx.setText(b.length+""+locate);

            FileOutputStream fos=new FileOutputStream(new File(locate));
            fos.write(b);
            fos.close();





        } catch (IOException e) {
            tx.setText(""+e);
        }
    }
}
