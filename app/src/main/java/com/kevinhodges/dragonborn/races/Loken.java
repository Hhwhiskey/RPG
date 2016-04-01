package com.kevinhodges.dragonborn.races;

import com.kevinhodges.dragonborn.objects.Player;

/**
 * Created by Kevin on 3/21/2016.
 */
public class Loken extends Player {

    private int health = 100;
    private int stamina = 100;
    private int armor = 10;
    private int attackPower = 200;
    private int weaponDamage = 10;
    private int gold = 10;
    private int daysLeft = 400;
    private int leaguesLeft = 10000;
    private String weaponType = "War Axe";

    private String trait = "Massive weapons and misses don't use stamina.";
    private String special = "Execute - Finish off an enemy that has less than 50% health left.";

    public Loken() {

    }
}
