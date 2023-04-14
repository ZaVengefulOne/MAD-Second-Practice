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
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
//import com.example.mawfd.StartFrameFragment.notificationId;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.Navigation;

import com.example.mawfd.ui.MainActivity;

public class FirstService extends Service {

    private String CHANNEL_ID2 = "ServiceChannel1";
    public final int notificationId = 2;
    @Override
    public void onCreate() {
        super.onCreate();
        createChannel();
        startForeground(notificationId, buildNoti());
        final WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        final WindowManager.LayoutParams params = new
                WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.TOP | Gravity.CENTER;
        View view1 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.first_service, null);
        manager.addView(view1, params);
        manager.updateViewLayout(view1, params);
        view1.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                manager.removeView(view1);
                stopSelf();

            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void createChannel()
    {
        NotificationChannel channel1 = new NotificationChannel(
                CHANNEL_ID2, "ServiseChannel 1", NotificationManager.IMPORTANCE_HIGH
        );
        channel1.setDescription("This is ServiceChannel 1");
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.createNotificationChannel(channel1);
    }

    public Notification buildNoti()
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID2)
                .setSmallIcon(R.drawable.awfd_logo_foreground)
                .setContentTitle("Сервис")
                .setContentText("Сервис был запущен")
                .setChannelId(CHANNEL_ID2)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_LOW);
        Intent resultIntent = new Intent(getApplicationContext(), FirstService.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, resultIntent, PendingIntent.FLAG_IMMUTABLE);
        builder.setContentIntent(resultPendingIntent);
        Notification noti = builder.build();
        return noti;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
