package com.example.avitalcalculatorx2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 2007;

            EditText ed; EditText ed2; EditText ed3;int a;TextView tv4;

    int b; int c; TextView tv; Button btn; Button btn1;String st;double ans1;double ans2;
    ImageView[] m1= new ImageView[6];



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
        ed3= findViewById(R.id.ed3);       btn1= findViewById(R.id.Cal); tv4 = findViewById(R.id.tx);
        m1[0]= findViewById(R.id.ht);m1[1]= findViewById(R.id.ho);m1[2]= findViewById(R.id.hf);
        m1[3]= findViewById(R.id.st);m1[4]= findViewById(R.id.so);m1[5]= findViewById(R.id.sf);
        for(int i =0;i<6;i++){
        m1[i].setVisibility(View.GONE);}

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
        startActivityForResult(si, REQUEST_CODE);
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                        if((data.getBooleanExtra("o",true)==false)&&(data.getBooleanExtra("t",false)==true))
                        {
                            for(int i =0;i<6;i++)
                                m1[i].setVisibility(View.GONE);
                            tv.setText("X=  "+data.getDoubleExtra("k",1));
                            tv4.setText("X=  "+data.getDoubleExtra("kk",1));
                            if(a<0){
                                for(int i =0;i<6;i++)
                                    m1[i].setVisibility(View.GONE);
                                m1[3].setVisibility(View.VISIBLE);}
                            if(a>0)
                                m1[0].setVisibility(View.VISIBLE);
                        }
                        if((data.getBooleanExtra("o",false)==true)&&(data.getBooleanExtra("t",true)==false))
                    {
                        for(int i =0;i<6;i++)
                            m1[i].setVisibility(View.GONE);
                        tv.setText("X=  "+data.getDoubleExtra("k",1));
                        tv4.setText("");
                        if(a<0)
                            m1[4].setVisibility(View.VISIBLE);
                        if(a>0)
                            m1[1].setVisibility(View.VISIBLE);
                    }
                        if(data.getStringExtra("no").equals(" NO ANSWER "))
                    {
                        for(int i =0;i<6;i++)
                            m1[i].setVisibility(View.GONE);
                        tv.setText(" NO ANSWER ");
                        tv4.setText("");
                        if(a<0)
                            m1[5].setVisibility(View.VISIBLE);
                        if(a>0)
                            m1[2].setVisibility(View.VISIBLE);
                    }

                }}
        }
    }