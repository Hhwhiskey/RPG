package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.player.Player;
import com.kevinhodges.dragonborn.potion.Potion;

public class AlchemistFragment extends Fragment {

    private Player player;
    private Button buyEvasionPotionButton;
    private Button buyInvisibilityPotionButton;
    private Button buyEndurancePotionButton;
    private Button buyMountainPotionButton;
    private Button buyStrengthPotionButton;
    private AlertDialog.Builder mBuilder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alchemist, container, false);

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");

        mBuilder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);

        //UI Declarations///////////////////////////////////////////////////////////
        buyEvasionPotionButton = (Button) view.findViewById(R.id.bttn_buy_evasion);
        buyInvisibilityPotionButton = (Button) view.findViewById(R.id.bttn_buy_invisibility);
        buyEndurancePotionButton = (Button) view.findViewById(R.id.bttn_buy_endurance);
        buyMountainPotionButton = (Button) view.findViewById(R.id.bttn_buy_mountain);
        buyStrengthPotionButton = (Button) view.findViewById(R.id.bttn_buy_strength);
        ///////////////////////////////////////////////////////////////////////////

        final Potion evasionPotion = new Potion("Evasion Potion", player.getLeaguesLeft());
        final Potion invisibilityPotion = new Potion("Invisibility Potion",player.getLeaguesLeft());
        final Potion endurancePotion = new Potion("Lasting Endurance Potion",player.getLeaguesLeft());
        final Potion mountainHidePotion = new Potion("Mountain Hide Potion",player.getLeaguesLeft());
        final Potion strengthOfIkkorPotion = new Potion("Strength of Ikkor Potion",player.getLeaguesLeft());

        buyEvasionPotionButton.setText(String.valueOf(evasionPotion.generatePotionCost()) + " Gold");
        buyEvasionPotionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBuilder.setTitle("Evasion Potion");
                mBuilder.setMessage("Are you sure you would like to buy an evasion potion for " + evasionPotion.getPotionCost() + " Gold?");
                mBuilder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        player.addPotionToInventory(evasionPotion);
                        player.spendPlayerGold(getActivity(), evasionPotion.getPotionCost());
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                mBuilder.show();
            }
        });

        buyInvisibilityPotionButton.setText(String.valueOf(invisibilityPotion.generatePotionCost()) + " Gold");
        buyInvisibilityPotionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBuilder.setTitle("Invisibility Potion");
                mBuilder.setMessage("Are you sure you would like to buy an invisibility potion for " + invisibilityPotion.getPotionCost() + " Gold?");
                mBuilder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        player.addPotionToInventory(invisibilityPotion);
                        player.spendPlayerGold(getActivity(), invisibilityPotion.getPotionCost());

                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                mBuilder.show();
            }
        });

        buyEndurancePotionButton.setText(String.valueOf(endurancePotion.generatePotionCost()) + " Gold");
        buyEndurancePotionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBuilder.setTitle("Endurance Potion");
                mBuilder.setMessage("Are you sure you would like to buy an Endurance potion for " + endurancePotion.getPotionCost() + " Gold?");
                mBuilder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        player.addPotionToInventory(endurancePotion);
                        player.spendPlayerGold(getActivity(), endurancePotion.getPotionCost());
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                mBuilder.show();
            }
        });

        buyMountainPotionButton.setText(String.valueOf(mountainHidePotion.generatePotionCost()) + " Gold");
        buyMountainPotionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBuilder.setTitle("Mountain Hide Potion");
                mBuilder.setMessage("Are you sure you would like to buy a Mountain Hide potion for " + mountainHidePotion.getPotionCost() + " Gold?");
                mBuilder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        player.addPotionToInventory(mountainHidePotion);
                        player.spendPlayerGold(getActivity(), mountainHidePotion.getPotionCost());
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                mBuilder.show();
            }
        });

        buyStrengthPotionButton.setText(String.valueOf(strengthOfIkkorPotion.generatePotionCost()) + " Gold");
        buyStrengthPotionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBuilder.setTitle("Strength of Ikkor Potion");
                mBuilder.setMessage("Are you sure you would like to buy a Strength of Ikkor potion for " + strengthOfIkkorPotion.getPotionCost() + " Gold?");
                mBuilder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        player.addPotionToInventory(strengthOfIkkorPotion);
                        player.spendPlayerGold(getActivity(), strengthOfIkkorPotion.getPotionCost());
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                mBuilder.show();
            }
        });
        return view;
    }
}
