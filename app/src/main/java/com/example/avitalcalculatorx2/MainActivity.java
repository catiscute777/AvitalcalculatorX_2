package com.example.avitalcalculatorx2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText ed; EditText ed2; EditText ed3;int a; int b; int c; TextView tv; Button btn; Button btn1;String st;double ans1;double ans2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ed = findViewById(R.id.ed1);        tv = findViewById(R.id.text1);
        ed2 = findViewById(R.id.ed2);        btn = findViewById(R.id.btnR);
        ed3= findViewById(R.id.ed3);       btn1= findViewById(R.id.Cal);
    }

    public void Rnd(View view) {
        a = (int)(Math.random()*400)-200;
        b= (int)(Math.random()*400)-200;
        c = (int)(Math.random()*400)-200;
        ed.setText(""+a);
        ed2.setText(""+b);
        ed3.setText(""+c);
    }

    public void go(View view)
    {
        st= ed.getText().toString();
        a = Integer.parseInt(st);
        st= ed2.getText().toString();
        b = Integer.parseInt(st);
        st= ed3.getText().toString();
        c = Integer.parseInt(st);
        Intent si = new Intent(this, Check.class);
        si.putExtra("n",a);
        si.putExtra("nn",b);
        si.putExtra("nnn",c);
        startActivity(si);
    }
    public void help()
    {
        Intent gi1 = getIntent();
        if(gi1.getDoubleExtra("kk",1)==-777){
            ans1 = gi1. getDoubleExtra("k",1);
            tv.setText("x="+ans1);
        }if(gi1.getDoubleExtra("kk",1)!=-777)
        {
            ans1 = gi1. getDoubleExtra("k",1);
            ans2 = gi1. getDoubleExtra("kk",1);
            tv.setText("x="+ans1+"" +        "x=" +ans2);
        }if(gi1.getStringExtra("no").equals(" NO ANSWER "))
            tv.setText(" NO ANSWER ");
    }

}