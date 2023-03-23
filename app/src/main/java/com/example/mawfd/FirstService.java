package com.example.mawfd;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
//import com.example.mawfd.StartFrameFragment.notificationId;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class FirstService extends Service {

    private String CHANNEL_ID2 = "ServiceChannel1";
    public final int notificationId = 2;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        NotificationChannel channel1 = new NotificationChannel(
                CHANNEL_ID2, "ServiseChannel 1", NotificationManager.IMPORTANCE_HIGH
        );
        channel1.setDescription("This is ServiceChannel 1");
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.createNotificationChannel(channel1);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID2)
                .setSmallIcon(R.drawable.awfd_logo_foreground)
                .setContentTitle("Сервис")
                .setContentText("Сервис был запущен")
                .setChannelId(CHANNEL_ID2)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_LOW);
        Intent resultIntent = new Intent(getApplicationContext(), FirstService.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, resultIntent, 0);
        builder.setContentIntent(resultPendingIntent);
        Notification noti = builder.build();
        startForeground(notificationId, noti);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
