package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class signUp extends AppCompatActivity {
EditText name,mobno;
Spinner state,city,locality;
Button signUp;
List <String> displayCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name=(EditText)findViewById(R.id.etSignUpName);
        mobno=(EditText)findViewById(R.id.etSignUpPhone);
        state=(Spinner)findViewById(R.id.spSignUpState);
        city=(Spinner)findViewById(R.id.spSignUpCity);
        locality=(Spinner)findViewById(R.id.spSignUpLocality);
        signUp=(Button)findViewById(R.id.btSignUp);
        displayCity=new ArrayList<String>();
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection=parent.getItemAtPosition(position).toString();
                if(selection.equals("Tamil Nadu"))
                {
                    displayCity.add("Chennai");
                    ArrayAdapter<CharSequence> a1=ArrayAdapter.createFromResource(getApplicationContext(),R.array.tamilnadu,android.R.layout.simple_spinner_item);
                    a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    city.setAdapter(a1);




                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Select a value",Toast.LENGTH_LONG);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
