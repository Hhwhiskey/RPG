package com.kevinhodges.dragonborn.objects;

import java.util.Random;

/**
 * Created by Kevin on 4/1/2016.
 */
public class Armor {

    private int armor;
    private int cost;

    public Armor(int armorMultiplier) {
        this.armor = generateRandomArmorAmount(armorMultiplier);
        this.cost = generateArmorCost();
    }

    public int generateRandomArmorAmount(int armorMultiplier) {
        Random random = new Random();

        return random.nextInt((100 - 1) + 1) * (armorMultiplier);
    }

    public int generateArmorCost() {
        return armor * 100;
    }
}
