package com.chavan.ranjit.example7;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id=item.getItemId();

       if(id==R.id.cyan)
              getWindow().getDecorView().setBackgroundColor(Color.parseColor("#ffae19"));

       else if(id==R.id.yellow)
           getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
       else if(id==R.id.green)
           getWindow().getDecorView().setBackgroundColor(Color.GREEN);
       else
           getWindow().getDecorView().setBackgroundColor(Color.GRAY);






        return true;
    }
}
