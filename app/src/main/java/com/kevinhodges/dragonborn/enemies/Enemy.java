package com.kevinhodges.dragonborn.enemies;

/**
 * Created by Kevin on 3/21/2016.
 */
public class Enemy {

    private int health;
    private int stamina;
    private int strength;
    private int intelligence;
    private int stealth;
    private int luck;

    public Enemy(int health, int stamina, int strength, int intelligence, int stealth, int luck) {
        this.health = health;
        this.stamina = stamina;
        this.strength = strength;
        this.intelligence = intelligence;
        this.stealth = stealth;
        this.luck = luck;
    }
}
