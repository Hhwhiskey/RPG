package com.kevinhodges.dragonborn.blacksmith;

import com.kevinhodges.dragonborn.player.Player;

import java.util.Random;

/**
 * Created by Kevin on 3/31/2016.
 */
public class Weapon {

    private static final String TAG = "Weapon";
    public String weaponType;
    public final int weaponDamage;
    public final int weaponCost;
    public boolean isLoken = false;
    private final String[] umanRisenWeaponsArray = {"Dagger", "1-handed Sword", "2-handed Sword", "1-handed Axe", "2-handed Axe"};
    private final String[] lokenWeaponsArray = {"War Axe", "War hammer", "War Mace", "Scythe", "Polearm"};
    private final String[] faerieWeaponsArray = {"Staff", "Wand", "Scepter", "Orb", "Spellbook"};



    public Weapon(String playerRace, int weaponMultiplier) {

        switch (playerRace) {
            case "Uman":
            case "Risen":
                this.weaponType = generateRandomUmanRisenWeaponType();
                break;

            case "Loken":
                this.weaponType = generateRandomLokenWeaponType();
                isLoken = true;
                break;

            case "Faerie":
                this.weaponType = generateRandomFaerieWeaponType();
                break;
        }

        this.weaponDamage = getRandomWeaponDamage(isLoken, weaponMultiplier);
        this.weaponCost = getWeaponCost(isLoken);
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
    public int getRandomWeaponDamage(boolean isLoken, int weaponMultiplier) {

        int damage = 0;

        if (isLoken) {
             damage = Player.randomInteger(50, 200);
        } else {
             damage = Player.randomInteger(25, 100);
        }

        return damage * weaponMultiplier;
    }

    public int getWeaponCost(boolean isLoken) {

        int weaponCost;

        if (isLoken) {
            weaponCost = weaponDamage * 2;
        } else {
            weaponCost = weaponDamage * 4;
        }

        return weaponCost;
    }
}
