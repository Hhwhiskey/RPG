package com.kevinhodges.dragonborn.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.kevinhodges.dragonborn.MainActivity;
import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.utils.MusicService;

public class RaceSelectActivity extends AppCompatActivity {

    private TextView umanTextView;
    private TextView faerieTextView;
    private TextView lokenTextView;
    private TextView risenTextView;
    private String raceSelection;
    //    private boolean mBackgroundMusicBoolean;
//    private BackgroundMusic mBackgroundMusic;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Intent svc;
    private boolean isMusicPlaying;
    private boolean isActivityIntent;
    private static final String TAG = "Music";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_select);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        mBackgroundMusic = new BackgroundMusic();

//        mBackgroundMusicBoolean = false;


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = sharedPreferences.edit();

        isMusicPlaying = sharedPreferences.getBoolean("isMusicPlaying", false);

        String intro = "You are awoken by a nightmare of your home under attack. A strange, but familiar voice spoke to you. It warned that without you, all your people will parrish. To which of these people do you have allegiance to?";
        final String uman = "Urth, the land of the Uman. Brave and courageous, these people make up the majority of Evon. The Uman have waged millennia of war against the Loken in defense of it's people. Though the Uman front is weakening from many years of war against the Loken and Risen, they have developed the strongest resilience in all of Evon - Uman have the ability to heal slowly, over time.";
        final String faerie = "Talion, home of the magical and secretive Faerie. Nearly wiped out by the Loken many years ago if not for the Uman assistance, Talion is only just now becoming what it once was. Although small in stature and only representing a very small portion of Evon's people, they are the most feared in Evon because of their mastery of black magic. Faerie have been known to cast spells from extreme distances and destroy their opponent before they even have a chance.";
        final String loken = "Duunbar is the home of the Loken - massive brutes that thrive in combat and are driven by the destruction of Evon's people. Duunbar's proximity to Urth has allowed nearly 3 millenia of war between these two factions. The Loken have survived through their pillaging of Uman towns and homes. While not the most intelligent beings, their superior weapon training and size allows them to wield massive weapons and wear stronger armor.";
        final String risen = "Beneath Urth lie the Urthen Crypts, here rest the corpses of all ancient Urthen warriors. Crossed many years ago by the Uman King 'Uther', these warriors lie in wait for the day they may avenge their death. In an attempt at destroying Urth, Loken Shaman have raised them from the dead and forced them to wage war against the Urth and Talion. Although the Risen are fairly weak, the dead do not tire, and therefor do not have the burden of stamina.";
        String begin = "Your adventure begins...";

        //UI Declarations///////////////////////////////////////////////////////////
        umanTextView = (TextView) findViewById(R.id.tv_uman);
        faerieTextView = (TextView) findViewById(R.id.tv_faerie);
        lokenTextView = (TextView) findViewById(R.id.tv_loken);
        risenTextView = (TextView) findViewById(R.id.tv_risen);
        ///////////////////////////////////////////////////////////////////////////

        showDreamDiaglog(intro);

        umanTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRaceInfoDialog(uman, "Uman");

            }
        });

        faerieTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRaceInfoDialog(faerie, "Faerie");

            }
        });

        lokenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRaceInfoDialog(loken, "Loken");

            }
        });

        risenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRaceInfoDialog(risen, "Risen");

            }
        });


    }

    public void showDreamDiaglog(String intro) {

        AlertDialog.Builder builder = new AlertDialog.Builder(RaceSelectActivity.this, R.style.MyAlertDialogStyle);
        builder.setMessage(intro);
        builder.show();
    }

    public void showRaceInfoDialog(final String raceDescription, final String race) {

        AlertDialog.Builder builder = new AlertDialog.Builder(RaceSelectActivity.this, R.style.MyAlertDialogStyle);
//        builder.setTitle("Is this your home?");
        builder.setMessage(raceDescription);

        builder.setNegativeButton("This is not my home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setPositiveButton("This is my home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (race) {
                    case "Uman":
                        Toast.makeText(RaceSelectActivity.this, "You dreamt of your home, Urth, under attack from the Loken and Risen armies.", Toast.LENGTH_LONG).show();

                        break;

                    case "Faerie":
                        Toast.makeText(RaceSelectActivity.this, "You dreamt of your home, Talion, under attack from the Loken and Risen armies.", Toast.LENGTH_LONG).show();

                        break;

                    case "Loken":
                        Toast.makeText(RaceSelectActivity.this, "You dreamt of your home, Duunbar, under attack from the Uman and Faerie armies.", Toast.LENGTH_LONG).show();

                        break;

                    case "Risen":
                        Toast.makeText(RaceSelectActivity.this, "You dreamt of your home, The Urthen Crypts, under attack from the Uman and Faerie armies.", Toast.LENGTH_LONG).show();

                        break;


                }

                Intent MainIntent = new Intent(RaceSelectActivity.this, MainActivity.class);
                startActivity(MainIntent);
                isActivityIntent = true;
            }
        });

        builder.show();
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
        isActivityIntent = true;
    }
}
