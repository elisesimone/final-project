package com.example.elise.finalproject;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class SecondActivity extends ActionBarActivity {

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
    ArrayList actionArray;
    ArrayList specialArray;
    String actionStr = "";
    String specialStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_monster);

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
        challenge.setText("CR: "+getIntent().getStringExtra("challenge"));
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
        actionArray = getIntent().getStringArrayListExtra("actions");
        specialArray = getIntent().getStringArrayListExtra("special");

        for(int i=0; i<actionArray.size(); i++){
            actionStr+= actionArray.get(i)+"\n\n";
        }
        actions.setText(actionStr);

        for(int i=0; i<specialArray.size(); i++){
            specialStr+=specialArray.get(i)+"\n\n";
        }
        special.setText(specialStr);

    }

}
