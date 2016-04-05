package com.kevinhodges.dragonborn.races;

import android.os.Parcel;
import android.os.Parcelable;

import com.kevinhodges.dragonborn.player.Player;

/**
 * Created by Kevin on 3/21/2016.
 */
public class Uman extends Player {

    private String race = "Uman";
    private int health = 200;
    private int stamina = 50;
    private int armor = 20;
    private int attackPower = 100;
    private int weaponDamage = 10;
    private int gold = 10;
    private int daysLeft = 400;
    private int leaguesLeft = 10000;
    private String weaponType = "1-handed Sword";
    private String trait = "Very high health and better armor.";
    private String special = "Shield wall - Take no damage the next 3 turns";
    private boolean invincible = false;
    private Object parcel;


    public Uman() {

    }

    public void heroic() {

    }


    // Getters/////////////////////////////////////////////////////////////////////////////////

    public String getRace() {
        return race;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public int getHealth() {
        return health;
    }

    public int getStamina() {
        return stamina;
    }

    public int getArmor() {
        return armor;
    }

    public int getAttackPower() {
        return attackPower;
    }


    public int getWeaponDamage() {
        return weaponDamage;
    }

    public int getGold() {
        return gold;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public int getLeaguesLeft() {
        return leaguesLeft;
    }





    //Parcelable//////////////////////////////////////////////////////////////////////////////////
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(race);
        dest.writeString(weaponType);
        dest.writeInt(health);
        dest.writeInt(stamina);
        dest.writeInt(armor);
        dest.writeInt(attackPower);
        dest.writeInt(weaponDamage);
        dest.writeInt(gold);
        dest.writeInt(daysLeft);
        dest.writeInt(leaguesLeft);
    }


    public static final Parcelable.Creator<Uman> CREATOR = new Parcelable.Creator<Uman>() {
        public Uman createFromParcel(Parcel in) {
            return new Uman(in);
        }

        @Override
        public Uman[] newArray(int size) {
            return new Uman[0];
        }
    };

    public Uman(Parcel input) {
        race = input.readString();
        weaponType = input.readString();
        health = input.readInt();
        stamina = input.readInt();
        armor = input.readInt();
        attackPower = input.readInt();
        weaponDamage = input.readInt();
        gold = input.readInt();
        daysLeft = input.readInt();
        leaguesLeft = input.readInt();
    }


}
