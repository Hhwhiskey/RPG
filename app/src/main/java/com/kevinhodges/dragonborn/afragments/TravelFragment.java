package com.kevinhodges.dragonborn.afragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.player.Player;

public class TravelFragment extends AppCompatActivity {

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_travel);

        Intent intent = getIntent();
        player = intent.getParcelableExtra("playerObject");

    }
}
