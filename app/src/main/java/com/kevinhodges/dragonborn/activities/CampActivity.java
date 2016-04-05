package com.kevinhodges.dragonborn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.player.Player;

public class CampActivity extends AppCompatActivity {

    private static final String TAG = "CampActivity";
    private Player player;
    private String newPlayerRace;
    private boolean isNewPlayer;
    private String race;
    private int health;
    private int stamina;
    private int attackPower;
    private int weaponDamage;
    private int armor;
    private int gold;
    private int daysLeft;
    private int leaguesLeft;
    private String weaponType;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);

        Intent intent = getIntent();
        player = intent.getParcelableExtra("playerObject");

        /*layerRace = intent.getStringExtra("race");
        playerWeaponType = intent.getStringExtra("weaponType");
        playerHealth = intent.getIntExtra("health", 0);
        playerStamina = intent.getIntExtra("stamina", 0);
        playerAttackPower = intent.getIntExtra("attackPower", 0);
        playerWeaponDamage = intent.getIntExtra("weaponDamage", 0);
        playerArmor = intent.getIntExtra("armor", 0);
        playerGold = intent.getIntExtra("gold", 0);
        playerDaysLeft = intent.getIntExtra("daysLeft", 0);
        playerLeaguesLeft = intent.getIntExtra("leaguesLeft", 0);*/





      /*  RaceSelectActivity raceSelectActivity = new RaceSelectActivity();
        playerRace = raceSelectActivity.player.getRace();
        playerHealth = raceSelectActivity.player.getHealth();
        stamina = raceSelectActivity.player.getStamina();
        attackPower = raceSelectActivity.player.getAttackPower();
        weaponDamage = raceSelectActivity.player.getWeaponDamage();
        armor = raceSelectActivity.player.getArmor();
        gold = raceSelectActivity.player.getGold();
        daysLeft = raceSelectActivity.player.getDaysLeft();
        leaguesLeft = raceSelectActivity.player.getLeaguesLeft();
        playerWeaponType = raceSelectActivity.player.getWeaponType();*/


        Log.d(TAG, "race = " + playerRace);
        Log.d(TAG, "health = " + playerHealth);
        Log.d(TAG, "weaponType = " + playerWeaponType);


    }


    public Player getPlayer() {
        return player;
    }
}
