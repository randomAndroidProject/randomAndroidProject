package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by srinivas on 2/12/20.
 */

public class VideoListAdapter extends BaseAdapter {

    LayoutInflater myInflator;
    String[] motivationalPeopleNames;
    int[] imagesOfGreat;

    public VideoListAdapter(Context c,int[] imagesOfGreat, String[] motivationalPeopleNames) {
        this.motivationalPeopleNames = motivationalPeopleNames;
        this.imagesOfGreat = imagesOfGreat;
        myInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return motivationalPeopleNames.length;
    }

    @Override
    public Object getItem(int i) {
        return motivationalPeopleNames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = myInflator.inflate(R.layout.activity_video_details,null);

        ImageView imageOfGreat = (ImageView) v.findViewById(R.id.imageOfGreat);
        TextView theName = (TextView) v.findViewById(R.id.theName);

        imageOfGreat.setImageResource(imagesOfGreat[i]);
        theName.setText(motivationalPeopleNames[i]);

        return v;
    }
}
