package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.blacksmith.Weapon;
import com.kevinhodges.dragonborn.model.WeaponAdapter;
import com.kevinhodges.dragonborn.player.Player;
import com.kevinhodges.dragonborn.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlacksmithWeaponsFragment extends Fragment {

    private static final String TAG = "BlacksmithWeaponsFragment";
    private Player player;
    private Button blacksmithLeaveButton;
    private Button viewArmorButton;
    private ArrayList<Weapon> mBlacksmithWeaponList;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean mHasWeaponListBeenCreated = false;
    private RecyclerView mWeaponRecyclerView;
    private WeaponAdapter mWeaponAdapter;
    private Button mBlacksmithWaitButton;
    private LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blacksmith_weapons, container, false);

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor = mSharedPreferences.edit();

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);


        //UI Declarations///////////////////////////////////////////////////////////
        blacksmithLeaveButton = (Button) view.findViewById(R.id.bttn_leave_blacksmith);
        mBlacksmithWaitButton = (Button) view.findViewById(R.id.bttn_wait_on_blacksmith_weapon);
        viewArmorButton = (Button) view.findViewById(R.id.button_view_blacksmith_armor);
        mWeaponRecyclerView = (RecyclerView) view.findViewById(R.id.rv_blacksmith_weapons);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mWeaponRecyclerView.setLayoutManager(mLayoutManager);
        ///////////////////////////////////////////////////////////////////////////

        mHasWeaponListBeenCreated = mSharedPreferences.getBoolean("hasWeaponListBeenCreated", false);

        if (!mHasWeaponListBeenCreated) {
            createNewWeaponList();
            editor.putBoolean("hasWeaponListBeenCreated", true);
            editor.commit();
        } else {
            showPreviousWeaponList();
        }

        blacksmithLeaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                CampFragment campFragment = new CampFragment();
                ft.replace(R.id.main_fragment_container, campFragment);
                ft.commit();
            }
        });

        mBlacksmithWaitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Wait for new weapons");
                builder.setMessage("Would you like to stay in camp an extra day to wait on new weapons and armor to be produced? The current items will be sold.");
                builder.setPositiveButton("Wait", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        waitADayAtBlacksmith();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
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

        mBlacksmithWeaponList = player.generateBlacksmithWeaponList(player.getRace(), player.getLeaguesLeft());
        Gson gson = new Gson();
        String blacksmithWeaponToJSON = gson.toJson(mBlacksmithWeaponList);
        editor.putString(Constants.BLACKSMITH_WEAPON_LIST, blacksmithWeaponToJSON);
        editor.commit();

        mWeaponAdapter = new WeaponAdapter(getActivity(), mBlacksmithWeaponList);
        mWeaponRecyclerView.setAdapter(mWeaponAdapter);
    }

    // TODO: 5/10/2016 This method needs to show the previous weapon list. Store weapon objects in shared prefs with gson
    private void showPreviousWeaponList() {

        Gson gson = new Gson();

        if (mSharedPreferences.contains(Constants.BLACKSMITH_WEAPON_LIST)) {

            String json = mSharedPreferences.getString(Constants.BLACKSMITH_WEAPON_LIST, "");
            Weapon[] jsonList = gson.fromJson(json, Weapon[].class);
            List<Weapon> weaponList = Arrays.asList(jsonList);
            weaponList = new ArrayList<>(weaponList);

            mWeaponAdapter = new WeaponAdapter(getActivity(), (ArrayList<Weapon>) weaponList);
            mWeaponRecyclerView.setAdapter(mWeaponAdapter);
        }
    }

    // This method will subtract a day from the players remaining days, create a new weapon list,
    // and notify the user with a toast
    // It will also reset the hasArmorListBeenCreated so that the armor list will also refresh
    public void waitADayAtBlacksmith() {
        player.subtractDaysLeft(getActivity(), 1);
        createNewWeaponList();
        Toast.makeText(getActivity(), "You have " + player.getDaysLeft() + " days left", Toast.LENGTH_SHORT).show();

        editor.putBoolean("hasArmorListBeenCreated", false);
        editor.commit();
    }
}
