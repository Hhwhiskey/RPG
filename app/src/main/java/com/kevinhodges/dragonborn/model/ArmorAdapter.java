package com.kevinhodges.dragonborn.model;

/**
 * Created by Kevin on 5/16/2016.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.blacksmith.Armor;

import java.util.ArrayList;

/**
 * Created by Kevin on 5/10/2016.
 */
public class ArmorAdapter extends RecyclerView.Adapter<ArmorAdapter.ArmorViewHolder> {

    private final SharedPreferences mSharedPreferences;
    private final SharedPreferences.Editor editor;
    private ArrayList<Armor> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public ArmorAdapter(Context context, ArrayList<Armor> data) {
        this.mContext = context;
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        editor = mSharedPreferences.edit();
    }



    @Override
    public ArmorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_row_armor, parent, false);
        return new ArmorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArmorViewHolder viewHolder, int position) {
        viewHolder.update(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public class ArmorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView armorType;
        TextView armorAmount;
        TextView armorCost;
        LinearLayout linearLayout;

        public ArmorViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout_blacksmith_armor);
            armorType = (TextView) itemView.findViewById(R.id.blacksmith_armor_type);
            armorAmount = (TextView) itemView.findViewById(R.id.blacksmith_armor_amount);
            armorCost = (TextView) itemView.findViewById(R.id.blacksmith_armor_cost);
        }

        public void update(int position) {

            Armor current = mData.get(position);

            linearLayout.setOnClickListener(this);
            armorType.setText(current.armorType);
            armorAmount.setText(String.valueOf(current.armorAmount));
            armorCost.setText(String.valueOf(current.armorCost));
        }

        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.MyAlertDialogStyle);
            builder.setTitle("Buy Armor");
            builder.setMessage("Would you like to buy " + armorAmount.getText().toString()
                    + " armor " + " for " + armorCost.getText().toString() + " gold?");
            builder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    removeArmorFromBlacksmithList(getAdapterPosition());

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.show();
        }

        // Remove the bought item from the list, update the list, then update the shared prefs list
        public void removeArmorFromBlacksmithList(int position) {
            mData.remove(position);
            notifyDataSetChanged();

            Gson gson = new Gson();
            String blacksmithArmorToJSON = gson.toJson(mData);
            editor.putString("blacksmithArmorList", blacksmithArmorToJSON);
            editor.commit();
        }

    }
}

