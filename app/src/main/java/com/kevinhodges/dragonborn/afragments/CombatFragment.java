package com.kevinhodges.dragonborn.afragments;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.enemy.Enemy;
import com.kevinhodges.dragonborn.player.Player;
import com.kevinhodges.dragonborn.utils.MusicService;

public class CombatFragment extends Fragment {

    private static final String TAG = "CombatFragment";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Intent svc;
    private boolean isMusicPlaying;
    private boolean isActivityIntent;
    AlertDialog.Builder builder;
    private Button attackButton;
    private Button heroicButton;
    private Button potionsButton;
    private Button fleeButton;
    private static int enemyCount;
    public Player player;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_combat, container, false);

        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor = sharedPreferences.edit();

        isMusicPlaying = sharedPreferences.getBoolean("isMusicPlaying", false);

        //UI Declarations///////////////////////////////////////////////////////////
        attackButton = (Button) view.findViewById(R.id.button_attack);
        heroicButton = (Button) view.findViewById(R.id.button_heroic);
        potionsButton = (Button) view.findViewById(R.id.button_potions);
        fleeButton = (Button) view.findViewById(R.id.button_flee);
        ///////////////////////////////////////////////////////////////////////////

        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog attackDialog = new Dialog(getActivity());
                attackDialog.setContentView(R.layout.dialog_attack);

                Button weakAttackButton = (Button) attackDialog.findViewById(R.id.dialog_button_weak_attack);
                Button mediumAttackButton = (Button) attackDialog.findViewById(R.id.dialog_button_medium_attack);
                Button strongAttackButton = (Button) attackDialog.findViewById(R.id.dialog_button_strong_attack);

                weakAttackButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "Weak attack", Toast.LENGTH_SHORT).show();
                        attackDialog.dismiss();
                    }
                });

                mediumAttackButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "Medium attack", Toast.LENGTH_SHORT).show();
                        attackDialog.dismiss();
                    }
                });

                strongAttackButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "Strong attack", Toast.LENGTH_SHORT).show();
                        attackDialog.dismiss();
                    }
                });

                attackDialog.show();
            }
        });

        heroicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        potionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        fleeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Enemy enemy = new Enemy(25, 50);
        String enemyRace = enemy.generateRandomRace();
        int enemyHealth = enemy.generateRandomHealth();
        int enemyStamina = enemy.generateRandomStamina();
        int enemyArmor = enemy.generateRandomArmor();
        int enemyDamage = enemy.generateEnemyDamage();

        Log.d(TAG, enemyRace + " Health: " + enemyHealth);
        Log.d(TAG, enemyRace + " Stamina: " + enemyStamina);
        Log.d(TAG, enemyRace + " Armor: " + enemyArmor);
        Log.d(TAG, enemyRace + " Damage: " + enemyDamage);

        return view;
    }



    @Override
    public void onResume() {
        super.onResume();

//        Log.d(TAG, "isMusicPlaying = " + isMusicPlaying);

        isActivityIntent = false;

        if (!isMusicPlaying) {
            svc = new Intent(getActivity(), MusicService.class);
            getActivity().startService(svc);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (!isActivityIntent) {
            svc = new Intent(getActivity(), MusicService.class);
            getActivity().stopService(svc);
            editor.putBoolean("isMusicPlaying", false);
            editor.commit();
        }
    }

    public Player getPlayer() {
        return player;
    }

}
