package com.kevinhodges.dragonborn.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.utils.MusicService;

public class TitleActivity extends AppCompatActivity {

    private TextView beginTextView;
    private TextView continueTextView;
//    private BackgroundMusic mBackgroundMusic;
    private boolean mBackgroundMusicBoolean;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        mBackgroundMusic = new BackgroundMusic();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = sharedPreferences.edit();

        //UI Declarations///////////////////////////////////////////////////////////
        beginTextView = (TextView) findViewById(R.id.tv_begin);
        continueTextView = (TextView) findViewById(R.id.tv_continue);
        ///////////////////////////////////////////////////////////////////////////

        beginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beginIntent = new Intent(TitleActivity.this, RaceSelectActivity.class);
                startActivity(beginIntent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        Intent svc = new Intent(this, MusicService.class);
        startService(svc);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent svc = new Intent(this, MusicService.class);
        stopService(svc);
    }
}
