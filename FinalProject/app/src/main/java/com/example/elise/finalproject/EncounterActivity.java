package com.example.elise.finalproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Alex on 5/5/2015.
 */
public class EncounterActivity extends MainActivity{

    EditText et_PartySize;
    EditText et_PartyLvl;
    EditText et_NumMonsters;
    EditText et_CR;
    TextView tv_Calculate;
    TextView tv_Result;
    EncounterCalculator encountCalc = new EncounterCalculator();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encounter);

        et_PartySize = (EditText)findViewById(R.id.etPartySize);
        et_PartyLvl = (EditText)findViewById(R.id.etPartyLvl);
        et_NumMonsters = (EditText)findViewById(R.id.etNumMonsters);
        et_CR = (EditText)findViewById(R.id.etCR);
        tv_Calculate = (TextView) findViewById(R.id.tvCalculate);
        tv_Result = (TextView) findViewById(R.id.tvResult);

        tv_Calculate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int partySize = Integer.parseInt(et_PartySize.getText().toString());
                int partyLvl = Integer.parseInt(et_PartyLvl.getText().toString());
                int numMonster = Integer.parseInt(et_NumMonsters.getText().toString());
                int CR = Integer.parseInt(et_CR.getText().toString());
                tv_Result.setText(encountCalc.calculateEncounter(partySize,partyLvl,numMonster,CR));



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;

    }
}
