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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Request instance of SharedPreferences
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);

        //Mapping views
        name = (TextView) findViewById(R.id.tvName1);
        challenge = (TextView) findViewById(R.id.tvCR1);
        type = (TextView) findViewById(R.id.tvType1);
        ac = (TextView) findViewById(R.id.tvAC1);
        hp = (TextView) findViewById(R.id.tvHP1);
        speed = (TextView) findViewById(R.id.tvSpeed1);
        str = (TextView) findViewById(R.id.tvSTRscore1);
        dex = (TextView) findViewById(R.id.tvDEXscore1);
        con = (TextView) findViewById(R.id.tvCONscore1);
        wis = (TextView) findViewById(R.id.tvWISscore1);
        intel = (TextView) findViewById(R.id.tvINTscore1);
        cha = (TextView) findViewById(R.id.tvCHAscore1);

        //Assign values from the monsters list to the views
        name.setText(getIntent().getStringExtra("name"));
        challenge.setText("Challenge: "+getIntent().getStringExtra("challenge")+" XP");
        type.setText(getIntent().getStringExtra("type"));
        ac.setText("AC: "+getIntent().getStringExtra("ac"));
        hp.setText("HP: "+getIntent().getStringExtra("hp"));
        speed.setText("Speed: "+getIntent().getStringExtra("speed")+" ft.");
        str.setText(getIntent().getStringExtra("str"));
        dex.setText(getIntent().getStringExtra("dex"));
        con.setText(getIntent().getStringExtra("con"));
        wis.setText(getIntent().getStringExtra("wis"));
        intel.setText(getIntent().getStringExtra("intel"));
        cha.setText(getIntent().getStringExtra("cha"));

    }

}
