package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.username);
    }

    public void display(View view) {
        String s=et.getText().toString();
        if (s.isEmpty()){
            Toast.makeText(this,"Please enter username and password",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i=new Intent(this,WelcomePage.class);
            startActivity(i);

        }




    }

    public void rpage(View view) {
        Intent j=new Intent(this,RegistrationPage.class);
        startActivity(j);
    }
}