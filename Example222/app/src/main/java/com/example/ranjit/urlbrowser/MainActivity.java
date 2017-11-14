package com.example.ranjit.urlbrowser;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView wv;
    Button b;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        wv=(WebView)findViewById(R.id.webView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.INTERNET},100);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }


    }

    public void onClickGo(View v){
       url=((EditText)findViewById(R.id.editText)).getText().toString();
        if(url.equals("")){
            Toast.makeText(this,"Please Enter Url  ",Toast.LENGTH_SHORT).show();
        }else if(!url.startsWith("http://")&&!url.startsWith("https://")){
            wv.getSettings().setJavaScriptEnabled(true);
            wv.loadUrl("https://www.google.co.in/search?q="+url);
        }else{
            wv.getSettings().setJavaScriptEnabled(true);
            wv.loadUrl(url);

        }

    }
}
