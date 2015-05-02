package com.example.elise.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class SecondActivity extends Activity {

    //Variables
    TextView name;
    TextView type;
    TextView alignment;
    TextView ac;
    TextView hp;
    TextView speed;
    TextView str;
    TextView dex;
    TextView con;
    TextView wis;
    TextView intel;
    TextView cha;
    TextView skills;
    TextView savingThrows;
    TextView damageImmunities;
    TextView damageResistance;
    TextView conditionImmunities;
    TextView senses;
    TextView languages;
    TextView challenge;
    TextView actions;
    TextView special;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_monster);

        //Mapping views
        name = (TextView) findViewById(R.id.tvName);
        type = (TextView) findViewById(R.id.tvType);
        alignment = (TextView) findViewById(R.id.tvAlignment);
        ac = (TextView) findViewById(R.id.tvAC);
        hp = (TextView) findViewById(R.id.tvHP);
        speed = (TextView) findViewById(R.id.tvSpeed);
        str = (TextView) findViewById(R.id.tvSTRscore);
        dex = (TextView) findViewById(R.id.tvDEXscore);
        con = (TextView) findViewById(R.id.tvCONscore);
        wis = (TextView) findViewById(R.id.tvWISscore);
        intel = (TextView) findViewById(R.id.tvINTscore);
        cha = (TextView) findViewById(R.id.tvCHAscore);
        skills = (TextView) findViewById(R.id.tvSkills);
        savingThrows = (TextView) findViewById(R.id.tvSavingThrows);
        damageImmunities = (TextView) findViewById(R.id.tvDamageImmunities);
        damageResistance = (TextView) findViewById(R.id.tvDamageResistance);
        conditionImmunities = (TextView) findViewById(R.id.tvConditionImmunities);
        senses = (TextView) findViewById(R.id.tvSenses);
        languages = (TextView) findViewById(R.id.tvLang);
        challenge = (TextView) findViewById(R.id.tvChallenge);
        actions = (TextView) findViewById(R.id.tvActions);
        special = (TextView) findViewById(R.id.tvSpecial);


        //Assign values from the monsters list to the views
        name.setText(getIntent().getStringExtra("name"));
        type.setText(getIntent().getStringExtra("type"));
        alignment.setText(getIntent().getStringExtra("alignment"));
        ac.setText("AC: "+getIntent().getStringExtra("ac"));
        hp.setText("HP: "+getIntent().getStringExtra("hp"));
        speed.setText("Speed: "+getIntent().getStringExtra("speed")+" ft.");
        str.setText(getIntent().getStringExtra("str"));
        dex.setText(getIntent().getStringExtra("dex"));
        con.setText(getIntent().getStringExtra("con"));
        wis.setText(getIntent().getStringExtra("wis"));
        intel.setText(getIntent().getStringExtra("intel"));
        cha.setText(getIntent().getStringExtra("cha"));
        skills.setText("Skills: "+getIntent().getStringExtra("skills"));
        savingThrows.setText("Saving Throws: "+ getIntent().getStringExtra("savingThrows"));
        damageImmunities.setText("Damage Immunities: "+getIntent().getStringExtra("damageImmunities"));
        damageResistance.setText("Damage Resistance: "+getIntent().getStringExtra("damageResistance"));
        conditionImmunities.setText("Condition Immunities: "+getIntent().getStringExtra("conditionImmunities"));
        senses.setText("Senses: "+getIntent().getStringExtra("senses"));
        languages.setText("Languages: "+getIntent().getStringExtra("languages"));
        challenge.setText("Challenge: "+getIntent().getStringExtra("challenge")+" XP");
        actions.setText("Actions: "+getIntent().getStringExtra("actions"));
        special.setText("Special: "+getIntent().getStringExtra("special"));

    }

}
