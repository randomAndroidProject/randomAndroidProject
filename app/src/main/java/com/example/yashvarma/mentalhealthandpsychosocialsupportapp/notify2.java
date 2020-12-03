package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class notify2 extends AppCompatActivity {

    LinearLayout linearLayout;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify2);
        int i=0;
        SharedPreferences load1=getSharedPreferences("db",MODE_PRIVATE);
        int j=load1.getInt("count",0);


        linearLayout=(LinearLayout)findViewById(R.id.linear2);

        for(i=0;i<j;i++)
        {
            checkBox=new CheckBox(this);
            checkBox.setId(i);
            checkBox.setText("Day "+(i+1));
            linearLayout.addView(checkBox);



        }





    }

    @Override
    public void onBackPressed(){

        Intent i4=new Intent(notify2.this,HomeActivity.class);
        startActivity(i4);
        finish();


    }


















}
