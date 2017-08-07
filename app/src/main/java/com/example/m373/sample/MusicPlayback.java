package com.example.m373.sample;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

/**
 * Created by m373 on 8/5/2017.
 * This app was created to test the abilities of Android Studio IDE
 * integration with Bitbucket
 */

public class MusicPlayback extends Service implements View.OnClickListener{
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ActivityManager am = (ActivityManager) this.getSystemService(
                Context.ACTIVITY_SERVICE);


        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;

        for(int i = 0; i < 10; i++) {
            Toast.makeText(this, cn.getClassName(), Toast.LENGTH_LONG).show();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        player.setLooping(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {

    }
}
