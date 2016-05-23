package com.kevinhodges.dragonborn.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.afragments.CampFragment;
import com.kevinhodges.dragonborn.player.Player;

public class MainActivity extends FragmentActivity {

    private static final String TAG = "MainActivity";
    private TextView healthTV;
    private TextView staminaTV;
    private TextView armorTV;
    private TextView attackTV;
    private TextView daysTV;
    private TextView leaguesTV;
    private FrameLayout mainFragmentContainer;
    private Player player;
    private TextView goldTV;
    private AlertDialog.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBuilder = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle);

        Intent intent = getIntent();
        player = intent.getParcelableExtra("playerObject");

        //UI Declarations///////////////////////////////////////////////////////////
        healthTV = (TextView) findViewById(R.id.tv_player_health);
        staminaTV = (TextView) findViewById(R.id.tv_player_stamina);
        armorTV = (TextView) findViewById(R.id.tv_player_armor);
        goldTV = (TextView) findViewById(R.id.tv_player_gold);
        daysTV = (TextView) findViewById(R.id.tv_player_days_left);
        leaguesTV = (TextView) findViewById(R.id.tv_player_leagues_left);
        mainFragmentContainer = (FrameLayout) findViewById(R.id.main_fragment_container);
        ///////////////////////////////////////////////////////////////////////////

        healthTV.setText("Health: " + String.valueOf(player.getHealth()));
        staminaTV.setText("Stamina: " + String.valueOf(player.getStamina()));
        armorTV.setText("Armor: " + String.valueOf(player.getArmor()));
        goldTV.setText("Gold: " + String.valueOf(player.getGold()));
        daysTV.setText("Days: " + String.valueOf(player.getDaysLeft()));
        leaguesTV.setText("Leagues: " + String.valueOf(player.getLeaguesLeft()));

        CampFragment campFragment = new CampFragment();

        getFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment_container, campFragment)
                .commit();
    }


    // Methods to update MainActivity TextViews//////////////////////////////////////////////////
    public void updateHealthTextView(int healthAmount) {
        healthTV.setText("Health: " + String.valueOf(healthAmount));
    }

    public void updateArmorTextView(int armorAmount) {
        armorTV.setText("Armor: " + String.valueOf(armorAmount));
    }

    public void updateStaminaTextView(int staminaAmount) {
        staminaTV.setText("Stamina: " + String.valueOf(staminaAmount));
    }

    public void updateLeaguesTextView(int leaguesLeft) {
        leaguesTV.setText("Leagues: " + String.valueOf(leaguesLeft));
    }

    public void updateDaysTextView(int daysLeft) {
        daysTV.setText("Days: " + String.valueOf(daysLeft));
    }

    public void updateGoldTextView(int goldAmount) {
        goldTV.setText("Gold: " + String.valueOf(goldAmount));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public Player getPlayer() {
        return player;
    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {

            mBuilder.setTitle("Exit");
            mBuilder.setMessage("Are you sure you would like to exit to the main menu?");
            mBuilder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent mainMenuIntent = new Intent(MainActivity.this, TitleActivity.class);
                    startActivity(mainMenuIntent);
                }
            });

            mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            mBuilder.show();

//            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }
}
