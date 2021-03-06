package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.activities.MainActivity;
import com.kevinhodges.dragonborn.player.Player;

public class SoothsayerFragment extends Fragment {

    private static final String TAG = "SoothsayerFragment";
    private Player player;
    private Button leaveSoothsayerButton;
    private Button healSoothsayerButton;
    private TextView soothsayerHealCostTV;
    private TextView goldTV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soothsayer, container, false);

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");

        final MainActivity mainActivity = (MainActivity) getActivity();


        //UI Declarations///////////////////////////////////////////////////////////
        soothsayerHealCostTV = (TextView) view.findViewById(R.id.tv_soothsayer_heal_cost);
        leaveSoothsayerButton = (Button) view.findViewById(R.id.button_soothsayer_leave);
        healSoothsayerButton = (Button) view.findViewById(R.id.button_soothsayer_heal);
        goldTV = (TextView) view.findViewById(R.id.tv_player_gold);
        ///////////////////////////////////////////////////////////////////////////

        final int soothsayerHealCostInt = generateSoothsayerHealCost(player.getLeaguesLeft());
        String soothsayerHealCostString = String.valueOf(soothsayerHealCostInt);

        soothsayerHealCostTV.setText(soothsayerHealCostString);

        leaveSoothsayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        healSoothsayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (player.getHealth() == player.getMaxHealth() ) {
                    Toast.makeText(getActivity(), "You are already at full health", Toast.LENGTH_SHORT).show();

                } else if (player.getGold() < soothsayerHealCostInt) {
                    Toast.makeText(getActivity(), "You do not have enough gold", Toast.LENGTH_SHORT).show();

                } else {

                    player.spendPlayerGold(getActivity(), soothsayerHealCostInt);
                    player.healPlayerToFull(getActivity());

//                    mainActivity.updateGoldTextView(player.getGold());
//                    mainActivity.updateHealthTextView(player.healPlayerToFull());

                    Toast.makeText(getActivity(), "You have been healed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    public int generateSoothsayerHealCost(int leaguesLeft) {

        int priceMultiplier = (10010 - leaguesLeft) * 10;

        return priceMultiplier;
    }




}
