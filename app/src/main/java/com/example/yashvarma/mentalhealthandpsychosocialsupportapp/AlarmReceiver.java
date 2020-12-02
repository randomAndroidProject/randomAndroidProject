package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;

/**
 * Created by YASH VARMA on 01-12-2020.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int notificationid = intent.getIntExtra("notificationid", 0);
        String message = intent.getStringExtra("todo");



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {



            CharSequence name = "Personal notification";
            String description = "Include all personal notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("1", name, importance);
            notificationChannel.setDescription(description);



            Intent i = new Intent(context, notify2.class);


            PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, i, PendingIntent.FLAG_UPDATE_CURRENT);


            Notification notification = new Notification.Builder(context)
                    .setContentText(message)
                    .setContentTitle("Goal")
                    .setSmallIcon(R.drawable.ic_message)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)


                    .setChannelId("1")


                    .build();





            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.notify(0, notification);


        }

    }
}

