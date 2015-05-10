package com.example.elise.finalproject;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener {

    //Variables
    String selectedItem;

    ListView drawerList;
    RelativeLayout drawerPane;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    ArrayList<NavItem> navItems = new ArrayList<NavItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //Request instance of SharedPreferences
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        //Obtain user preferences
        selectedItem = prefs.getString("selectedItem","Name");

        //Create the bundle and put our values into it
        Bundle bundle = new Bundle();
        bundle.putString("selectedItem",selectedItem);

        RecyclerViewFragment recyclerFrag = new RecyclerViewFragment();

        //Set the arguments of the RecyclerViewFragment
        recyclerFrag.setArguments(bundle);

        //Fragment transaction for the recycler view fragment
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, recyclerFrag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }

        //Request editor for SharedPreferences
        SharedPreferences.Editor editor = prefs.edit();
        //Give value to editor
        editor.putString("selectedItem", selectedItem);
        //Commit changes
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        selectedItem = prefs.getString("selectedItem","Name");

        MenuItem item = menu.findItem(R.id.sortSpinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sortOptions, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        if (selectedItem.equals("Alignment")){
            spinner.setSelection(0);
        } else if (selectedItem.equals("Challenge Rating")){
            spinner.setSelection(1);
        } else if (selectedItem.equals("Name")){
            spinner.setSelection(2);
        } else if (selectedItem.equals("Type")){
            spinner.setSelection(3);
        }
        // set the listener, to perform actions based on item selection
        spinner.setOnItemSelectedListener(this);

        return true;

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        selectedItem = parent.getItemAtPosition(pos).toString();

        //Declare and instantiate the fragment
        RecyclerViewFragment recyclerFrag = new RecyclerViewFragment();

        //Create the bundle and put our values into it
        Bundle bundle = new Bundle();
        bundle.putString("selectedItem", selectedItem);

        //Set the arguments of the SumFragment
        recyclerFrag.setArguments(bundle);

        //Transition into new fragment
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, recyclerFrag)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

        //Request instance of SharedPreferences
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        //Request editor for SharedPreferences
        SharedPreferences.Editor editor = prefs.edit();
        //Give value to editor
        editor.putString("selectedItem", selectedItem);
        //Commit changes
        editor.commit();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    /*
        * Called when a particular item from the navigation drawer
        * is selected.
        * */
    private void selectItemFromDrawer(int position) {

        if (position == 0){
            //Declare and instantiate the intent for the encounter calculator
            Intent intent = new Intent(MainActivity.this, EncounterActivity.class);
            startActivity(intent);

        } else {
            SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
            selectedItem = prefs.getString("selectedItem","Name");

            //Declare and instantiate the fragment
            RecyclerViewFragment recyclerFrag = new RecyclerViewFragment();

            //Create the bundle and put our values into it
            Bundle bundle = new Bundle();
            bundle.putString("selectedItem", selectedItem);

            //Set the arguments of the SumFragment
            recyclerFrag.setArguments(bundle);

            //Transition into new fragment
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, recyclerFrag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();

            //Request editor for SharedPreferences
            SharedPreferences.Editor editor = prefs.edit();
            //Give value to editor
            editor.putString("selectedItem", selectedItem);
            //Commit changes
            editor.commit();
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
