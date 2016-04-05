package com.kevinhodges.dragonborn.potion;

/**
 * Created by Kevin on 3/31/2016.
 */
public class Potion {

    private final String[] potionTypes = {"InvisibilityPotion", "EvasionPotion", "Mountain Hide", "Lasting Endurance", "Strength of Ikkor"};


    public String getPotionEffect(String potionName) {
       String potionEffect = "Empty";

       switch(potionName) {
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
}
