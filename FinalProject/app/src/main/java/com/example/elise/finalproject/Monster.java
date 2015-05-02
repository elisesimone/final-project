package com.example.elise.finalproject;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class Monster {

    //Attributes
    private String name;
    private String type;
    private String alignment;
    private int ac;
    private int hp;
    private int speed;
    private int str;
    private int dex;
    private int con;
    private int intel;
    private int wis;
    private int cha;
    private String skills;
    private String savingThrows;
    private String damageImmunities;
    private String damageResistance;
    private String conditionImmunities;
    private String senses;
    private String languages;
    private int challenge;
    private ArrayList actions;
    private ArrayList special;

    //Constructor
    public Monster(String name, String type, String alignment, int ac,
                   int hp, int speed, int str, int dex, int con, int intel,
                   int wis, int cha, String skills, String savingThrows,
                   String damageImmunities, String damageResistance,
                   String conditionImmunities, String senses,
                   String languages, int challenge, ArrayList actions,
                   ArrayList special){
        this.name = name;
        this.type = type;
        this.alignment = alignment;
        this.ac = ac;
        this.hp = hp;
        this.speed = speed;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.intel = intel;
        this.wis = wis;
        this.cha = cha;
        this.skills = skills;
        this.savingThrows = savingThrows;
        this.damageImmunities = damageImmunities;
        this.damageResistance = damageResistance;
        this.conditionImmunities = conditionImmunities;
        this.senses = senses;
        this.languages = languages;
        this.challenge = challenge;
        this.actions = actions;
        this.special = special;
    }

    //Getters
    public String getName(){
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAlignment() {
        return alignment;
    }

    public int getAc(){
        return ac;
    }

    public int getHp(){
        return hp;
    }

    public int getSpeed(){
        return speed;
    }

    public int getStr(){
        return str;
    }

    public int getDex(){
        return dex;
    }
    public int getCon(){
        return con;
    }

    public int getIntel(){
        return intel;
    }

    public int getWis(){
        return wis;
    }

    public int getCha(){
        return cha;
    }

    public String getSkills(){
        return skills;
    }

    public String getSavingThrows(){
        return savingThrows;
    }

    public String getDamageImmunities(){
        return damageImmunities;
    }

    public String getDamageResistance(){
        return damageResistance;
    }

    public String getConditionImmunities(){
        return conditionImmunities;
    }

    public String getSenses(){
        return senses;
    }

    public String getLanguages(){
        return languages;
    }

    public int getChallenge(){
        return challenge;
    }

    public ArrayList getActions(){
        return actions;
    }

    public ArrayList getSpecial(){
        return special;
    }

}
