package com.kevinhodges.dragonborn.blacksmith;

import java.util.Random;

/**
 * Created by Kevin on 4/1/2016.
 */
public class Armor {

    private String[] armorTypeArray = {"Helm", "Shoulders", "Chest", "Pants", "Boots", "Bracers", "Gloves"};
    public String armorType;
    public int armorAmount;
    public int armorCost;

    public Armor(boolean isUman, int armorMultiplier) {
        this.armorType = generateRandomArmorType();
        this.armorAmount = generateRandomArmorAmount(isUman, armorMultiplier);
        this.armorCost = generateArmorCost(isUman);
    }

    public String generateRandomArmorType() {

        Random random = new Random();
        int randomRange = random.nextInt(6);

        return armorTypeArray[randomRange];
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

            return armorAmount * 6;

        } else {

            return armorAmount * 12;
        }
    }

    public String getArmorType() {
        return armorType;
    }

    public int getArmorAmount() {
        return armorAmount;
    }

    public int getCost() {
        return armorCost;
    }
}
