package com.example.elise.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class SecondActivity extends Activity {

    //Variables
    TextView name;
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
    TextView actions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Mapping views
        name = (TextView) findViewById(R.id.tv_name2);
        ac = (TextView) findViewById(R.id.tv_ac2);
        hp = (TextView) findViewById(R.id.tv_hp2);
        speed = (TextView) findViewById(R.id.tv_speed2);
        str = (TextView) findViewById(R.id.tv_str2);
        dex = (TextView) findViewById(R.id.tv_dex2);
        con = (TextView) findViewById(R.id.tv_con2);
        wis = (TextView) findViewById(R.id.tv_wis2);
        intel = (TextView) findViewById(R.id.tv_intel2);
        cha = (TextView) findViewById(R.id.tv_cha2);
        skills = (TextView) findViewById(R.id.tv_skills2);
        actions = (TextView) findViewById(R.id.tv_actions2);


        //Assign values from the monsters list to the views
        name.setText("Name: "+getIntent().getStringExtra("name"));
        ac.setText("AC: "+getIntent().getStringExtra("ac"));
        hp.setText("HP: "+getIntent().getStringExtra("hp"));
        speed.setText("Speed: "+getIntent().getStringExtra("speed")+" ft.");
        str.setText("STR: "+getIntent().getStringExtra("str"));
        dex.setText("DEX: "+getIntent().getStringExtra("dex"));
        con.setText("CON: "+getIntent().getStringExtra("con"));
        wis.setText("WIS: "+getIntent().getStringExtra("wis"));
        intel.setText("INT: "+getIntent().getStringExtra("intel"));
        cha.setText("CHA: "+getIntent().getStringExtra("cha"));
        skills.setText("Skills: "+getIntent().getStringExtra("skills"));
        actions.setText("Actions: "+getIntent().getStringExtra("actions"));

    }

}
