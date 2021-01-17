package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp1,sp2;
    Button convert;
    EditText edit;
    TextView editTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1=(Spinner)findViewById(R.id.sp1);
        sp2=(Spinner)findViewById(R.id.sp2);
        convert=findViewById(R.id.convert);
        edit=findViewById(R.id.edit);
        editTv=findViewById(R.id.editTv);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        getSupportActionBar().hide();

        String [] from = { "India " };
        ArrayAdapter ad=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String [] to={"India","usa","Nepal","china","Dubai","Russian Ruble "};
        ArrayAdapter ad1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);


       convert.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Double f;
               Double amount=Double.parseDouble(edit.getText().toString());
               if (sp2.getSelectedItem().toString()=="usa")
               {
                   f=amount/73.16;
                  // Toast.makeText(getApplicationContext(),f.toString(),Toast.LENGTH_LONG).show();
                   editTv.setText(f.toString());
                   Toast.makeText(getApplicationContext(),f.toString(),Toast.LENGTH_SHORT).show();

               }
               else if(sp2.getSelectedItem().toString()=="Dubai")
               {
                   f=amount/19.92;
                   Toast.makeText(getApplicationContext(),f.toString(),Toast.LENGTH_SHORT).show();
                   editTv.setText(f.toString()+"₹");
               }
               else if(sp2.getSelectedItem().toString()=="Russian Ruble ")
               {
                   f=amount*1.0;
                   Toast.makeText(getApplicationContext(),f.toString(),Toast.LENGTH_SHORT).show();
                   editTv.setText(f.toString()+"₹");
               }

               else if(sp2.getSelectedItem().toString()=="china")
               {
                   f=amount/11.29;
                   Toast.makeText(getApplicationContext(),f.toString(),Toast.LENGTH_SHORT).show();
                   editTv.setText(f.toString()+"₹");
               }

               else if(sp2.getSelectedItem().toString()=="Nepal")
               {
                   f=amount*1.62;
                   Toast.makeText(getApplicationContext(),f.toString(),Toast.LENGTH_SHORT).show();
                   editTv.setText(f.toString()+"₹");
               }


           }
       });

    }
}