package com.chavan.ranjit.example31;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText  pass;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.editText6);
        pass=(EditText)findViewById(R.id.password);
        submit=(Button)findViewById(R.id.submit);
        email.requestFocus();
        submit.setEnabled(false);
        pass.setEnabled(false);
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if(android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                    pass.setEnabled(true);
                    pass.requestFocus();
                    submit.setEnabled(false);
                }else{
                  //  Toast.makeText(getApplicationContext(),getResources().getString(R.string.email_valid_msg), Toast.LENGTH_SHORT).show();

                    email.setError(getResources().getString(R.string.email_valid_msg));

                }



            }
        });

       pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                    pass.setError(getResources().getString(R.string.pass_valid_msg));
            }
        });

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(pass.getText().toString().length()>8&&pass.getText().toString().length()<16){
                    submit.setEnabled(true);
                    submit.requestFocus();

                }
            }
        });



    }


    public void onClickButton(View v){

        Intent i=new Intent(this,Admin.class);
        startActivity(i);

    }
}
