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
import android.widget.Toast;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.objects.Player;
import com.kevinhodges.dragonborn.races.Uman;
import com.kevinhodges.dragonborn.utils.MusicService;

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
    public Player player;
    private int playerHealth;
    private int playerStamina;
    private int playerAttackPower;
    private String playerWeaponType;
    private int playerWeaponDamage;
    private int playerArmor;
    private int playerGold;
    private int playerDaysLeft;
    private int playerLeaguesLeft;

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
        String begin = "Your adventure begins...";

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
                        Toast.makeText(RaceSelectActivity.this, "You dreamt of your home, Urth, under attack from the Loken and Risen armies.", Toast.LENGTH_LONG).show();
//                        player.createNewPlayerWithRace("Uman");
//                        player = new Player("Uman");

                        player = new Uman();

                        String playerRace = player.getRace();
                        playerWeaponType = player.getWeaponType();
                        playerHealth = player.getHealth();
                        playerStamina = player.getStamina();
                        playerAttackPower = player.getAttackPower();
                        playerWeaponDamage = player.getWeaponDamage();
                        playerArmor = player.getArmor();
                        playerGold = player.getGold();
                        playerDaysLeft = player.getDaysLeft();
                        playerLeaguesLeft = player.getLeaguesLeft();


//                        ArrayList<String> weaponList = player.getBlackSmithWeaponList();


                        Log.d(TAG, "race = " + playerRace);
                        Log.d(TAG, "weaponType = " + playerWeaponType);
                        Log.d(TAG, "health = " + playerHealth);
                        Log.d(TAG, "stamina = " + playerStamina);
                        Log.d(TAG, "attackPower = " + playerAttackPower);
                        Log.d(TAG, "weaponDamage = " + playerWeaponDamage);
                        Log.d(TAG, "armor = " + playerArmor);
                        Log.d(TAG, "gold = " + playerGold);
                        Log.d(TAG, "daysLeft = " + playerDaysLeft);
                        Log.d(TAG, "leaguesLeft = " + playerLeaguesLeft);

//                        Log.d(TAG, "weaponList = " + weaponList);

                        break;

                    case "Faerie":
                        Toast.makeText(RaceSelectActivity.this, "You dreamt of your home, Talion, under attack from the Loken and Risen armies.", Toast.LENGTH_LONG).show();
//                        player.createNewPlayerWithRace("Faerie");
//                        player = new Faerie();
                        break;

                    case "Loken":
                        Toast.makeText(RaceSelectActivity.this, "You dreamt of your home, Duunbar, under attack from the Uman and Faerie armies.", Toast.LENGTH_LONG).show();
//                        player.createNewPlayerWithRace("Loken");
//                        player = new Loken();
                        break;

                    case "Risen":
                        Toast.makeText(RaceSelectActivity.this, "You dreamt of your home, The Urthen Crypts, under attack from the Uman and Faerie armies.", Toast.LENGTH_LONG).show();
//                        player.createNewPlayerWithRace("Risen");
//                        player = new Risen();
                        break;
                }

                Intent intent = new Intent(RaceSelectActivity.this, InfoActivity.class);
                intent.putExtra("race", race);
                intent.putExtra("weaponType", playerWeaponType);
                intent.putExtra("health", playerHealth);
                intent.putExtra("stamina", playerStamina);
                intent.putExtra("attackPower", playerAttackPower);
                intent.putExtra("weaponDamage", playerWeaponDamage);
                intent.putExtra("armor", playerArmor);
                intent.putExtra("gold", playerGold);
                intent.putExtra("daysLeft", playerDaysLeft);
                intent.putExtra("leaguesLeft", playerLeaguesLeft);
                startActivity(intent);

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
