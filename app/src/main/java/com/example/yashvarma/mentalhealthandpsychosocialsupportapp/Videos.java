package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Videos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
    }

    public static String getId(View view) {
        int i = view.getId(); // returns an integer id like 7438947
        if (view.getId() == View.NO_ID) return "no-id";
        return view.getResources().getResourceName(view.getId());
    }

    public void openVideo(View view) {
        String idString = getId(view);
        int id = Integer.parseInt(idString.substring(64)); // ** dependent on company name and app name
        String firstPartBrowser = "https://www.youtube.com/watch?v=";
        String firstPartYoutube = "vnd.youtube:";
        String[] secondPart =
                {"Sorry Something went wrong",  // in case of an error
                        "NccQoPJjdt0",
                        "3SDkzDlw1yc",
                        "3tX6pBqP_KY",
                        "k9zTr2MAFRg",
                        "kBsUwIfL8kU",
                        "m050iy5_2ng"
                };

        Uri uriYoutube = Uri.parse(firstPartYoutube + secondPart[id]);
        Intent goToYoutube = new Intent(Intent.ACTION_VIEW, uriYoutube);
        if(goToYoutube.resolveActivity(getPackageManager())!=null) {
            startActivity(goToYoutube);
        } else {
            Uri uriBrowser = Uri.parse(firstPartBrowser + secondPart[id]);
            Intent goToBrowser = new Intent(Intent.ACTION_VIEW, uriBrowser);
            if(goToBrowser.resolveActivity(getPackageManager())!=null) {
                startActivity(goToBrowser);
            }
        }
    }

}

