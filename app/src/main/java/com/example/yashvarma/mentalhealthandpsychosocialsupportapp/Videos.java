package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.content.Intent;
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
        Intent intent = new Intent(Videos.this, TheVideo.class);
        String idString = getId(view);
        int id = Integer.parseInt(idString.substring(64)); // ** dependent on company name and app name
        intent.putExtra("id", id);
        startActivity(intent);
        finish();
    }

}

