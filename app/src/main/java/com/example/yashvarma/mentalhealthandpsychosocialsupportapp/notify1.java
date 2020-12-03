package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class notify1 extends AppCompatActivity {

    Button b1;
    String notificationid="1";

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void func(View view) {


        EditText editText=(EditText)findViewById(R.id.edit1);
        EditText editText1=(EditText)findViewById(R.id.edit2);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker2);
        Integer edit2=Integer.parseInt(editText1.getText().toString());


        SharedPreferences mPreferences=getSharedPreferences("db",MODE_PRIVATE);
        SharedPreferences.Editor editor=mPreferences.edit();
        editor.putInt("count",edit2);
        editor.apply();





        Intent i=new Intent(notify1.this,AlarmReceiver.class);
        i.putExtra("notificationid",notificationid);
        i.putExtra("todo",editText.getText().toString());

        PendingIntent alarmIntent=PendingIntent.getBroadcast(notify1.this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);

        int hour=timePicker.getHour();
        int minute=timePicker.getMinute();
        Calendar startTime=Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY,hour);
        startTime.set(Calendar.MINUTE,minute);
        startTime.set(Calendar.SECOND,0);
        long alarmStartTime= startTime.getTimeInMillis();
        alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);






    }


















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify1);
    }
}
