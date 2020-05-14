package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText loginId;
EditText password;
Button login,signup;
CheckBox vol,raw,trans;
String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signup=(Button)findViewById(R.id.goTosignUp);
        loginId=(EditText)findViewById(R.id.mainPageid);
        password=(EditText)findViewById(R.id.mainPagePass);
        login=(Button)findViewById(R.id.btnSignin);
        vol=(CheckBox)findViewById(R.id.cbSignUpVol);
        raw=(CheckBox)findViewById(R.id.cbSignUpRaw);
        trans=(CheckBox)findViewById(R.id.cbSignUpTransport);
        Intent i=getIntent();
        a=i.getStringExtra("uid");
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,signUp.class);
                startActivity(intent);
            }
        });
    }
}
