package com.leonziyo.notifications.android;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;

import com.leonziyo.notifications.NotificationHandler;

/**
 * Created by leonziyo on 4/29/15.
 */
public class AdapterAndroid implements NotificationHandler {

    private Activity gameActivity;

    public AdapterAndroid(Activity gameActivity) {
        this.gameActivity = gameActivity;
    }

    @Override
    public void showNotification(String title, String text) {

        Notification.Builder mBuilder = new Notification.Builder(gameActivity)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(title)
                .setContentText(text);


        int notificationId = 1;
        // Gets an instance of the NotificationManager service
        NotificationManager notificationManager = (NotificationManager) gameActivity.getSystemService(gameActivity.NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        notificationManager.notify(notificationId, mBuilder.build());
    }
}
