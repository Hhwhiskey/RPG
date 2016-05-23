package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.player.Player;

import java.util.Random;

public class CampFragment extends Fragment {

    private static final String TAG = "CampFragment";
    private Player player;
    private Button blacksmithButton;
    private Button alchemistButton;
    private Button soothsayerButton;
    private Button travelButton;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private AlertDialog.Builder mBuilder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camp, container, false);

        mBuilder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor = sharedPreferences.edit();

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");

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
                BlacksmithWeaponsFragment blacksmithWeaponsFragment = new BlacksmithWeaponsFragment();
                ft.replace(R.id.main_fragment_container, blacksmithWeaponsFragment);
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

        // Travel, there is a 50% chance the player will encounter an enemy and have to fight
        // The player will travel between 2 and 50 leagues if there is a fight
        // and between 50 and 100 leagues if there is not a fight.
        // If there is no fight, the player has a 10% chance to come across a Camp during the travel
        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mBuilder.setTitle("Travel");
                mBuilder.setMessage("Are you sure you are ready to leave camp?");
                mBuilder.setPositiveButton("Leave", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Set weapon list to false so that it will be created again at next camp
                        editor.putBoolean("hasWeaponListBeenCreated", false);
                        editor.commit();

                        Random random = new Random();
                        boolean isThereAFight = random.nextBoolean();

                        if (isThereAFight) {

                            int leaguesTraveledBeforeFight = Player.randomInteger(2, 50);

                            player.subtractDaysLeft(getActivity(), 1);
                            player.subtractLeaguesLeft(getActivity(), leaguesTraveledBeforeFight);
                            player.subtractStamina(getActivity(), 5);

                            Toast.makeText(getActivity(), "You confront an enemy " + leaguesTraveledBeforeFight + " leagues into your trek", Toast.LENGTH_SHORT).show();

                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            CombatFragment combatFragment = new CombatFragment();
                            ft.replace(R.id.main_fragment_container, combatFragment);
                            ft.commit();

                        } else {

                            int leaguesTraveledWithoutFight = Player.randomInteger(50, 100);
                            Toast.makeText(getActivity(), "You travel " + leaguesTraveledWithoutFight + " leagues today", Toast.LENGTH_SHORT).show();

                            player.subtractDaysLeft(getActivity(), 1);
                            player.subtractLeaguesLeft(getActivity(), leaguesTraveledWithoutFight);
                            player.subtractStamina(getActivity(), 5);


                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            TravelFragment travelFragment = new TravelFragment();
                            ft.replace(R.id.main_fragment_container, travelFragment);
                            ft.commit();
                        }
                    }
                });

                mBuilder.setNegativeButton("Stay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                mBuilder.show();
            }
        });

        return view;
    }

    public Player getPlayer() {
        return player;
    }
}
