package com.example.elise.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class SecondActivity extends Activity {

    //Variables
    TextView name;
    TextView challenge;
    TextView type;
    TextView ac;
    TextView hp;
    TextView speed;
    TextView str;
    TextView dex;
    TextView con;
    TextView wis;
    TextView intel;
    TextView cha;
    TextView alignment;
    TextView skills;
    TextView savingThrows;
    TextView damageImmunities;
    TextView damageResistances;
    TextView conditionImmunities;
    TextView senses;
    TextView languages;
    TextView actions;
    TextView special;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_monster);

        //Request instance of SharedPreferences
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);

        //Mapping views for when user is brought to page with more information
        name = (TextView) findViewById(R.id.tvName);
        challenge = (TextView) findViewById(R.id.tvCR);
        type = (TextView) findViewById(R.id.tvType);
        ac = (TextView) findViewById(R.id.tvAC);
        hp = (TextView) findViewById(R.id.tvHP);
        speed = (TextView) findViewById(R.id.tvSpeed);
        str = (TextView) findViewById(R.id.tvSTRscore);
        dex = (TextView) findViewById(R.id.tvDEXscore);
        con = (TextView) findViewById(R.id.tvCONscore);
        wis = (TextView) findViewById(R.id.tvWISscore);
        intel = (TextView) findViewById(R.id.tvINTscore);
        cha = (TextView) findViewById(R.id.tvCHAscore);
        alignment = (TextView) findViewById(R.id.tvAlignment);
        skills = (TextView) findViewById(R.id.tvSkills);
        savingThrows = (TextView) findViewById(R.id.tvSavingThrows);
        damageImmunities = (TextView) findViewById(R.id.tvDamageImmunities);
        damageResistances = (TextView) findViewById(R.id.tvDamageResistances);
        conditionImmunities = (TextView) findViewById(R.id.tvConditionImmunities);
        senses = (TextView) findViewById(R.id.tvSenses);
        languages = (TextView) findViewById(R.id.tvLang);
        actions = (TextView) findViewById(R.id.tvActions);
        special = (TextView) findViewById(R.id.tvSpecial);

        //Assign values from the monsters list to the views
        name.setText(getIntent().getStringExtra("name"));
        challenge.setText("Challenge: "+getIntent().getStringExtra("challenge")+" XP");
        alignment.setText(getIntent().getStringExtra("alignment"));
        type.setText(getIntent().getStringExtra("type"));
        ac.setText("AC: "+getIntent().getStringExtra("ac"));
        hp.setText("HP: "+getIntent().getStringExtra("hp"));
        speed.setText("Speed: "+getIntent().getStringExtra("speed")+" ft.");
        str.setText(""+getIntent().getStringExtra("str"));
        dex.setText(""+getIntent().getStringExtra("dex"));
        con.setText(""+getIntent().getStringExtra("con"));
        wis.setText(""+getIntent().getStringExtra("wis"));
        intel.setText(""+getIntent().getStringExtra("intel"));
        cha.setText(""+getIntent().getStringExtra("cha"));
        skills.setText("Skills: "+getIntent().getStringExtra("skills"));
        savingThrows.setText("Saving Throws: "+getIntent().getStringExtra("savingThrows"));
        damageImmunities.setText("Damage Immunities: "+getIntent().getStringExtra("damageImmunities"));
        damageResistances.setText("Damage Resistances: "+ getIntent().getStringExtra("damageResistances"));
        senses.setText("Senses: "+getIntent().getStringExtra("senses"));
        languages.setText("Languages: "+getIntent().getStringExtra("languages"));
        actions.setText(getIntent().getStringExtra("actions"));
        special.setText(getIntent().getStringExtra("special"));

    }

}
