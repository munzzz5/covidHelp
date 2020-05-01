package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText loginId;
EditText password;
Button login;
CheckBox vol,raw,trans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, signUp.class);
        startActivity(intent);

        loginId=(EditText)findViewById(R.id.mainPageid);
        password=(EditText)findViewById(R.id.mainPagePass);
        login=(Button)findViewById(R.id.btnSignin);
        vol=(CheckBox)findViewById(R.id.cbSignUpVol);
        raw=(CheckBox)findViewById(R.id.cbSignUpRaw);
        trans=(CheckBox)findViewById(R.id.cbSignUpTransport);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
