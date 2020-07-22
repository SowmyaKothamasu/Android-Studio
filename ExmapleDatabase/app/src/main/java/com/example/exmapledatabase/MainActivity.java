package com.example.exmapledatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name,roll;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        roll=findViewById(R.id.num);
        reference= FirebaseDatabase.getInstance().getReference("UserDetails");
    }

    public void display(View view) {
        String uname=name.getText().toString();
        String uroll=roll.getText().toString();
        if(uroll.isEmpty()|uname.isEmpty()){
            Toast.makeText(this,"Enter all the details",Toast.LENGTH_SHORT).show();
        }else{
            Pojo pojo=new Pojo(uname,uroll);
            reference.child(uroll).setValue(pojo);
            Toast.makeText(this,"Submitted successfully",Toast.LENGTH_SHORT).show();

        }
    }
}