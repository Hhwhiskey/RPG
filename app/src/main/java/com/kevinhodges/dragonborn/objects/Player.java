package com.kevinhodges.dragonborn.objects;

import com.kevinhodges.dragonborn.races.Faerie;
import com.kevinhodges.dragonborn.races.Loken;
import com.kevinhodges.dragonborn.races.Risen;
import com.kevinhodges.dragonborn.races.Uman;

import java.util.ArrayList;

/**
 * Created by Kevin on 4/1/2016.
 */
public class Player {

    private static int uniquePlayerNumber = 0;
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


    public Player() {

    }





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

    public Player createNewPlayerWithRace(String newPlayerRace) {

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

       /* race = player.getRace();
        health = player.getHealth();
        stamina = player.getStamina();
        attackPower = player.getAttackPower();
        weaponDamage = player.getWeaponDamage();
        armor = player.getArmor();
        gold = player.getGold();
        daysLeft = player.getDaysLeft();
        leaguesLeft = player.getLeaguesLeft();
        weaponType = player.getWeaponType();*/

        //Increment the uniquePlayerId once player is created

    }
    public void heroic() {

    }

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
        return null;
    }

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
