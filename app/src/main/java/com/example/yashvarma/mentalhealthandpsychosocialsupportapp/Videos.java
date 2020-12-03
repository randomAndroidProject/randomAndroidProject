package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Videos extends AppCompatActivity {

    String[] motivationalPeopleNames;
    ListView listOfVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        Resources res = getResources();
        listOfVideos = (ListView) findViewById(R.id.listOfVideos);
        motivationalPeopleNames = res.getStringArray(R.array.motivational_people_names);

        int[] imagesOfGreat = {
                R.drawable.edison,
                R.drawable.abdul_kalam,
                R.drawable.einstein,
                R.drawable.elon_musk,
                R.drawable.gandhi,
                R.drawable.sundhar_pichai,
                R.drawable.stephen_hawking
        };

        VideoListAdapter videoListAdapter = new VideoListAdapter(this,imagesOfGreat,motivationalPeopleNames);
        listOfVideos.setAdapter(videoListAdapter);

        listOfVideos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String firstPartBrowser = "https://www.youtube.com/watch?v=";
                String firstPartYoutube = "vnd.youtube:";
                String[] secondPart =
                        {       "NccQoPJjdt0",
                                "3SDkzDlw1yc",
                                "3tX6pBqP_KY",
                                "k9zTr2MAFRg",
                                "kBsUwIfL8kU",
                                "m050iy5_2ng",
                                "iW1e38X6nb4"
                        };

                Uri uriYoutube = Uri.parse(firstPartYoutube + secondPart[i]);
                Intent goToYoutube = new Intent(Intent.ACTION_VIEW, uriYoutube);
                if(goToYoutube.resolveActivity(getPackageManager())!=null) {
                    startActivity(goToYoutube);
                } else {
                    Uri uriBrowser = Uri.parse(firstPartBrowser + secondPart[i]);
                    Intent goToBrowser = new Intent(Intent.ACTION_VIEW, uriBrowser);
                    if(goToBrowser.resolveActivity(getPackageManager())!=null) {
                        startActivity(goToBrowser);
                    }
                }
            }
        });

    }

    @Override
    public void onBackPressed(){

        Intent i5=new Intent(Videos.this,HomeActivity.class);
        startActivity(i5);
        finish();


    }



}

