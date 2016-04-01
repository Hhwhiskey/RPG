package com.kevinhodges.dragonborn.races;

import com.kevinhodges.dragonborn.objects.Player;

/**
 * Created by Kevin on 3/21/2016.
 */
public class Risen extends Player {

    private int health = 100;
    private int stamina = 200;
    private int armor = 10;
    private int attackPower = 50;
    private int weaponDamage = 10;
    private int gold = 10;
    private int daysLeft = 400;
    private int leaguesLeft = 10000;
    private String weaponType = "Dagger";

    private String trait = "Very high stamina.";
    private String special = "Drain life - Drain your strong attack amount from enemy and fill your health.";


    public Risen () {

    }

    @Override
    public void buyArmor(int cost, int armorGained) {
        super.buyArmor(cost, armorGained);

        gold -= cost;
        armor += (armorGained * 2);
    }
}
