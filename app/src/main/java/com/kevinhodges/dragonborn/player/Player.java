package com.kevinhodges.dragonborn.player;

import android.os.Parcelable;

import com.kevinhodges.dragonborn.blacksmith.Armor;
import com.kevinhodges.dragonborn.blacksmith.Weapon;
import com.kevinhodges.dragonborn.potion.Potion;

import java.util.ArrayList;

/**
 * Created by Kevin on 4/1/2016.
 */
public abstract class Player implements Parcelable {

    public abstract void heroic();


    //Attacks////////////////////////////////////////////////////////////////////////////////////
    public int weakAttack(int attackPower, int weaponDamage) {

        int weakAttack = (attackPower / 10) * weaponDamage;

        weakAttack /= 2;

        return weakAttack;
    }

    public int mediumAttack(int attackPower, int weaponDamage) {

        int mediumAttack = (attackPower / 10) * weaponDamage;

        mediumAttack /= 1.33;

        return mediumAttack;
    }

    public int strongAttack(int attackPower, int weaponDamage) {

        return (attackPower / 10) * weaponDamage;
    }

    //Weapons///////////////////////////////////////////////////////////////////////
    public ArrayList<String> generateBlacksmithWeaponList(String race, int leaguesLeft) {

        int weaponMultiplier = ((10000 - leaguesLeft) / 100) + 1;

        Weapon weapon1 = new Weapon(race, weaponMultiplier);
        Weapon weapon2 = new Weapon(race, weaponMultiplier);
        Weapon weapon3 = new Weapon(race, weaponMultiplier);
        Weapon weapon4 = new Weapon(race, weaponMultiplier);
        Weapon weapon5 = new Weapon(race, weaponMultiplier);

        Weapon[] weaponObjectsArray = {weapon1, weapon2, weapon3, weapon4, weapon5};
        ArrayList<String> weaponList = new ArrayList<>();

        for (Weapon weapon : weaponObjectsArray) {
            String weaponType = weapon.weaponType;
            String weaponDamage = String.valueOf(weapon.weaponDamage);
            String weaponCost = String.valueOf(weapon.weaponCost);

            weaponList.add(weaponType);
            weaponList.add(weaponDamage);
            weaponList.add(weaponCost);
        }

        return weaponList;
    }

    // TODO: 4/1/2016  Pass WeaponObject that is clicked to the buy dialog then add it to inventory
    public Weapon buyWeapon(Weapon weapon) {
      return null;
    }

    public Weapon equipWeapon(Weapon weapon) {
        return null;
    }



    //Armor////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Integer> generateBlackSmithArmorList(boolean isUman, int leaguesLeft) {

        int armorMultiplier = ((10000 - leaguesLeft) / 100) + 1;

        Armor armor1 = new Armor(isUman, armorMultiplier);
        Armor armor2 = new Armor(isUman, armorMultiplier);
        Armor armor3 = new Armor(isUman, armorMultiplier);
        Armor armor4 = new Armor(isUman, armorMultiplier);
        Armor armor5 = new Armor(isUman, armorMultiplier);

        Armor[] armorObjectsArray = {armor1, armor2, armor3, armor4, armor5};
        ArrayList armorList = new ArrayList();

        for (Armor armor : armorObjectsArray) {
            int armorAmount = armor.getArmor();
            int armorCost = armor.getCost();

            armorList.add(armorAmount);
            armorList.add(armorCost);
        }

        return armorList;
    }

    // Armor is auto equipped
    public void buyArmor(int cost, int armorAmount, int gold, int armor) {
        gold -= cost;
        armor += armorAmount;
    }

    //Potions///////////////////////////////////////////////////////////////////////////

    public ArrayList<Potion> generatePotionList() {
        return null;
    }

    //Getters///////////////////////////////////////////////////////////////////////////
//    public String getRace() {
//        return race;
//    }

    public abstract String getRace();

    public abstract int getHealth();


    public abstract int getStamina();


    public abstract int getAttackPower();


    public abstract int getWeaponDamage();


    public abstract int getArmor();


    public abstract int getGold();


    public abstract int getDaysLeft();


    public abstract int getLeaguesLeft();


    public abstract String getWeaponType();

}
