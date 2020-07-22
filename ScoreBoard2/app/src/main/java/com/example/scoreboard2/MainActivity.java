package com.example.scoreboard2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    int a=0;
    int b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.score1);
        tv2=findViewById(R.id.score2);
    }

    public void display(View view) {
        tv1.setText("0");
        tv2.setText("0");
        Toast.makeText(this,"Your game has been reset",Toast.LENGTH_SHORT).show();

    }

    public void Add1(View view) {
        a++;
        tv1.setText(a);

    }

    public void Add2(View view) {
        a=a+2;
        tv1.setText(a);
    }

    public void Add3(View view) {
        a=a+3;
        tv1.setText(a);
    }

    public void Plus1(View view) {
        b++;
        tv2.setText(b);

    }

    public void Plus2(View view) {
        b=b+2;
        tv2.setText(b);

    }

    public void Plus3(View view) {
        b=b+3;
        tv2.setText(b);
    }
}
