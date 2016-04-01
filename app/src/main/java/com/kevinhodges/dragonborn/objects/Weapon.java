package com.kevinhodges.dragonborn.objects;

import com.kevinhodges.dragonborn.activities.CampActivity;

import java.util.Random;

/**
 * Created by Kevin on 3/31/2016.
 */
public class Weapon {

    private String weaponType;
    private final String[] umanRisenWeaponsArray = {"Dagger, 1-handed Sword, 2-handed Sword, 1-handed Axe, 2-handed Axe"};
    private final String[] lokenWeaponsArray = {"War Axe, War hammer, War Mace, Scythe, Polearm"};
    private final String[] faerieWeaponsArray = {"Staff, Wand, Scepter, Orb, Spellbook"};
    private final int weaponDamage;
    private final int weaponCost;
    private Player player;
    String playerRace = player.getRace();


    public Weapon() {

        CampActivity campActivity = new CampActivity();
        Player player = campActivity.getPlayer();
        playerRace = player.getRace();

        switch (playerRace) {
            case "Uman":
            case "Risen":
                this.weaponType = getRandomUmanRisenWeaponType();
                break;

            case "Loken":
                this.weaponType = getRandomLokenWeaponType();
                break;

            case "Faerie":
                this.weaponType = getRandomFaerieWeaponType();
                break;
        }

        this.weaponDamage = getRandomWeaponDamage();
        this.weaponCost = getWeaponCost();
    }

    public String getRandomUmanRisenWeaponType() {

        Random random = new Random();
        int randomRange = random.nextInt(4);

        return umanRisenWeaponsArray[randomRange];
    }

    public String getRandomLokenWeaponType() {

        Random random = new Random();
        int randomRange = random.nextInt(4);

        return lokenWeaponsArray[randomRange];
    }

    public String getRandomFaerieWeaponType() {

        Random random = new Random();
        int randomRange = random.nextInt(4);

        return faerieWeaponsArray[randomRange];
    }

    public int getRandomWeaponDamage() {

        Random random = new Random();

        return random.nextInt((100 - 1) + 1) * (10000 - player.getLeaguesLeft());
    }

    public int getWeaponCost() {

        return weaponDamage * 100;
    }
}
