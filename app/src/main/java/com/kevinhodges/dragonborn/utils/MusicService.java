package com.kevinhodges.dragonborn.utils;


import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

import com.kevinhodges.dragonborn.R;

/**
 * Created by Kevin on 3/24/2016.
 */
public class MusicService extends Service {
    MediaPlayer player;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String TAG = "isMusicPlaying";

    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = sharedPreferences.edit();

        player = MediaPlayer.create(this, R.raw.main_theme);
        player.setLooping(true);
        player.setVolume(100,100);

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        editor.putBoolean("isMusicPlaying", true);
        editor.commit();

        Log.d(TAG, "Music has started");

        return 1;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}