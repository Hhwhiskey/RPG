package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
    private Button blacksmithButton;
    private Button alchemistButton;
    private Button soothsayerButton;
    private Button travelButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camp, container, false);

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");



//        Log.d(TAG, "race = " + );
//        Log.d(TAG, "health = " + );
//        Log.d(TAG, "weaponType = " + );

        //UI Declarations///////////////////////////////////////////////////////////
        blacksmithButton = (Button) view.findViewById(R.id.button_goto_blacksmith);
        alchemistButton = (Button) view.findViewById(R.id.button_goto_alchemist);
        soothsayerButton = (Button) view.findViewById(R.id.button_goto_soothsayer);
        travelButton = (Button) view.findViewById(R.id.button_travel_from_camp);
        ///////////////////////////////////////////////////////////////////////////

        blacksmithButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                BlacksmithFragment blacksmithFragment = new BlacksmithFragment();
                ft.replace(R.id.main_fragment_container, blacksmithFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        alchemistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentTransaction ft = getFragmentManager().beginTransaction();
                AlchemistFragment alchemistFragment = new AlchemistFragment();
                ft.replace(R.id.main_fragment_container, alchemistFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        soothsayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                SoothsayerFragment soothsayerFragment = new SoothsayerFragment();
                ft.replace(R.id.main_fragment_container, soothsayerFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                TravelFragment travelFragment = new TravelFragment();
                ft.replace(R.id.main_fragment_container, travelFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return view;
    }

    public Player getPlayer() {
        return player;
    }
}
