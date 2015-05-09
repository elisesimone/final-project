package com.example.elise.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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

    ListView drawerList;
    RelativeLayout drawerPane;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    ArrayList<NavItem> navItems = new ArrayList<NavItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_monster);

        // Creating options for navigation
        navItems.add(new NavItem("Calculator", "Monster encounter calculator"));
        navItems.add(new NavItem("Monsters", "List of all monsters"));

        // Setting up the hamburger menu icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // Populate the Navigtion Drawer with options
        drawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        drawerList = (ListView) findViewById(R.id.navList);
        DrawerListAdapter adapter = new DrawerListAdapter(this, navItems);
        drawerList.setAdapter(adapter);

        // Drawer Item click listeners
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawerOpen, R.string.drawerClose) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

        };

        drawerLayout.setDrawerListener(drawerToggle);

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

    /*
        * Called when a particular item from the navigation drawer
        * is selected.
        * */
    private void selectItemFromDrawer(int position) {

        if (position == 0){
            //Declare and instantiate the intent for the encounter calculator


        } else {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        }

        drawerList.setItemChecked(position, true);

        // Close the drawer
        drawerLayout.closeDrawer(drawerPane);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        //Changes the navigation drawer icon to the hamburger when drawer closes
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    // class for an item in the navigation drawer
    class NavItem {
        String title;
        String subtitle;

        public NavItem(String title, String subtitle) {
            this.title = title;
            this.subtitle = subtitle;
        }
    }

    //Adapter for navigation drawer to populate the drawer with data
    class DrawerListAdapter extends BaseAdapter {

        //Variables
        Context context;
        ArrayList<NavItem> navItems;

        //Constructor
        public DrawerListAdapter(Context context, ArrayList<NavItem> navItems) {
            this.context = context;
            this.navItems = navItems;
        }

        @Override
        public int getCount() {
            return navItems.size();
        }

        @Override
        public Object getItem(int position) {
            return navItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.drawer_item, null);
            }
            else {
                view = convertView;
            }

            TextView titleView = (TextView) view.findViewById(R.id.title);
            TextView subtitleView = (TextView) view.findViewById(R.id.subtitle);

            titleView.setText( navItems.get(position).title );
            subtitleView.setText(navItems.get(position).subtitle);

            return view;
        }
    }


}
