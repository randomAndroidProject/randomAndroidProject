package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {


     static int j=0;
    String [] s2={"Never give up","Believe in yourself","Good artists copy but great artists steal","Life is too short if you give up easily."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

    public void func2(View view)
    {

        Intent i2=new Intent(HomeActivity.this,MainActivity3.class);


        if(j==s2.length)
            j=0;



        i2.putExtra("passed_value_to_next",j);
        ++j;


        startActivity(i2);
        finish();



    }

}
