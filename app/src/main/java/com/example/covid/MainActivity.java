package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.covid.db;
import com.example.covid.home.main_home;

public class MainActivity extends AppCompatActivity {
EditText loginId;
db db1;
EditText password;
Button login,signup;
CheckBox vol,raw,trans;

String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db1=new db(getApplicationContext(),"",null,1);

        signup=(Button)findViewById(R.id.goTosignUp);
        loginId=(EditText)findViewById(R.id.mainPageid);
        password=(EditText)findViewById(R.id.mainPagePass);
        login=(Button)findViewById(R.id.btnSignin);
        vol=(CheckBox)findViewById(R.id.cbSignUpVol);
        raw=(CheckBox)findViewById(R.id.cbSignUpRaw);
        trans=(CheckBox)findViewById(R.id.cbSignUpTransport);
        Intent i=getIntent();
        a=i.getStringExtra("uid");
        Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String ph=loginId.getText().toString();
                if(ph.equals("")||ph==null)
                {
                    Toast.makeText(getApplicationContext(),"Enter Phone Number",Toast.LENGTH_LONG);
                }
                else
                {
                    if(db1.checkPhNo(ph)!=null)
                    {
                        //Toast.makeText(getApplicationContext(),db1.checkPhNo(ph),Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(MainActivity.this, main_home.class);
                        intent.putExtra("mobno",db1.checkPhNo(ph));
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"No such user",Toast.LENGTH_LONG).show();
                    }
                }

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
