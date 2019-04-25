package com.example.preciousheart2;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;

public class BroadCastHelper extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
        Notification notification = new Notification.Builder(context).
                setContentTitle(Utilities.contentTitle).
                setContentText(Utilities.contentText).
                setSmallIcon(R.mipmap.ic_launcher).build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notification.flags|= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0,notification);

        Uri ringToneManager = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        Ringtone ringtone = RingtoneManager.getRingtone(context,ringToneManager);
        ringtone.play();
    }
}
