package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view) {
        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //we have to create notification channel
            NotificationChannel nc=new NotificationChannel("srminterns","SRM NOTIFICATIONS",NotificationManager.IMPORTANCE_HIGH);
            nm.createNotificationChannel(nc);
        }
        //we have to create notification code
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"srminterns");
        builder.setSmallIcon(R.drawable.umbrella);
        builder.setContentTitle("Sample Notification");
        builder.setContentText("This is the description of the notifications");
        builder.setAutoCancel(true);

        /*Pending Intent
        *-It is the description of the operation to be perform*/;

        PendingIntent pi=PendingIntent.getActivity(this,12,new Intent(this,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.srm);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));

        nm.notify(42,builder.build());



    }
}

