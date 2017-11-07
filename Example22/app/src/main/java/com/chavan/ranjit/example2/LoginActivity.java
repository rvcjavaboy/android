package com.chavan.ranjit.example2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
     String username="rvcinfo",password="123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);






    }

    public void checkLogin(View v) {

        EditText user=(EditText)findViewById(R.id.username);
        EditText pass=(EditText)findViewById(R.id.password);


        if(username.equals(user.getText().toString())&&password.equals(pass.getText().toString())){
            //System.out.println(user.getText()+" @ "+pass.getText());
            Intent home=new Intent(this,Admin.class);
            Bundle bean=new Bundle();
            bean.putString("msg","Welcome "+user.getText().toString()+" !!!!");
            home.putExtras(bean);
            startActivity(home);

        }else{

            Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();

        }

    }






    public void exitApp(View v){
        finish();
        System.exit(0);
    }

}
