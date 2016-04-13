package com.kevinhodges.dragonborn.races;

import android.os.Parcel;
import android.os.Parcelable;

import com.kevinhodges.dragonborn.player.Player;

/**
 * Created by Kevin on 3/21/2016.
 */
public class Faerie extends Player {

    private String race = "Faerie";
    private int health = 50;
    private int stamina = 100;
    private int armor = 10;
    private int attackPower = 200;
    private int weaponDamage = 10;
    private int gold = 10;
    private int daysLeft = 400;
    private int leaguesLeft = 10000;
    private String weaponType = "Staff";

    private String trait = "2 attacks before taking any damage and cannot be damaged from an ambush, even while resting.";
    private String special = "Teleport - Instead of attacking this turn, dodge the enemies attack, and you get 3 attacks next turn";

    public Faerie() {

    }

    @Override
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

    //Setters//////////////////////////////////////////////////////////////////////////////////////
    public void setRace(String race) {
        this.race = race;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public void setLeaguesLeft(int leaguesLeft) {
        this.leaguesLeft = leaguesLeft;
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

    public static final Parcelable.Creator<Faerie> CREATOR = new Parcelable.Creator<Faerie>() {
        public Faerie createFromParcel(Parcel in) {
            return new Faerie(in);
        }

        @Override
        public Faerie[] newArray(int size) {
            return new Faerie[0];
        }
    };

    public Faerie(Parcel input) {
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
