package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.blacksmith.Weapon;
import com.kevinhodges.dragonborn.model.WeaponAdapter;
import com.kevinhodges.dragonborn.player.Player;

import java.util.ArrayList;

public class BlacksmithWeaponsFragment extends Fragment {

    private static final String TAG = "BlacksmithWeaponsFragment";
    private Player player;
    private Button blacksmithLeaveButton;
    private Button viewArmorButton;
    private ArrayList<Weapon> blacksmithWeaponList;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean sharedPrefBoolean = false;
    private RecyclerView weaponRecyclerView;
    private WeaponAdapter weaponAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blacksmith_weapons, container, false);

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor = sharedPreferences.edit();

        sharedPrefBoolean = sharedPreferences.getBoolean("hasWeaponListBeenCreated", false);

        if (!sharedPrefBoolean) {
            createNewWeaponList();
            editor.putBoolean("hasWeaponListBeenCreated", true);
            editor.commit();
        } else {
            showPreviousWeaponList();
        }

        //UI Declarations///////////////////////////////////////////////////////////
        blacksmithLeaveButton = (Button) view.findViewById(R.id.bttn_leave_blacksmith);
        viewArmorButton = (Button) view.findViewById(R.id.button_view_blacksmith_armor);
        weaponRecyclerView = (RecyclerView) view.findViewById(R.id.rv_blacksmith_weapons);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        weaponAdapter = new WeaponAdapter(getActivity(), blacksmithWeaponList);
        weaponRecyclerView.setLayoutManager(layoutManager);
        weaponRecyclerView.setAdapter(weaponAdapter);
        ///////////////////////////////////////////////////////////////////////////

        blacksmithLeaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                CampFragment campFragment = new CampFragment();
                ft.replace(R.id.main_fragment_container, campFragment);
                ft.commit();
            }
        });

        viewArmorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                BlacksmithArmorFragment blacksmithArmorFragment = new BlacksmithArmorFragment();
                ft.replace(R.id.main_fragment_container, blacksmithArmorFragment);
                ft.commit();
            }
        });

        return view;
    }

    public void createNewWeaponList() {
        blacksmithWeaponList = player.generateBlacksmithWeaponList(player.getRace(), player.getLeaguesLeft());
    }

    // TODO: 5/10/2016 This method needs to show the previous weapon list. Store weapon objects in shared prefs with gson
    private void showPreviousWeaponList() {
        weaponRecyclerView.setAdapter(weaponAdapter);
    }
}
