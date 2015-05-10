package com.example.elise.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Alex on 5/5/2015.
 */
public class EncounterActivity extends ActionBarActivity{

    EditText et_PartySize;
    EditText et_PartyLvl;
    EditText et_NumMonsters;
    EditText et_CR;
    TextView tv_Calculate;
    TextView tv_Result;
    EncounterCalculator encountCalc = new EncounterCalculator();

    ListView drawerList;
    RelativeLayout drawerPane;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    ArrayList<NavItem> navItems = new ArrayList<NavItem>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encounter);

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


        et_PartySize = (EditText)findViewById(R.id.etPartySize);
        et_PartyLvl = (EditText)findViewById(R.id.etPartyLvl);
        et_NumMonsters = (EditText)findViewById(R.id.etNumMonsters);
        et_CR = (EditText)findViewById(R.id.etCR);
        tv_Calculate = (TextView) findViewById(R.id.tvCalculate);
        tv_Result = (TextView) findViewById(R.id.tvResult);

        /*
        All fields must have valid input in them before clicking the 'Calculate' button
         */
        tv_Calculate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                    int partySize = Integer.parseInt(et_PartySize.getText().toString());
                    int partyLvl = Integer.parseInt(et_PartyLvl.getText().toString());
                    int numMonster = Integer.parseInt(et_NumMonsters.getText().toString());
                    String CR = (et_CR.getText().toString());
                    String[] fraction1;
                    if (CR.contains("/")) {
                        fraction1 = CR.split("/");
                    } else {
                        fraction1 = new String[]{CR, "1"};
                    }
                    Double numer1 = Double.valueOf(fraction1[0]);
                    Double denom1 = Double.valueOf(fraction1[1]);
                    Double value1 = numer1 / denom1;
                    tv_Result.setText(encountCalc.calculateEncounter(partySize, partyLvl, numMonster, value1));



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_encounter, menu);

        return true;

    }

    /*
        * Called when a particular item from the navigation drawer
        * is selected.
        * */
    private void selectItemFromDrawer(int position) {

        if (position == 0){

        } else {
            Intent intent = new Intent(EncounterActivity.this, MainActivity.class);
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
