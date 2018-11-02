package com.example.hp.aktuquantums;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b2,b3,b4,b5,b6,b1;
    private DrawerLayout dl;
    ActionBarDrawerToggle t;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        dl=(DrawerLayout)findViewById(R.id.drawer);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        t=new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();
        NavigationView nv=(NavigationView)findViewById(R.id.nav1);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();

                if(id==R.id.aboutus)
                {
                    Intent in=new Intent(MainActivity.this,about.class);
                    startActivity(in);
                }
                if(id==R.id.feedback)
                {

                    try{
                        Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "rajanigam95@gmail.com,mohdfarazsharif@gmail.com"));
                        intent.putExtra(Intent.EXTRA_SUBJECT, "");
                        intent.putExtra(Intent.EXTRA_TEXT, "");
                        startActivity(intent);
                    }catch(ActivityNotFoundException e){

                    }
                }
                if(id==R.id.shareapp)
                {
                    final Intent _Intent = new Intent(android.content.Intent.ACTION_SEND);
                    _Intent.setType("text/html");
                    String sub="Engineering Quantums";
                    String body="Download our App";
                    String share ="Share Via";
                    String to="rajanigam95@gmail.com";
                    _Intent.putExtra(android.content.Intent.EXTRA_EMAIL,to);
                    _Intent.putExtra(android.content.Intent.EXTRA_SUBJECT,sub);
                    _Intent.putExtra(android.content.Intent.EXTRA_TEXT, body);
                    startActivity(Intent.createChooser(_Intent,share));
                }
                dl.closeDrawer(GravityCompat.START);
                return true;

            }
        });


    }


    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return t.onOptionsItemSelected(item)||super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v){
        Button bt=(Button)v;
        if(bt==b1)
        {
            Intent in=new Intent(MainActivity.this,ChooseYear.class);
            startActivity(in);
        }
        if(bt==b2)
        {
            Intent in=new Intent(MainActivity.this,ECChooseYear.class);
            startActivity(in);
        }
        if(bt==b3)
        {
            Intent in=new Intent(MainActivity.this,ITChooseYear.class);
            startActivity(in);
        }
        if(bt==b4)
        {
            Intent in=new Intent(MainActivity.this,MEChooseYear.class);
            startActivity(in);
        }
        if(bt==b5)
        {
            Intent in=new Intent(MainActivity.this,CEChooseYear.class);
            startActivity(in);
        }
        if(bt==b6)
        {
            Intent in=new Intent(MainActivity.this,EEChooseYear.class);
            startActivity(in);
        }

    }



    public void onBackPressed(){
       final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("QUIT");
        builder.setMessage("Do You Want to Quit Application?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Toast.makeText(MainActivity.this, "Closed", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alert=builder.create();
        alert.show();


    }
}
