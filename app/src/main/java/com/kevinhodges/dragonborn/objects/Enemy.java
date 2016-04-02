package com.kevinhodges.dragonborn.objects;

import java.util.Random;

/**
 * Created by Kevin on 3/21/2016.
 */
public class Enemy {

    private final String race;
    private final String[] randomRaceArray = {"Uman", "Faerie", "Loken", "Risen", "Welp", "Demon", "Giant", "Troll", "Bat", "Bore", "Yeti", "Bear", "Imp"};
    private final int damageMin;
    private final int damageMax;
    private final int health;
    private final int stamina;
    private final int armor;

    public Enemy(int damageMin, int damageMax) {
        this.race = generateRandomRace();
        this.health = generateRandomHealth();
        this.stamina = generateRandomStamina();
        this.armor = generateRandomArmor();
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }

    public String generateRandomRace() {

        Random random = new Random();
        int randomRange = random.nextInt(12);

        return randomRaceArray[randomRange];
    }

    public int generateRandomHealth() {

        Random random = new Random();

        return random.nextInt(100 - 50) + 50;
    }

    public int generateRandomStamina() {

        Random random = new Random();

        return random.nextInt(100 - 50) + 50;
    }

    public int generateRandomArmor() {

        Random random = new Random();

        return random.nextInt(50 - 10) + 10;
    }

    public int generateEnemyDamage() {

        Random random = new Random();

        return random.nextInt(damageMax - damageMin) + damageMin;
    }
}
