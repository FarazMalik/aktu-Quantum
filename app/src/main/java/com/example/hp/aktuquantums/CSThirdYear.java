package com.example.hp.aktuquantums;


import android.content.Context;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class CSThirdYear extends AppCompatActivity {

    String sub[]=new String[] {"Web Technology","Cyber Security","Design and Analysis of Algorithm","Principle of Programming Language","Database Management System","Managerial Economics"};
    ListView lv;
    WebView webView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csthird_year);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if(!isConnected(CSThirdYear.this)) Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();




        webView=(WebView)findViewById(R.id.webviewWt);
        lv=(ListView)findViewById(R.id.lv);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sub);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {

                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.loadUrl("https://drive.google.com/open?id=1LmCRCLGwuIbeCMCl4FaXln3HFiy-7moV");



                }
                if(position==1) {

                }

                }
        });
        }

    public boolean isConnected(Context context){
        ConnectivityManager cm=(ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getActiveNetworkInfo();
        if(ni!=null &&ni.isConnectedOrConnecting()){
            android.net.NetworkInfo mobile=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if(mobile!=null&& mobile.isConnectedOrConnecting())
                return true;
            else return false;
        }
       else return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


}
