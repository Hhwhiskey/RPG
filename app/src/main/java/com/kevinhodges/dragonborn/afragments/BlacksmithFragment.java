package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.player.Player;

public class BlacksmithFragment extends Fragment {

    private Player player;
    private ViewPager blacksmithViewPager;
    private Button blacksmithWeaponButton;
    private Button blacksmithArmorButton;
    private TextView healthTV;
    private TextView staminaTV;
    private TextView armorTV;
    private TextView attackTV;
    private TextView daysTV;
    private TextView leaguesTV;
    private Button blacksmithLeaveButton;
    private Button blacksmithWeaponsButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blacksmith, container, false);

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");

        //UI Declarations///////////////////////////////////////////////////////////
        blacksmithLeaveButton = (Button) view.findViewById(R.id.button_leave_blacksmith);
        blacksmithWeaponsButton = (Button) view.findViewById(R.id.button_blacksmith_weapons);
        blacksmithArmorButton = (Button) view.findViewById(R.id.button_blacksmith_armor);
        ///////////////////////////////////////////////////////////////////////////

        blacksmithLeaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });


        return view;
    }


}
