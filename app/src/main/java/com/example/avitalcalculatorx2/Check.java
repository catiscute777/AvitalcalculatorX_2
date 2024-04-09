package com.example.avitalcalculatorx2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Check extends AppCompatActivity {
    Button btn3; TextView tv1;TextView tv2;int a; int b; int c;String st;double eq;double x1;double x2;TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn3 = findViewById(R.id.back);tv1 = findViewById(R.id.eqaisen);tv2 = findViewById(R.id.ans);tv3 = findViewById(R.id.text4);
        Intent gi  = getIntent();
        a = gi.getIntExtra("n",1);
        b= gi.getIntExtra("nn",1);
        c = gi.getIntExtra("nnn",1);
        if(b>0)
            st = ""+a+"x²+"+b+"x "+c;
        if(c>0)
         st = ""+a+"x² "+b+"x+"+c;
        if((c>0)&&(b>0))
            st = ""+a+"x²+"+b+"x+"+c;
        tv1.setText(st);
        eq=Math.pow(b,2)-4*c*a;
        if(eq>0)
        {
            eq= Math.sqrt(eq);
                x1 = (-b+eq)/(2*a);
                x2 = (-b-eq)/(2*a);
        if(x1==x2)
            tv2.setText("x =  "+x1);
        else{
            tv2.setText("x =  "+x1);
            tv3.setText("x =  "+x2);}

    }  else{tv2.setText(" NO ANSWER ");}

    }

    public void back(View view)
    {
        Intent si1 = new Intent(this, MainActivity.class);
        if(tv2.getText().equals(" NO ANSWER ")==false){
        if(x1==x2){
          si1.putExtra("k",x1);
            si1.putExtra("k",-777);}
        else{
            si1.putExtra("k",x1);
            si1.putExtra("kk",x2);
        }}else
            si1.putExtra("no"," NO ANSWER ");
        startActivity(si1);
    }
}