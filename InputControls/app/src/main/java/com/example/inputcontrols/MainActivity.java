package com.example.inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_phone,et_email,et_password;
    TextView tv;
    RadioButton r_male,r_female;
    String gender;
    CheckBox c_java,c_python,c_js;
    Spinner sp_district,sp_mandal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.name);
        et_phone=findViewById(R.id.mobile);
        et_email=findViewById(R.id.email);
        et_password=findViewById(R.id.pass);
        tv=findViewById(R.id.result);
        r_male=findViewById(R.id.male);
        r_female=findViewById(R.id.female);
        c_java=findViewById(R.id.java);
        c_python=findViewById(R.id.python);
        c_js=findViewById(R.id.js);
        sp_district=findViewById(R.id.district);
        sp_mandal=findViewById(R.id.mandal);

        ArrayAdapter<CharSequence> districtAdapter=ArrayAdapter.createFromResource(this,R.array.districts,android.R.layout.simple_spinner_item);
        sp_district.setAdapter(districtAdapter);

        sp_district.setOnItemClickListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Toast.makeText(MainActivity.this,"Please select district",Toast.LENGTH_SHORT).show();
                    case 1:
                        ArrayAdapter<CharSequence> atp_mandals=
                                ArrayAdapter.createFromResource(MainActivity.this,R.array.Anantapur_mandal,android.R.layout.simple_spinner_item);
                        sp_mandal.setAdapter(atp_mandals);
                        break;

                    case 2:
                        ArrayAdapter<CharSequence> knl_mandals=
                                ArrayAdapter.createFromResource(MainActivity.this,R.array.Kurnool_mandal,android.R.layout.simple_spinner_item);
                        sp_mandal.setAdapter(knl_mandals);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }



    }

    public void display(View view) {
        String name=et_name.getText().toString();
        String num=et_phone.getText().toString();
        String mail=et_email.getText().toString();
        String pass=et_password.getText().toString();
        if(r_male.isChecked()){
            gender = r_male.getText().toString();
        }
        if(r_female.isChecked()){
            gender=r_female.getText().toString();
        }
        StringBuilder builder=new StringBuilder();
        if(c_java.isChecked()){
            builder.append(c_java.getText().toString()+",");
        }
        if(c_python.isChecked()){
            builder.append(c_python.getText().toString()+",");
        }
        if(c_js.isChecked()){
            builder.append((c_js.getText().toString()));
        }
        String selectedDistrict=sp_district.getSelectedItem().toString();
        String selectedMandal=sp_mandal.getSelectedItem().toString();
        tv.setText(name+ "\n" +num+ "\n" +mail+ "\n" +gender+ "\n" +builder+"\n"+selectedDistrict+"\n"+selectedMandal);

    }
}