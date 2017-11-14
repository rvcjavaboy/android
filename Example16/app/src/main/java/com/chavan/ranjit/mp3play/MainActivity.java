package com.chavan.ranjit.mp3play;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }
        MediaPlayer mp1;
        TextView tx=(TextView)findViewById(R.id.textView);
        tx.setText(Environment.getDownloadCacheDirectory().getPath()+"/raj.mp3");
        mp1 = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/raj1.mp3"));
        mp1.setLooping(true);
        mp1.start();



    }
}
