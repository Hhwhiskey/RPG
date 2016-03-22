package com.kevinhodges.dragonborn.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kevinhodges.dragonborn.R;

public class RaceSelectActivity extends AppCompatActivity {

    private TextView umanTextView;
    private TextView faerieTextView;
    private TextView lokenTextView;
    private TextView risenTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_select);

        String intro = "You are awoken by a nightmare of your home under attack. Where might that be?";
        final String Urth = "Urth, the land of the Uman. Brave and courageous, these people make up the majority of Evon. The Uman have waged millennia of war against the Loken in defense of it's people. Though the Uman front is weakening from many years of war against the Loken and Risen, they have developed the strongest resilience in all of Avon - Uman have much higher health than the other races and have the ability to heal in combat.";
        final String Talion = "Talion, home of the magical and secretive Faerie. Nearly wiped out by the Loken many years ago if not for the Uman assistance, Talion is only just now becoming what it once was. Although small in stature and only representing a very small portion of Evon's people, they are the most feared in Avon because of their mastery of black magic. Faerie also excel in areas of stealth and luck and have the ability to flee from combat.";
        final String Duunbar = "Duunbar is the home of the Loken - massive brutes that thrive in combat and are driven by the destruction of Evon's people. Duunbar's proximity to Urth has allowed nearly 3 millenia of war between these two factions. The Loken have survived through their pillaging of Uman towns and homes. While not the most intelligent beings, their superior weapon training and strength allow them to wield massive weapons at their foes.";
        final String UrthenCrypts = "Beneath Urth lie the Urthen Crypts, here rest the corpses of all ancient Urthen warriors. Crossed many years ago by the Uman King 'Uther', these warriors lie in wait for the day they may avenge their death. In an attempt at destroying Urth, Loken Shaman have raised them from the dead and forced them to wage war against the Urth and Talion. Although the Risen are fairly weak, the dead do not tire, they do not have the burden of stamina";
        String begin = "Your adventure begins...";

        //UI Declarations///////////////////////////////////////////////////////////
        umanTextView = (TextView) findViewById(R.id.tv_uman);
        faerieTextView = (TextView) findViewById(R.id.tv_faerie);
        lokenTextView = (TextView) findViewById(R.id.tv_loken);
        risenTextView = (TextView) findViewById(R.id.tv_risen);
        ///////////////////////////////////////////////////////////////////////////


        umanTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRaceInfoDialog(Urth);
            }
        });

        faerieTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRaceInfoDialog(Talion);

            }
        });

        lokenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRaceInfoDialog(Duunbar);

            }
        });

        risenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRaceInfoDialog(UrthenCrypts);

            }
        });


    }

    public void showRaceInfoDialog(String raceInfo) {

        AlertDialog.Builder builder = new AlertDialog.Builder(RaceSelectActivity.this, R.style.MyAlertDialogStyle);
        builder.setTitle("Is this your home?");
        builder.setMessage(raceInfo);

        builder.setNegativeButton("This is not my home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setPositiveButton("This is my home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RaceSelectActivity.this, "This is your home", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
