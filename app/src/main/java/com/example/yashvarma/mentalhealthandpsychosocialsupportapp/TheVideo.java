package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class TheVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_video);

        String[] youtubeURLs =
                {"Sorry Something went wrong",  // in case of an error
                        "https://www.youtube.com/watch?v=NccQoPJjdt0",
                        "https://www.youtube.com/watch?v=3SDkzDlw1yc",
                        "https://www.youtube.com/watch?v=3tX6pBqP_KY",
                        "https://www.youtube.com/watch?v=k9zTr2MAFRg",
                        "https://www.youtube.com/watch?v=kBsUwIfL8kU",
                        "https://www.youtube.com/watch?v=m050iy5_2ng"
                };

        int id = getIntent().getIntExtra("id", 0);
        TextView url = (TextView) findViewById(R.id.url);
        url.setText(youtubeURLs[id]);

    }
}
