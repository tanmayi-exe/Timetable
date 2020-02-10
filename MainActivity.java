package com.example.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText name1;
    Button create;
    Spinner s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1=findViewById(R.id.newName);
        create=findViewById(R.id.CreateTable);
        s1=findViewById(R.id.select1);
        s2=findViewById(R.id.select2);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("name",name1.getText().toString());
                i.putExtra("rows",s1.getSelectedItem().toString());
                i.putExtra("columns",s2.getSelectedItem().toString());
                startActivity(i);
                finish();
            }
        });
    }

}
