/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.goblintower.models;

import java.util.Random;

/**
 *
 * @author michaelrodriguez
 */
public class Hero {

    private static final Random myRandom = new Random();
    private int level;
    private int maxHP;
    private int currentHP;
    private int gold;
    private int steps;
    private int potions;

    private String name;

    public Hero() {
        this.maxHP = myRandom.nextInt(20 - 10) + 10;
        currentHP = maxHP;
    }

    public Hero(int gold, int potions) {
        this.maxHP = myRandom.nextInt(20 - 10) + 10;
        currentHP = maxHP;
        this.gold = gold;
        this.potions = potions;         
    }

    public int getLevel() {

        return (steps / 10) + 1;
    }

    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
