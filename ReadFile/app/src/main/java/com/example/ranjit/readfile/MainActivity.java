package com.example.ranjit.readfile;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }
             String location= Environment.getExternalStorageDirectory().getPath()+"/demo.txt";
            try {
                ((TextView)findViewById(R.id.textView)).setText("File Location  "+location);
                InputStream f = new FileInputStream(new File(location));

                String s="";
                int c;
                while((c=f.read())!=-1){

                    s=s+(char)c;
                }
                f.close();
                ((EditText)findViewById(R.id.editText)).setText(s);

            }catch(FileNotFoundException e){
                Toast.makeText(this,"File Not Found !!!"+e,Toast.LENGTH_SHORT).show();
            }catch(IOException e){
                Toast.makeText(this,"IO Exception !!!"+e,Toast.LENGTH_SHORT).show();

            }
    }
}
