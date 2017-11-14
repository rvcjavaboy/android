package com.example.asif.android_21;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Button next,prev;
    int total,current;
    Cursor cur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }
        iv=findViewById(R.id.imageView);
        next=findViewById(R.id.bNext);
        prev=findViewById(R.id.bPrev);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current++;
                cur.moveToNext();
                iv.setImageBitmap(BitmapFactory.decodeFile(cur.getString(1)));
                if(current==total)
                {
                    next.setEnabled(false);
                }
                prev.setEnabled(true);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current--;
                cur.moveToPrevious();
                iv.setImageBitmap(BitmapFactory.decodeFile(cur.getString(1)));
                if(current==1)
                {
                    prev.setEnabled(false);
                }
                next.setEnabled(true);
            }
        });


        //Uri umedia=Uri.parse(Media.EXTERNAL_CONTENT_URI);
        Uri umedia=Uri.parse("content://media/external/images/media");

        cur=managedQuery(umedia, null, null,null,null);
        total=cur.getCount();

        current=1;
        cur.moveToNext();
        iv.setImageBitmap(BitmapFactory.decodeFile(cur.getString(1)));
    }
}
