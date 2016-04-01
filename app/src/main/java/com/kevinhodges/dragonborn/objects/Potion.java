package com.kevinhodges.dragonborn.objects;

/**
 * Created by Kevin on 3/31/2016.
 */
public class Potion {

    private final String potionName;
    private final int potionCost;

    public Potion(String potionName, String potionEffect, int potionCost) {
        this.potionName = potionName;
        this.potionCost = potionCost;
    }

    public String getPotionName() {
        return potionName;
    }

    public int getPotionCost() {
        return potionCost;
    }

    public String getPotionEffect(String potionName) {
       String potionEffect = "Empty";

       switch(potionName) {
           case "Invisibility":
                potionEffect = "Rest one night without the chance of being detected";
                break;

           case "Evasion":
                potionEffect = "Enemies are twice as likely to miss you for the remainder of this fight.";
                break;

           case "Mountain Hide":
                potionEffect = "Double your armor for the remainder of this fight";
                break;

           case "Lasting Endurance":
                potionEffect = "Replenish 25 stamina";
                break;

           case "Strength of Ikkor":
                potionEffect = "Double your damage for the remainder of this fight";
                break;
       }

        return potionEffect;
    }
}
