package com.kevinhodges.dragonborn.afragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.player.Player;

public class AlchemistFragment extends Fragment {

    private Player player;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alchemist, container, false);

        Intent intent = getActivity().getIntent();
        player = intent.getParcelableExtra("playerObject");
        return view;


    }
}
