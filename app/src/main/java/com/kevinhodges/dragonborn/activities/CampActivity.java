package com.kevinhodges.dragonborn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.objects.Player;

public class CampActivity extends AppCompatActivity {

    private Player player;
    private String newPlayerRace;
    private boolean isNewPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);


    }



    public Player getPlayer() {
        return player;
    }
}
