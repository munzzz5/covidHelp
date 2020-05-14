package com.example.covid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import com.example.covid.user;
import com.example.covid.db;

public class signUp extends AppCompatActivity {
EditText name,mobno;
Spinner state,city,locality,days,months,years;
Button signUp;
private String selectionState,selectionCity,selectionLocal,uname,umob,dob;
String day1,month1,year1;
GregorianCalendar gcal;
private int trans,raw,vol;
CheckBox t1,r1,v1;
db db1;
Intent intent;
user u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db1=new db(getApplicationContext(),"",null,1);
        intent=new Intent(this,MainActivity.class);
        name=(EditText)findViewById(R.id.etSignUpName);
        mobno=(EditText)findViewById(R.id.etSignUpPhone);
        state=(Spinner)findViewById(R.id.spSignUpState);
        city=(Spinner)findViewById(R.id.spSignUpCity);
        locality=(Spinner)findViewById(R.id.spSignUpLocality);
        days=(Spinner)findViewById(R.id.signUpDay);
        months=(Spinner)findViewById(R.id.signUpMonth);
        years=(Spinner)findViewById(R.id.signUpYear);
        signUp=(Button)findViewById(R.id.btSignUp);
        t1=(CheckBox)findViewById(R.id.cbSignUpTransport);
        r1=(CheckBox)findViewById(R.id.cbSignUpRaw);
        v1=(CheckBox)findViewById(R.id.cbSignUpVol);
        days.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                day1=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        months.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                month1=String.valueOf(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        years.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year1=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectionState=parent.getItemAtPosition(position).toString();
                if(selectionState.equals("Tamil Nadu"))
                {
                    //displayCity.add("Chennai");
                    ArrayAdapter<CharSequence> a1=ArrayAdapter.createFromResource(getApplicationContext(),R.array.tamilnadu,android.R.layout.simple_spinner_item);
                    a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    city.setAdapter(a1);

                }

                else
                {
                    city.setAdapter(null);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Toast.makeText(getApplicationContext(),"Select a value for state",Toast.LENGTH_LONG).show();
            }
        });
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectionCity=parent.getItemAtPosition(position).toString();
                if(position==0){
                    Toast.makeText(getApplicationContext(),"Select a value for City",Toast.LENGTH_LONG).show();
                    selectionCity="";
                }
                else if(selectionCity.equals("Chennai"))
                {
                    ArrayAdapter<CharSequence> a1=ArrayAdapter.createFromResource(getApplicationContext(),R.array.chennaiLocal,android.R.layout.simple_spinner_item);
                    a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    locality.setAdapter(a1);

                }
                else
                {
                    locality.setAdapter(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Select a value for city",Toast.LENGTH_LONG).show();
            }
        });
        locality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Toast.makeText(getApplicationContext(),"Select a value for Locality",Toast.LENGTH_LONG).show();
                    selectionLocal="";
                }
                else {
                    selectionLocal = parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Select a value for city",Toast.LENGTH_LONG).show();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uname=name.getText().toString();
                umob=mobno.getText().toString();
                trans=t1.isChecked()?1:0;
                raw=r1.isChecked()?1:0;
                vol=v1.isChecked()?1:0;
                GregorianCalendar dateOfBirth=new GregorianCalendar(Integer.parseInt(year1),Integer.parseInt(month1),Integer.parseInt(day1));
                if((uname != null) && (uname != "") && (umob != null) && (umob != "") && (selectionCity != null) && (selectionCity != "") && (selectionLocal != null) && (selectionLocal != "")) {
                    u = new user(uname, umob,dateOfBirth, selectionState, selectionCity, selectionLocal, vol, raw, trans);
                    String newuid=db1.insertUser(u);

                    intent.putExtra("uid",newuid);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please fill all values", Toast.LENGTH_SHORT).show();
                }




            }
        });


    }


}
