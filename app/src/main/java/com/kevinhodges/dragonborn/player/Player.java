package com.kevinhodges.dragonborn.player;

import android.os.Parcelable;

import com.kevinhodges.dragonborn.blacksmith.Armor;
import com.kevinhodges.dragonborn.blacksmith.Weapon;
import com.kevinhodges.dragonborn.potion.Potion;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kevin on 4/1/2016.
 */
public abstract class Player implements Parcelable {

    public abstract void heroic();
    public ArrayList<Weapon> weaponInventory;
    public ArrayList<Armor> armorInventory;
    public ArrayList<Potion> potionInventory;

    //Gold///////////////////////////////////////////////////////////////////////////////////////
    public void spendPlayerGold(int amount) {
        int playerGold = getGold();
        playerGold -= amount;

        setGold(playerGold);
    }

    //Health///////////////////////////////////////////////////////////////////////////////////
    public int healPlayerToFull() {
        String playerRace = getRace();

        switch(playerRace) {
            case "Uman":
                 setHealth(200);
                 break;

            case "Faerie":
                 setHealth(50);
                 break;

            case "Loken":
                 setHealth(100);
                 break;

            case "Risen":
                 setHealth(100);
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

        ArrayList <Weapon> weaponObjectsArray = new ArrayList<>();
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

        switch(race) {
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
