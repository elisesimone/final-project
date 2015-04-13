package com.example.elise.finalproject;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class Monster {

    //Attributes
    private String name;
    private Integer ac;
    private Integer hp;
    private Integer speed;
    private Integer str;
    private Integer dex;
    private Integer con;
    private Integer intel;
    private Integer wis;
    private Integer cha;
    private String skills;
    private String actions;

    //Constructor
    public Monster(String name, Integer ac, Integer hp, Integer speed,
                   Integer str, Integer dex, Integer con, Integer intel,
                   Integer wis, Integer cha, String skills, String actions){
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
        this.actions = actions;
    }

    //Getters
    public String getName(){
        return name;
    }

    public Integer getAc(){
        return ac;
    }

    public Integer getHp(){
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

    public String getActions(){
        return actions;
    }

}
