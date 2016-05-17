package com.kevinhodges.dragonborn.potion;

/**
 * Created by Kevin on 3/31/2016.
 */
public class Potion {

    private String potionName;
    private int potionCost;
    private String potionEffect;
    private int leaguesLeft;
    private final String[] potionTypes = {"InvisibilityPotion", "EvasionPotion", "Mountain Hide", "Lasting Endurance", "Strength of Ikkor"};

    public Potion(String potionName, int leaguesLeft) {
        this.potionName = potionName;
        this.leaguesLeft = leaguesLeft;
        this.potionCost = generatePotionCost();
    }

    public String getPotionEffect(String potionName) {
        String potionEffect = "Empty";

        switch (potionName) {
            case "InvisibilityPotion":
                potionEffect = "Rest one night without the chance of being detected or escape from battle";
                break;

            case "EvasionPotion":
                potionEffect = "Enemies are twice as likely to miss you for the remainder of the day.";
                break;

            case "Mountain Hide":
                potionEffect = "Double your armor for the remainder of the day";
                break;

            case "Lasting Endurance":
                potionEffect = "Replenish 25 stamina";
                break;

            case "Strength of Ikkor":
                potionEffect = "Double your damage for the remainder of the day";
                break;
        }

        return potionEffect;
    }

    public int generatePotionCost() {

        int potionCostMultiplier;

        switch (potionName) {
            case "Evasion Potion":
                potionCostMultiplier = (10010 - leaguesLeft);
                potionCost = potionCostMultiplier;
                break;

            case "Invisibility Potion":
                potionCostMultiplier = (10010 - leaguesLeft) * 10;
                potionCost = potionCostMultiplier;
                break;

            case "Lasting Endurance Potion":
                potionCostMultiplier = (10010 - leaguesLeft) * 5;
                potionCost = potionCostMultiplier;
                break;

            case "Mountain Hide Potion":
                potionCostMultiplier = (10010 - leaguesLeft);
                potionCost = potionCostMultiplier;
                break;

            case "Strength of Ikkor Potion":
                potionCostMultiplier = (10010 - leaguesLeft) * 3;
                potionCost = potionCostMultiplier;
                break;
        }

        return potionCost;
    }

    public int getPotionCost() {
        return potionCost;
    }

    public String getPotionName() {
        return potionName;
    }
}
