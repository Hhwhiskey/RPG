package com.kevinhodges.dragonborn.races;

import android.os.Parcel;
import android.os.Parcelable;

import com.kevinhodges.dragonborn.objects.Player;

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




   /* @Override
    public int weakAttack() {
        super.weakAttack();

        int weakAttack = (attackPower / 10) * weaponDamage;

        weakAttack /= 2;

        return weakAttack;
    }

    @Override
    public int mediumAttack() {
        super.mediumAttack();

        int mediumAttack = (attackPower / 10) * weaponDamage;

        mediumAttack /= 1.33;

        return mediumAttack;
    }

    @Override
    public int strongAttack() {
        super.strongAttack();

        return (attackPower / 10) * weaponDamage;
    }

    //Weapons////////////////////////////////////////////////////////////////////////////////
    @Override
    public ArrayList<String> generateBlacksmithWeaponList() {
        super.generateBlacksmithWeaponList();

        int weaponMultiplier = ((10000 - leaguesLeft) / 100) + 1;

        Weapon weapon1 = new Weapon(race, weaponMultiplier);
        Weapon weapon2 = new Weapon(race, weaponMultiplier);
        Weapon weapon3 = new Weapon(race, weaponMultiplier);
        Weapon weapon4 = new Weapon(race, weaponMultiplier);
        Weapon weapon5 = new Weapon(race, weaponMultiplier);

        Weapon[] weaponObjectsArray = {weapon1, weapon2, weapon3, weapon4, weapon5};
        ArrayList<String> weaponDetailsList = new ArrayList<>();

        for (Weapon weapon : weaponObjectsArray) {
            String weaponType = weapon.weaponType;
            String weaponDamage = String.valueOf(weapon.weaponDamage);
            String weaponCost = String.valueOf(weapon.weaponCost);

            weaponDetailsList.add(weaponType);
            weaponDetailsList.add(weaponDamage);
            weaponDetailsList.add(weaponCost);
        }

        return weaponDetailsList;
    }

    // TODO: 4/1/2016  Pass WeaponObject that is clicked to the buy dialog then add it to inventory
    @Override
    public Weapon buyWeapon(Weapon weapon) {
        return super.buyWeapon(weapon);
    }

    @Override
    public Weapon equipWeapon(Weapon weapon) {
        return super.equipWeapon(weapon);
    }


    //Armor//////////////////////////////////////////////////////////////////////////
    @Override
    public Armor[] getBlackSmithArmorList() {
        super.getBlackSmithArmorList();

        int armorMultiplier = (10000 - leaguesLeft) / 100;

        Armor armor1 = new Armor(armorMultiplier);
        Armor armor2 = new Armor(armorMultiplier);
        Armor armor3 = new Armor(armorMultiplier);
        Armor armor4 = new Armor(armorMultiplier);
        Armor armor5 = new Armor(armorMultiplier);

        return new Armor[]{armor1, armor2, armor3, armor4, armor5};
    }

    // Armor is auto equipped
    @Override
    public void buyArmor(int cost, int armorGained) {
        super.buyArmor(cost, armorGained);

        gold -= cost;
        armor += (armorGained * 2);
    }*/


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
