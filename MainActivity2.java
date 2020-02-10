package com.example.attendance;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    String s,t,u;
    Integer r,c;
    GridView gridView,gridView2;
    String d[]={"","Mon","Tue","Wed","Thu","Fri","Sat","Sun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        s=getIntent().getStringExtra("name");
        t=getIntent().getStringExtra("rows");
        u=getIntent().getStringExtra("columns");
        r=Integer.valueOf(t);
        c=Integer.valueOf(u);
        textView=findViewById(R.id.tv1);
        textView.setText(s);
        gridView=findViewById(R.id.gridView);
        gridView.setNumColumns(c+1);
        gridView2=findViewById(R.id.gridView2);
        gridView2.setNumColumns(c+1);
        String[] days=new String[c+1];
        Integer z=r*(c+1);
        final String[] elements=new String[z];
        for (int i=0;i<z;i++)
            elements[i]="";
        for (int i=0;i<=c;i++)
            days[i]=d[i];
        gridView.setAdapter(new ArrayAdapter<String>(this,R.layout.grid_view_custom_layout,R.id.list_item,days));
        gridView2.setAdapter(new ArrayAdapter<String>(this,R.layout.grid_view_custom_layout,R.id.list_item,elements));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                Toast.makeText(MainActivity2.this,adapterView.getItemAtPosition(i)+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
