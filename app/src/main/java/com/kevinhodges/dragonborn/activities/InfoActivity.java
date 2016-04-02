package com.kevinhodges.dragonborn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kevinhodges.dragonborn.R;

public class InfoActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        playerRace = intent.getStringExtra("race");
        playerWeaponType = intent.getStringExtra("weaponType");
        playerHealth = intent.getIntExtra("health", 0);
        playerStamina = intent.getIntExtra("stamina", 0);
        playerAttackPower = intent.getIntExtra("attackPower", 0);
        playerWeaponDamage = intent.getIntExtra("weaponDamage", 0);
        playerArmor = intent.getIntExtra("armor", 0);
        playerGold = intent.getIntExtra("gold", 0);
        playerDaysLeft = intent.getIntExtra("daysLeft", 0);
        playerLeaguesLeft = intent.getIntExtra("leaguesLeft", 0);

        //UI Declarations///////////////////////////////////////////////////////////
        Button beginButton = (Button) findViewById(R.id.button_begin);
        ///////////////////////////////////////////////////////////////////////////
        
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, CampActivity.class);
                intent.putExtra("race", playerRace);
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
            }
        });
    }
}
