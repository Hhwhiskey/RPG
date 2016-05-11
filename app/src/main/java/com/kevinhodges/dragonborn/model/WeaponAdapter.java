package com.kevinhodges.dragonborn.model;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.blacksmith.Weapon;

import java.util.ArrayList;

/**
 * Created by Kevin on 5/10/2016.
 */
public class WeaponAdapter extends RecyclerView.Adapter<WeaponAdapter.WeaponViewHolder> {

    private ArrayList<Weapon> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public WeaponAdapter(Context context, ArrayList<Weapon> data) {
        this.mContext = context;
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public WeaponViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_row_weapon, parent, false);
        return new WeaponViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeaponViewHolder viewHolder, int position) {
        viewHolder.update(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class WeaponViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView weaponType;
        TextView weaponDamage;
        TextView weaponCost;
        LinearLayout linearLayout;

        public WeaponViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout_blacksmith_weapons);
            weaponType = (TextView) itemView.findViewById(R.id.blacksmith_weapon_type);
            weaponDamage = (TextView) itemView.findViewById(R.id.blacksmith_weapon_damage);
            weaponCost = (TextView) itemView.findViewById(R.id.blacksmith_weapon_cost);
        }

        public void update(int position) {

            Weapon current = mData.get(position);

            linearLayout.setOnClickListener(this);
            weaponType.setText(current.weaponType);
            weaponDamage.setText(String.valueOf(current.weaponDamage));
            weaponCost.setText(String.valueOf(current.weaponCost));
        }

        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.MyAlertDialogStyle);
            builder.setTitle("Buy Weapon");
            builder.setMessage("Would you like to buy this " + weaponDamage.getText().toString()
                    + " damage " + weaponType.getText().toString()
                    + " for " + weaponCost.getText().toString() + " gold?");
            builder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.show();
        }
    }
}
