package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {



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

        startActivity(i2);
        finish();
    }

    public void goToVideos(View view) {
        Intent i=new Intent(HomeActivity.this,Videos.class);
        startActivity(i);
        finish();
    }


    public void func5(View view)
    {
        Intent i3=new Intent(HomeActivity.this,notify1.class);
        startActivity(i3);
        finish();
    }

    public void goToChat(View view) {
        String link = "https://web-chat.global.assistant.watson.cloud.ibm.com/preview.html?region=au-syd&integrationID=eaaa63b3-121b-415c-96b2-bc4c8cad014d&serviceInstanceID=f6c9999e-fb22-45bf-b0ca-458489534a4c";
        Uri uriChat = Uri.parse(link);
        Intent goToBrowser = new Intent(Intent.ACTION_VIEW, uriChat);
        if(goToBrowser.resolveActivity(getPackageManager())!=null) {
            startActivity(goToBrowser);
        }
    }

}
