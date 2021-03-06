package com.kevinhodges.dragonborn.activities;

import android.app.AlertDialog;
import android.app.Dialog;
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

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.player.Player;
import com.kevinhodges.dragonborn.races.Faerie;
import com.kevinhodges.dragonborn.races.Loken;
import com.kevinhodges.dragonborn.races.Risen;
import com.kevinhodges.dragonborn.races.Uman;
import com.kevinhodges.dragonborn.utils.MusicService;

import java.util.ArrayList;

public class RaceSelectActivity extends AppCompatActivity {

    private TextView umanTextView;
    private TextView faerieTextView;
    private TextView lokenTextView;
    private TextView risenTextView;
    private String raceSelection;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Intent svc;
    private boolean isMusicPlaying;
    private boolean isActivityIntent;
    private static final String TAG = "RaceSelectActivity";
    //public Player player;
    private int playerHealth;
    private int playerStamina;
    private int playerAttackPower;
    private String playerWeaponType;
    private int playerWeaponDamage;
    private int playerArmor;
    private int playerGold;
    private int playerDaysLeft;
    private int playerLeaguesLeft;
    private Player player;
    private String playerRace;
    private ArrayList<String> blacksmithWeaponList;
    private ArrayList<Integer> blacksmithArmorList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_select);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = sharedPreferences.edit();

        isMusicPlaying = sharedPreferences.getBoolean("isMusicPlaying", false);

        String intro = "You are awoken by a nightmare of your home under attack. A strange, but familiar voice spoke to you. It warned that without you, all your people will parrish. To which of these people do you have allegiance to?";
        final String uman = "Urth, the land of the Uman. Brave and courageous, these people make up the majority of Evon. The Uman have waged millennia of war against the Loken in defense of it's people. Though the Uman front is weakening from many years of war against the Loken and Risen, they have developed the strongest resilience in all of Evon - Uman have the highest health and forge the best armor in the land.";
        final String faerie = "Talion, home of the magical and secretive Faerie. Nearly wiped out by the Loken many years ago if not for the Uman assistance, Talion is only just now becoming what it once was. Although small in stature and only representing a very small portion of Evon's people, they are the most feared in Evon because of their mastery of black magic. Faerie have been known to cast spells from extreme distances and destroy their opponent before they even have a chance.";
        final String loken = "Duunbar is the home of the Loken - massive brutes that thrive in combat and are driven by the destruction of Evon's people. Duunbar's proximity to Urth has allowed nearly 3 millenia of war between these two factions. The Loken have survived through their pillaging of Uman towns and homes. While not the most intelligent beings, their superior weapon training and size allows them to wield massive weapons and fight more efficiently.";
        final String risen = "Beneath Urth lie the Urthen Crypts, here rest the corpses of all ancient Urthen warriors. Crossed many years ago by the Uman King 'Uther', these warriors lie in wait for the day they may avenge their death. In an attempt at destroying Urth, Loken Shaman have raised them from the dead and forced them to wage war against the Urth and Talion. Although the Risen are fairly weak, the dead do not tire, and therefor do not have the burden of stamina.";

        //UI Declarations///////////////////////////////////////////////////////////
        umanTextView = (TextView) findViewById(R.id.tv_uman);
        faerieTextView = (TextView) findViewById(R.id.tv_faerie);
        lokenTextView = (TextView) findViewById(R.id.tv_loken);
        risenTextView = (TextView) findViewById(R.id.tv_risen);
        ///////////////////////////////////////////////////////////////////////////

        showDreamDialog(intro);

        umanTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBetterInfoDialog(uman, "Uman");

            }
        });

        faerieTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBetterInfoDialog(faerie, "Faerie");

            }
        });

        lokenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBetterInfoDialog(loken, "Loken");

            }
        });

        risenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBetterInfoDialog(risen, "Risen");

            }
        });


    }

    public void showDreamDialog(String intro) {

        AlertDialog.Builder builder = new AlertDialog.Builder(RaceSelectActivity.this, R.style.MyAlertDialogStyle);
        builder.setMessage(intro);
        builder.show();
    }

    public void showBetterInfoDialog(final String raceDescription, final String race) {

        final Dialog raceInfoDialog = new Dialog(RaceSelectActivity.this);
        raceInfoDialog.setContentView(R.layout.dialog_2);

        TextView dialogTitle = (TextView) raceInfoDialog.findViewById(R.id.dialog_2_title);
        TextView dialogMessage = (TextView) raceInfoDialog.findViewById(R.id.dialog_2_message);
        Button thisIsNotMyHomeButton = (Button) raceInfoDialog.findViewById(R.id.dialog_2_option_1);
        Button thisIsyMyHomeButton = (Button) raceInfoDialog.findViewById(R.id.dialog_2_option_2);

        dialogTitle.setText("Are these your people?");
        dialogMessage.setText(raceDescription);
        thisIsNotMyHomeButton.setText("No");
        thisIsyMyHomeButton.setText("Yes");

        raceInfoDialog.show();

        thisIsNotMyHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raceInfoDialog.dismiss();
            }
        });

        thisIsyMyHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                raceInfoDialog.dismiss();

                switch (race) {
                    case "Uman":
                        player = new Uman();

                        break;

                    case "Faerie":
                        player = new Faerie();

                        break;

                    case "Loken":
                        player = new Loken();

                        break;

                    case "Risen":
                        player = new Risen();

                        break;
                }

//                Intent infoIntent = new Intent(RaceSelectActivity.this, InfoActivity.class);
//                infoIntent.putExtra("playerObject", player);
//                finish();
//                startActivity(infoIntent);
//
//                isActivityIntent = true;

                Intent infoIntent = new Intent(RaceSelectActivity.this, MainActivity.class);
                infoIntent.putExtra("playerObject", player);
                finish();
                startActivity(infoIntent);

                isActivityIntent = true;


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
        isActivityIntent = true;
    }
}
