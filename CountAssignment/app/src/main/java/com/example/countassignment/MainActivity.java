package com.example.countassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int a=0;
    Button b1;
    Button b2;
    Button b3;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.add);
        tv=findViewById(R.id.textView);
        b2=findViewById(R.id.reset);
        b3=findViewById(R.id.subtract);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                tv.setText(""+a);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(""+0);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a--;
                tv.setText(""+a);

            }
        });
        if (savedInstanceState!=null){
            String s=savedInstanceState.getString("key");
            tv.setText(s);
        }


    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key",tv.getText().toString());
    }



    public void display(View view) {
        Toast.makeText(this,"Your Count is:"+a,Toast.LENGTH_SHORT).show();
    }
}





