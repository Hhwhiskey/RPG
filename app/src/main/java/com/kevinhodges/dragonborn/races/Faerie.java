package com.kevinhodges.dragonborn.races;

/**
 * Created by Kevin on 3/21/2016.
 */
public class Faerie extends Uman {

    private int health = 50;
    private int stamina = 100;
    private int attackPower = 200;
    private int armor = 10;
    private int gold = 10;

    private boolean massiveWeapons = false;
    private String trait = "2 attacks before taking any damage and cannot be ambushed, even while resting.";
    private String special = "Teleport - Gain distance and get 2 free attacks on same target";

    public Faerie() {

    }
}
