package com.kevinhodges.dragonborn.player;

import android.app.Activity;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import com.kevinhodges.dragonborn.activities.MainActivity;
import com.kevinhodges.dragonborn.blacksmith.Armor;
import com.kevinhodges.dragonborn.blacksmith.Weapon;
import com.kevinhodges.dragonborn.potion.Potion;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kevin on 4/1/2016.
 */
public abstract class Player implements Parcelable {

    private static final String TAG = "Player";
    private MainActivity mainActivity;

    public abstract void heroic();

    public ArrayList<Weapon> weaponInventory;
    public ArrayList<Armor> armorInventory;
    public ArrayList<Potion> potionInventory = new ArrayList<>();

    //Gold///////////////////////////////////////////////////////////////////////////////////////
    public void spendPlayerGold(Activity activity, int amount) {

        int playerGold = getGold();

        if (amount <= playerGold) {
            playerGold -= amount;

            setGold(playerGold);

            mainActivity = (MainActivity) activity;
            mainActivity.updateGoldTextView(playerGold);

        } else {
            Toast.makeText(activity, "You do not have enough gold", Toast.LENGTH_SHORT).show();
        }
    }

    //Health///////////////////////////////////////////////////////////////////////////////////
    public int healPlayerToFull(Activity activity) {

        mainActivity = (MainActivity) activity;

        String playerRace = getRace();

        switch (playerRace) {
            case "Uman":
                setHealth(200);
                mainActivity.updateHealthTextView(200);
                break;

            case "Faerie":
                setHealth(50);
                mainActivity.updateHealthTextView(50);
                break;

            case "Loken":
                setHealth(100);
                mainActivity.updateHealthTextView(100);
                break;

            case "Risen":
                setHealth(100);
                mainActivity.updateHealthTextView(100);
                break;
        }

        return getHealth();
    }

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
    public ArrayList<Weapon> generateBlacksmithWeaponList(String race, int leaguesLeft) {

        int weaponMultiplier = ((10000 - leaguesLeft) / 1000) + 1;

        Weapon weapon1 = new Weapon(race, weaponMultiplier);
        Weapon weapon2 = new Weapon(race, weaponMultiplier);
        Weapon weapon3 = new Weapon(race, weaponMultiplier);
        Weapon weapon4 = new Weapon(race, weaponMultiplier);
        Weapon weapon5 = new Weapon(race, weaponMultiplier);

        ArrayList<Weapon> weaponObjectsArray = new ArrayList<>();
        weaponObjectsArray.add(weapon1);
        weaponObjectsArray.add(weapon2);
        weaponObjectsArray.add(weapon3);
        weaponObjectsArray.add(weapon4);
        weaponObjectsArray.add(weapon5);
//        ArrayList<Weapon> weaponList = new ArrayList<>();

//        for (Weapon weapon : weaponObjectsArray) {
//            Weapon weaponType = weapon.weaponType;
//            String weaponDamage = String.valueOf(weapon.weaponDamage);
//            String weaponCost = String.valueOf(weapon.weaponCost);
//
//            weaponList.add(weaponType);
//            weaponList.add(weaponDamage);
//            weaponList.add(weaponCost);
//        }

        return weaponObjectsArray;
    }

    // TODO: 4/1/2016  Pass WeaponObject that is clicked to the buy dialog then add it to inventory
    public Weapon buyWeapon(Weapon weapon) {
        return null;
    }

    public void addWeaponToInventory(Weapon weapon) {
        weaponInventory.add(weapon);
    }


    //Armor////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Armor> generateBlacksmithArmorList(String race, int leaguesLeft) {

        boolean isUman = false;

        if (race.equals("Uman")) {
            isUman = true;
        }

        int armorMultiplier = ((10000 - leaguesLeft) / 100) + 1;

        Armor armor1 = new Armor(isUman, armorMultiplier);
        Armor armor2 = new Armor(isUman, armorMultiplier);
        Armor armor3 = new Armor(isUman, armorMultiplier);
        Armor armor4 = new Armor(isUman, armorMultiplier);
        Armor armor5 = new Armor(isUman, armorMultiplier);

        ArrayList<Armor> armorObjectsArray = new ArrayList<>();
        armorObjectsArray.add(armor1);
        armorObjectsArray.add(armor2);
        armorObjectsArray.add(armor3);
        armorObjectsArray.add(armor4);
        armorObjectsArray.add(armor5);

        return armorObjectsArray;
    }

    // Armor is auto equipped
    public void buyArmor(int armorAmount) {
        armorAmount += armorAmount;
    }

    //Potions///////////////////////////////////////////////////////////////////////////
    public void addPotionToInventory(Potion potionType) {
        potionInventory.add(potionType);
        for (Potion potion : potionInventory) {
            Log.d(TAG, "addPotionToInventory: Amount of Potions in inventory : " + potion.getPotionName());
        }
        Log.d(TAG, "////////////////////////////////////////////////////////////////////////////");
    }

    public void subtractDaysLeft(int amountOfDays) {
        int daysLeft = getDaysLeft();
        daysLeft -= amountOfDays;
        setDaysLeft(daysLeft);
    }

    // This method will return a random number between 2 two passed parameters, inclusive
    public static int randomInteger(int min, int max) {

        Random rand = new Random();

        // nextInt excludes the top value so we have to add 1 to include the top value
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    //Abstract Getters///////////////////////////////////////////////////////////////////////////
    public abstract String getRace();

    public abstract String getWeaponType();

    public abstract int getHealth();

    public abstract int getStamina();

    public abstract int getAttackPower();

    public abstract int getWeaponDamage();

    public abstract int getArmor();

    public abstract int getGold();

    public abstract int getDaysLeft();

    public abstract int getLeaguesLeft();

    public ArrayList<Weapon> getWeaponInventory() {
        return weaponInventory;
    }


    public int getMaxHealth() {
        String race = getRace();

        int health = 0;

        switch (race) {
            case "Uman":
                health = 200;
                break;

            case "Faerie":
                health = 50;
                break;

            case "Loken":
                health = 100;
                break;

            case "Risen":
                health = 100;
                break;
        }
        return health;
    }

    // Abstract Setters/////////////////////////////////////////////////////////////////////////////
    public abstract void setRace(String race);

    public abstract void setWeaponType(String weaponType);

    public abstract void setHealth(int health);

    public abstract void setStamina(int stamina);

    public abstract void setAttackPower(int attackPower);

    public abstract void setWeaponDamage(int weaponDamage);

    public abstract void setArmor(int armor);

    public abstract void setGold(int gold);

    public abstract void setDaysLeft(int daysLeft);

    public abstract void setLeaguesLeft(int leaguesLeft);


}
