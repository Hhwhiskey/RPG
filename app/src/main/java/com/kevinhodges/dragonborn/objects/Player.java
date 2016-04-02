package com.kevinhodges.dragonborn.objects;

import com.kevinhodges.dragonborn.activities.RaceSelectActivity;

import java.util.ArrayList;

/**
 * Created by Kevin on 4/1/2016.
 */
public abstract class Player {

    RaceSelectActivity raceSelectActivity = new RaceSelectActivity();

    private String race;
    private int health;
    private int stamina;
    private int attackPower;
    private int weaponDamage;
    private int armor;
    private int gold;
    private int daysLeft;
    private int leaguesLeft;
    private String weaponType;
    private Player player;
    private static int uniquePlayerNumber = 0;



    /*public Player() {

        race = raceSelectActivity.player.getRace();
        health = raceSelectActivity.player.getHealth();
        stamina = raceSelectActivity.player.getStamina();
        attackPower = raceSelectActivity.player.getAttackPower();
        weaponDamage = raceSelectActivity.player.getWeaponDamage();
        armor = raceSelectActivity.player.getArmor();
        gold = raceSelectActivity.player.getGold();
        daysLeft = raceSelectActivity.player.getDaysLeft();
        leaguesLeft = raceSelectActivity.player.getLeaguesLeft();
        weaponType = raceSelectActivity.player.getWeaponType();
    }*/





   /* public Player(String race, int health, int stamina, int attackPower, int weaponDamage, int armor, int daysLeft, int leaguesLeft, String currentWeapon) {
        this.race = race;
        this.health = health;
        this.stamina = stamina;
        this.attackPower = attackPower;
        this.weaponDamage = weaponDamage;
        this.armor = armor;
        this.daysLeft = daysLeft;
        this.leaguesLeft = leaguesLeft;
        this.currentWeapon = currentWeapon;
    }*/

    /*public Player createNewPlayerWithRace(String newPlayerRace) {

        if (newPlayerRace.equals("Uman")) {
             player = new Uman();

        } else if (newPlayerRace.equals("Faerie")) {
             player = new Faerie();

        } else if (newPlayerRace.equals("Loken")) {
             player = new Loken();

        } else if (newPlayerRace.equals("Risen")) {
             player = new Risen();
        }

        uniquePlayerNumber++;
        return player;

       *//* race = player.getRace();
        health = player.getHealth();
        stamina = player.getStamina();
        attackPower = player.getAttackPower();
        weaponDamage = player.getWeaponDamage();
        armor = player.getArmor();
        gold = player.getGold();
        daysLeft = player.getDaysLeft();
        leaguesLeft = player.getLeaguesLeft();
        weaponType = player.getWeaponType();*//*

        //Increment the uniquePlayerId once player is created

    }*/

    public abstract void heroic();


    public int weakAttack() {

        int weakAttack = (attackPower / 10) * weaponDamage;

        weakAttack /= 2;

        return weakAttack;
    }

    public int mediumAttack() {

        int mediumAttack = (attackPower / 10) * weaponDamage;

        mediumAttack /= 1.33;

        return mediumAttack;
    }

    public int strongAttack() {

        return (attackPower / 10) * weaponDamage;
    }

    public void usePotion() {

    }

    //Weapons///////////////////////////////////////////////////////////////////////
    public ArrayList<String> getBlackSmithWeaponList() {
/*
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
        }*/

        return null;
    }

    // TODO: 4/1/2016  Pass WeaponObject that is clicked to the buy dialog then add it to inventory
    public Weapon buyWeapon(Weapon weapon) {
      return null;
    }

    public Weapon equipWeapon(Weapon weapon) {
        return null;
    }



    //Armor////////////////////////////////////////////////////////////////////////////////
    public Armor[] getBlackSmithArmorList() {
        return null;
    }

    // Armor is auto equipped
    public void buyArmor(int cost, int armorAmount) {
        gold -= cost;
        armor += armorAmount;
    }



    //Getters///////////////////////////////////////////////////////////////////////////
    public String getRace() {
        return race;
    }

    public int getHealth() {
        return health;
    }

    public int getStamina() {
        return stamina;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public int getArmor() {
        return armor;
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

    public String getWeaponType() {
        return weaponType;
    }
}
