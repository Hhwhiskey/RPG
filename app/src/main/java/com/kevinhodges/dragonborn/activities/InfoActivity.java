package com.kevinhodges.dragonborn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.afragments.CampFragment;
import com.kevinhodges.dragonborn.player.Player;

public class InfoActivity extends AppCompatActivity {

    private static final String TAG = "InfoActivity";
    private String playerRace;
    private String playerWeaponType;
    private int playerHealth;
    private int playerStamina;
    private int playerAttackPower;
    private int playerWeaponDamage;
    private int playerArmor;
    private int playerGold;
    private int playerDaysLeft;
    private int playerLeaguesLeft;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        player = intent.getParcelableExtra("playerObject");

        Log.d(TAG, "Health = " + player.getHealth());


        //UI Declarations///////////////////////////////////////////////////////////
        Button beginButton = (Button) findViewById(R.id.button_begin);
        ///////////////////////////////////////////////////////////////////////////
        
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent campIntent = new Intent(InfoActivity.this, CampFragment.class);
                campIntent.putExtra("playerObject", player);
                startActivity(campIntent);
            }
        });
    }
}
