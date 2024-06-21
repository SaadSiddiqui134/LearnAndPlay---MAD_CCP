package com.example.mad_ccp;

import android.app.MediaRouteActionProvider;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

import java.security.Provider;

public class MusicService extends Service {
    MediaPlayer mp;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
//        mp.setLooping(true);
        mp.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        mp.stop();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
