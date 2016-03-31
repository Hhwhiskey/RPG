package com.kevinhodges.dragonborn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kevinhodges.dragonborn.activities.RaceSelectActivity;
import com.kevinhodges.dragonborn.utils.MusicService;

public class TitleActivity extends AppCompatActivity {

    private TextView beginTextView;
    private TextView continueTextView;
//    private BackgroundMusic mBackgroundMusic;
    private boolean mBackgroundMusicBoolean;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Intent svc;
    private boolean isMusicPlaying;
    private boolean isActivityIntent;
    private Button prefsButton;
    private static final String TAG = "Music";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = sharedPreferences.edit();

//        editor.putBoolean("isMusicPlaying", false);
//        editor.commit();

        isMusicPlaying = sharedPreferences.getBoolean("isMusicPlaying", false);

        //UI Declarations///////////////////////////////////////////////////////////
        beginTextView = (TextView) findViewById(R.id.tv_begin);
        continueTextView = (TextView) findViewById(R.id.tv_continue);
        prefsButton = (Button) findViewById(R.id.button_prefs);
        ///////////////////////////////////////////////////////////////////////////

        beginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beginIntent = new Intent(TitleActivity.this, RaceSelectActivity.class);
                startActivity(beginIntent);
                isActivityIntent = true;
            }
        });

        prefsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("isMusicPlaying", false);
                editor.commit();
                Toast.makeText(TitleActivity.this, "Music is not playing.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "isMusicPlaying = " + isMusicPlaying);

        isActivityIntent = false;

        if (!isMusicPlaying) {
            svc = new Intent(this, MusicService.class);
            startService(svc);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (!isActivityIntent) {
            svc = new Intent(this, MusicService.class);
            stopService(svc);
            editor.putBoolean("isMusicPlaying", false);
            editor.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        svc = new Intent(this, MusicService.class);
        stopService(svc);
        editor.putBoolean("isMusicPlaying", false);
        editor.commit();
    }


}
