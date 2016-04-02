package com.kevinhodges.dragonborn.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.objects.Player;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);

        RaceSelectActivity raceSelectActivity = new RaceSelectActivity();
        race = raceSelectActivity.player.getRace();
        health = raceSelectActivity.player.getHealth();
        stamina = raceSelectActivity.player.getStamina();
        attackPower = raceSelectActivity.player.getAttackPower();
        weaponDamage = raceSelectActivity.player.getWeaponDamage();
        armor = raceSelectActivity.player.getArmor();
        gold = raceSelectActivity.player.getGold();
        daysLeft = raceSelectActivity.player.getDaysLeft();
        leaguesLeft = raceSelectActivity.player.getLeaguesLeft();
        weaponType = raceSelectActivity.player.getWeaponType();

        Log.d(TAG, "race = " + race);
        Log.d(TAG, "health = " + health);
        Log.d(TAG, "weaponType = " + weaponType);

    }


    public Player getPlayer() {
        return player;
    }
}
