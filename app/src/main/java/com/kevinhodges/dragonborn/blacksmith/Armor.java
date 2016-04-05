package com.kevinhodges.dragonborn.blacksmith;

import java.util.Random;

/**
 * Created by Kevin on 4/1/2016.
 */
public class Armor {

    private int armor;
    private int cost;

    public Armor(boolean isUman, int armorMultiplier) {
        this.armor = generateRandomArmorAmount(isUman, armorMultiplier);
        this.cost = generateArmorCost(isUman);
    }

    public int generateRandomArmorAmount(boolean isUman, int armorMultiplier) {

        Random random = new Random();


        if (isUman) {
            return random.nextInt((100 - 1) + 1) * (armorMultiplier) * 2;

        } else {

            return random.nextInt((100 - 1) + 1) * (armorMultiplier);
        }
    }

    public int generateArmorCost(boolean isUman) {
        
        if (isUman) {

            return armor * 50;

        } else {

            return armor * 100;
        }
    }

    public int getArmor() {
        return armor;
    }

    public int getCost() {
        return cost;
    }
}
