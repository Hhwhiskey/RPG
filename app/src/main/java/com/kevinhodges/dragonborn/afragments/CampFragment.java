package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.player.Player;

public class CampFragment extends Fragment {

    private static final String TAG = "CampFragment";
    private Player player;
    private Button blackSmithButton;
    private Button alchemistButton;
    private Button soothsayerButton;
    private Button travelButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blacksmith, container, false);

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");

//        Log.d(TAG, "race = " + );
//        Log.d(TAG, "health = " + );
//        Log.d(TAG, "weaponType = " + );

        //UI Declarations///////////////////////////////////////////////////////////
        blackSmithButton = (Button) view.findViewById(R.id.button_goto_blacksmith);
        alchemistButton = (Button) view.findViewById(R.id.button_goto_alchemist);
        soothsayerButton = (Button) view.findViewById(R.id.button_goto_soothsayer);
        travelButton = (Button) view.findViewById(R.id.button_travel_from_camp);
        ///////////////////////////////////////////////////////////////////////////

        blackSmithButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        alchemistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        soothsayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    public Player getPlayer() {
        return player;
    }
}
