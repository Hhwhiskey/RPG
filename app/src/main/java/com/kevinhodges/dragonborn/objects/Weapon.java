package com.kevinhodges.dragonborn.objects;

/**
 * Created by Kevin on 3/31/2016.
 */
public class Weapon {

    private final String weaponName;
    private final String weaponType;
    private final int weaponDamage;
    private final int weaponCost;
    private final boolean isMassive;

    public Weapon(String weaponName, String weaponType, int weaponDamage, int weaponCost, boolean isMassive){
        this.weaponName = weaponName;
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
        this.weaponCost = weaponCost;
        this.isMassive = isMassive;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public int getWeaponCost() {
        return weaponCost;
    }

    public boolean isMassive() {
        return isMassive;
    }
}
