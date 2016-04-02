package com.kevinhodges.dragonborn.races;

import com.kevinhodges.dragonborn.objects.Player;

/**
 * Created by Kevin on 3/21/2016.
 */
public class Faerie extends Player {

    private int health = 50;
    private int stamina = 100;
    private int armor = 10;
    private int attackPower = 200;
    private int weaponDamage = 10;
    private int gold = 10;
    private int daysLeft = 400;
    private int leaguesLeft = 10000;
    private String weaponType = "Staff";

    private String trait = "2 attacks before taking any damage and cannot be damaged from an ambush, even while resting.";
    private String special = "Teleport - Instead of attacking this turn, dodge the enemies attack, and you get 3 attacks next turn";

    public Faerie() {

    }

    @Override
    public void heroic() {

    }
}
