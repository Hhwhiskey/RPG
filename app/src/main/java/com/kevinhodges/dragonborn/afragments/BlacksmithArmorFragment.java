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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.blacksmith.Armor;
import com.kevinhodges.dragonborn.model.ArmorAdapter;
import com.kevinhodges.dragonborn.player.Player;
import com.kevinhodges.dragonborn.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kevin on 5/10/2016.
 */
public class BlacksmithArmorFragment extends Fragment {

    private static final String TAG = "BlacksmithWeaponsFragment";
    private Player player;
    private Button mBlacksmithLeaveButton;
    private Button mViewWeaponsButton;
    private boolean mHasArmorListBeenCreated = false;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;
    private ArmorAdapter mArmorAdapter;
    private RecyclerView mArmorRecyclerView;
    private ArrayList<Armor> mBlacksmithArmorList;
    private Button mBlacksmithWaitButton;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blacksmith_armor, container, false);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor = mSharedPreferences.edit();

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");

        ArrayList<Armor> blacksmithArmorList = player.generateBlacksmithArmorList(player.getRace(), player.getLeaguesLeft());
        Log.d(TAG, "onCreateView: weapon count = " + blacksmithArmorList.size());

        //UI Declarations///////////////////////////////////////////////////////////
        mBlacksmithLeaveButton = (Button) view.findViewById(R.id.bttn_leave_blacksmith);
        mBlacksmithWaitButton = (Button) view.findViewById(R.id.bttn_wait_on_blacksmith_armor);
        mViewWeaponsButton = (Button) view.findViewById(R.id.bttn_view_blacksmith_weapons);
        mArmorRecyclerView = (RecyclerView) view.findViewById(R.id.rv_blacksmith_armor);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mArmorAdapter = new ArmorAdapter(getActivity(), blacksmithArmorList);
        mArmorRecyclerView.setLayoutManager(layoutManager);
        ///////////////////////////////////////////////////////////////////////////

        mHasArmorListBeenCreated = mSharedPreferences.getBoolean("hasArmorListBeenCreated", false);

        // If no list has been created, show a list of armor
        // If a list has already been displayed, reshow the previous list
        if (!mHasArmorListBeenCreated) {
            createNewArmorList();
            editor.putBoolean("hasArmorListBeenCreated", true);
            editor.commit();
        } else {
            showPreviousArmorList();
        }

        mBlacksmithLeaveButton.setOnClickListener(new View.OnClickListener() {
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
                builder.setTitle("Wait for new armor");
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

        mViewWeaponsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                BlacksmithWeaponsFragment blacksmithWeaponsFragment = new BlacksmithWeaponsFragment();
                ft.replace(R.id.main_fragment_container, blacksmithWeaponsFragment);
                ft.commit();
            }
        });

        return view;
    }

    private void showPreviousArmorList() {

        Gson gson = new Gson();

        if (mSharedPreferences.contains(Constants.BLACKSMITH_ARMOR_LIST)) {

            String json = mSharedPreferences.getString(Constants.BLACKSMITH_ARMOR_LIST, "");
            Armor[] jsonList = gson.fromJson(json, Armor[].class);
            List<Armor> armorList = Arrays.asList(jsonList);
            armorList = new ArrayList<>(armorList);

            mArmorAdapter = new ArmorAdapter(getActivity(), (ArrayList<Armor>) armorList);
            mArmorRecyclerView.setAdapter(mArmorAdapter);
        }
    }

    public void createNewArmorList() {

        mBlacksmithArmorList = player.generateBlacksmithArmorList(player.getRace(), player.getLeaguesLeft());
        Gson gson = new Gson();
        String blacksmithArmorToJSON = gson.toJson(mBlacksmithArmorList);
        editor.putString(Constants.BLACKSMITH_ARMOR_LIST, blacksmithArmorToJSON);
        editor.commit();

        mArmorAdapter = new ArmorAdapter(getActivity(), mBlacksmithArmorList);
        mArmorRecyclerView.setAdapter(mArmorAdapter);
    }

    // This method will subtract a day from the players remaining days, create a new weapon list,
    // and notify the user with a toast
    // It will also reset the hasWeaponListBeenCreated so that the weapon list will also refresh
    public void waitADayAtBlacksmith() {
        player.subtractDaysLeft(getActivity(), 1);
        createNewArmorList();
        Toast.makeText(getActivity(), "You have " + player.getDaysLeft() + " days left", Toast.LENGTH_SHORT).show();

        editor.putBoolean("hasWeaponListBeenCreated", false);
        editor.commit();
    }
}
