package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.player.Player;

import java.util.Random;

public class TravelFragment extends Fragment {

    private static final String TAG = "TravelFragment";
    private Player player;
    private Button huntButton;
    private Button travelButton;
    private Button potionButton;
    private Button restButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_travel, container, false);

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");

        Log.d(TAG, "onCreate: Player health is now " + player.getHealth());

        //UI Declarations///////////////////////////////////////////////////////////
        huntButton = (Button) view.findViewById(R.id.bttn_hunt);
        travelButton = (Button) view.findViewById(R.id.bttn_travel);
        potionButton = (Button) view.findViewById(R.id.bttn_potions);
        restButton = (Button) view.findViewById(R.id.bttn_rest);
        ///////////////////////////////////////////////////////////////////////////

        huntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        potionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        // Travel, there is a 50% chance the player will encounter an enemy and have to fight
        // The player will travel between 2 and 50 leagues if there is a fight
        // and between 50 and 100 leagues if there is not a fight.
        // If there is no fight, the player has a 10% chance to come across a Camp during the travel
        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                boolean isThereAFight = random.nextBoolean();

                if (isThereAFight) {

                    int leaguesTraveledBeforeFight = Player.randomInteger(2, 50);

                    player.subtractDaysLeft(getActivity(), 1);
                    player.subtractLeaguesLeft(getActivity(), leaguesTraveledBeforeFight);
                    player.subtractStamina(getActivity(), 5);

                    Toast.makeText(getActivity(), "You confront an enemy " + leaguesTraveledBeforeFight + " leagues into your trek", Toast.LENGTH_LONG).show();

                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    CombatFragment combatFragment = new CombatFragment();
                    ft.replace(R.id.main_fragment_container, combatFragment);
                    ft.commit();

                } else {

                    int chanceForACamp = Player.randomInteger(1, 10);
                    int leaguesTraveledWithoutFight = Player.randomInteger(50, 100);

                    // If 10, put player in camp
                    if (chanceForACamp == 10) {

                        Toast.makeText(getActivity(), "You travel " + leaguesTraveledWithoutFight + " leagues before you discover a camp. Use this opportunity to re-arm yourself and regain your strength", Toast.LENGTH_LONG).show();

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        CampFragment campFragment = new CampFragment();
                        ft.replace(R.id.main_fragment_container, campFragment);
                        ft.commit();

                        // Otherwise, travel
                    } else {

                        Toast.makeText(getActivity(), "You travel " + leaguesTraveledWithoutFight + " leagues today", Toast.LENGTH_LONG).show();

                        player.subtractDaysLeft(getActivity(), 1);
                        player.subtractLeaguesLeft(getActivity(), leaguesTraveledWithoutFight);
                        player.subtractStamina(getActivity(), 5);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        TravelFragment travelFragment = new TravelFragment();
                        ft.replace(R.id.main_fragment_container, travelFragment);
                        ft.commit();
                    }
                }
            }
        });

        restButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!player.rest(getActivity())) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    CombatFragment combatFragment = new CombatFragment();
                    ft.replace(R.id.main_fragment_container, combatFragment);
                    ft.commit();
                }
            }
        });

        return view;
    }
}
