package com.kevinhodges.dragonborn.blacksmith;

import java.util.Random;

/**
 * Created by Kevin on 3/31/2016.
 */
public class Weapon {

    private static final String TAG = "Weapon";
    public String weaponType;
    private final String[] umanRisenWeaponsArray = {"Dagger", "1-handed Sword", "2-handed Sword", "1-handed Axe", "2-handed Axe"};
    private final String[] lokenWeaponsArray = {"War Axe", "War hammer", "War Mace", "Scythe", "Polearm"};
    private final String[] faerieWeaponsArray = {"Staff", "Wand", "Scepter", "Orb", "Spellbook"};
    public final int weaponDamage;
    public final int weaponCost;


    public Weapon(String playerRace, int weaponMultiplier) {

        switch (playerRace) {
            case "Uman":
            case "Risen":
                this.weaponType = generateRandomUmanRisenWeaponType();
                break;

            case "Loken":
                this.weaponType = generateRandomLokenWeaponType();
                break;

            case "Faerie":
                this.weaponType = generateRandomFaerieWeaponType();
                break;
        }

        this.weaponDamage = getRandomWeaponDamage(weaponMultiplier);
        this.weaponCost = getWeaponCost();
    }

    public String generateRandomUmanRisenWeaponType() {

        Random random = new Random();
        int randomRange = random.nextInt(4);

        return umanRisenWeaponsArray[randomRange];
    }

    // Generate a random Loken weapon
    public String generateRandomLokenWeaponType() {

        Random random = new Random();
        int randomRange = random.nextInt(4);

        return lokenWeaponsArray[randomRange];
    }

    // Generate a random Faerie weapon
    public String generateRandomFaerieWeaponType() {

        Random random = new Random();
        int randomRange = random.nextInt(4);

        return faerieWeaponsArray[randomRange];
    }

    // Create a random weapon, then modify it with the players progress so it's just right.
    public int getRandomWeaponDamage(int weaponMultiplier) {

        Random random = new Random();

        return random.nextInt((100) * weaponMultiplier) + 1;
    }

    public int getWeaponCost() {

        return weaponDamage * 5;
    }
}
