package com.leonziyo.notifications;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSOperationQueue;
import org.robovm.apple.foundation.NSTimeZone;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UILocalNotification;
import org.robovm.apple.uikit.UIUserNotificationSettings;
import org.robovm.apple.uikit.UIUserNotificationType;

/**
 * Created by leonziyo on 4/29/15.
 */
public class AdapterIOS implements NotificationHandler {

    public AdapterIOS () {
        //Registers notifications, it will ask user if ok to receive notifications from this app, if user selects no then no notifications will be received
        UIApplication.getSharedApplication().registerUserNotificationSettings(UIUserNotificationSettings.create(UIUserNotificationType.Alert, null));
        UIApplication.getSharedApplication().registerUserNotificationSettings(UIUserNotificationSettings.create(UIUserNotificationType.Sound, null));
        UIApplication.getSharedApplication().registerUserNotificationSettings(UIUserNotificationSettings.create(UIUserNotificationType.Badge, null));

        //Removes notifications indicator in app icon, you can do this in a different way
        UIApplication.getSharedApplication().setApplicationIconBadgeNumber(0);
        UIApplication.getSharedApplication().cancelAllLocalNotifications();
    }


    @Override
    public void showNotification(final String title, final String text) {
        NSOperationQueue.getMainQueue().addOperation(new Runnable() {
            @Override
            public void run() {
                NSDate date = new NSDate();
                //5 seconds from now
                NSDate secondsMore = date.newDateByAddingTimeInterval(5);

                UILocalNotification localNotification = new UILocalNotification();
                localNotification.setFireDate(secondsMore);
                localNotification.setAlertBody(title);
                localNotification.setAlertAction(text);
                localNotification.setTimeZone(NSTimeZone.getDefaultTimeZone());
                localNotification.setApplicationIconBadgeNumber(UIApplication.getSharedApplication().getApplicationIconBadgeNumber() + 1);

                UIApplication.getSharedApplication().scheduleLocalNotification(localNotification);
            }
        });
    }
}
