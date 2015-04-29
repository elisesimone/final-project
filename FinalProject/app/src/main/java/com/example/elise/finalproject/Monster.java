package com.example.elise.finalproject;

import android.widget.TextView;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class Monster {

    //Attributes
    private String name;
    private String ac;
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
    private TextView actions;
    private TextView special;

    //Constructor
    public Monster(String name, String ac, int hp, int speed,
                   int str, int dex, int con, int intel,
                   int wis, int cha, String skills, String savingThrows,
                   String damageImmunities, String damageResistance,
                   String conditionImmunities, String senses,
                   String languages, int challenge, TextView actions,
                   TextView special){
        this.name = name;
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

    public String getAc(){
        return ac;
    }

    public int getHp(){
        return hp;
    }

    public Integer getSpeed(){
        return speed;
    }

    public Integer getStr(){
        return str;
    }

    public Integer getDex(){
        return dex;
    }
    public Integer getCon(){
        return con;
    }

    public Integer getIntel(){
        return intel;
    }

    public Integer getWis(){
        return wis;
    }

    public Integer getCha(){
        return cha;
    }

    public String getSkills(){
        return skills;
    }

    public TextView getActions(){
        return actions;
    }

}
