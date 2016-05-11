package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.blacksmith.Weapon;
import com.kevinhodges.dragonborn.player.Player;

import java.util.ArrayList;

/**
 * Created by Kevin on 5/10/2016.
 */
public class BlacksmithArmorFragment extends Fragment {

    private static final String TAG = "BlacksmithWeaponsFragment";
    private Player player;
    private Button blacksmithLeaveButton;
    private Button viewWeaponsButton;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blacksmith_armor, container, false);

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");

        ArrayList<Weapon> blacksmithWeaponList = player.generateBlacksmithWeaponList(player.getRace(), player.getLeaguesLeft());
        Log.d(TAG, "onCreateView: weapon count = " + blacksmithWeaponList.size());

        //UI Declarations///////////////////////////////////////////////////////////
        blacksmithLeaveButton = (Button) view.findViewById(R.id.bttn_leave_blacksmith);
        viewWeaponsButton = (Button) view.findViewById(R.id.bttn_view_blacksmith_weapons);
        RecyclerView weaponRecyclerView = (RecyclerView) view.findViewById(R.id.rv_blacksmith_weapons);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        WeaponAdapter weaponAdapter = new WeaponAdapter(getActivity(), blacksmithWeaponList);
//        weaponRecyclerView.setLayoutManager(layoutManager);
//        weaponRecyclerView.setAdapter(weaponAdapter);
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

        viewWeaponsButton.setOnClickListener(new View.OnClickListener() {
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


}
