package com.example.hp.aktuquantums;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ChooseYear extends AppCompatActivity implements View.OnClickListener {
    Button b1st,b2nd,b3rd,b4th;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_year);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        b1st=(Button)findViewById(R.id.b1st);
        b2nd=(Button)findViewById(R.id.b2nd);
        b3rd=(Button)findViewById(R.id.b3rd);
        b4th=(Button)findViewById(R.id.b4th);
        b1st.setOnClickListener(this);
        b2nd.setOnClickListener(this);
        b3rd.setOnClickListener(this);
        b4th.setOnClickListener(this);
        ImageView image=(ImageView)findViewById(R.id.iv);
        Animation ani= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
        image.startAnimation(ani);




    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


    @Override
    public void onClick(View v) {
        Button bt=(Button)v;
        if(bt==b1st)
        {
            Intent in=new Intent(ChooseYear.this,CSFirstYear.class);
            startActivity(in);
        }
        if(bt==b2nd)
        {
            Intent in=new Intent(ChooseYear.this,CSSecondYear.class);
            startActivity(in);
        }
        if(bt==b3rd)
        {
            Intent in=new Intent(ChooseYear.this,CSThirdYear.class);
            startActivity(in);
        }
        if(bt==b4th)
        {
            Intent in=new Intent(ChooseYear.this,CSFourthYear.class);
            startActivity(in);
        }
    }
}
