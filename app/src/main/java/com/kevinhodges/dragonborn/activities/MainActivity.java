package com.kevinhodges.dragonborn.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kevinhodges.dragonborn.R;

public class MainActivity extends AppCompatActivity {

    private TextView healthTV;
    private TextView staminaTV;
    private TextView armorTV;
    private TextView attackTV;
    private TextView daysTV;
    private TextView leaguesTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI Declarations///////////////////////////////////////////////////////////
        healthTV = (TextView) findViewById(R.id.tv_player_health);
        staminaTV = (TextView) findViewById(R.id.tv_player_stamina);
        armorTV = (TextView) findViewById(R.id.tv_player_armor);
        attackTV = (TextView) findViewById(R.id.tv_player_attack);
        daysTV = (TextView) findViewById(R.id.tv_player_days_left);
        leaguesTV = (TextView) findViewById(R.id.tv_player_leagues_left);
        ///////////////////////////////////////////////////////////////////////////

    }
}
