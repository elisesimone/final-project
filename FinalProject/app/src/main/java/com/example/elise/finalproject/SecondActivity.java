package com.example.elise.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends Activity {

    //Variables
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Mapping views
        name = (TextView) findViewById(R.id.tv_name);

        //Assign values from the monsters list to the views
        name.setText("Name: "+getIntent().getStringExtra("name"));

    }

}
