package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    String []quote={
            "Never give up","Believe in yourself","Good artists copy but great artists steal","Life is too short if you give up easily.","Your limitation—it's only your imagination.","Push yourself, because no one else is going to do it for you.","The harder you work for something, the greater you'll feel when you achieve it.","Dream bigger."};
    static int i=0;



    public void func3(View view){

        TextView text3=(TextView)findViewById(R.id.text3);
        if(i==quote.length)
            i=0;


        text3.setText(quote[i]);


        i++;


    }
    public void back1(View view){

        Intent i4=new Intent(MainActivity3.this,HomeActivity.class);
        startActivity(i4);
        finish();

    }











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        TextView text4=(TextView)findViewById(R.id.text3);
        if(i==quote.length)
            i=0;

        text4.setText(quote[i]);
        i++;


    }
}
