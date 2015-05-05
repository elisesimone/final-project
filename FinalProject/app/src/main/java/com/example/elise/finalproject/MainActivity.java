package com.example.elise.finalproject;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener {

    String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        selectedItem = prefs.getString("selectedItem","Name");

        //Create the bundle and put our values into it
        Bundle bundle = new Bundle();
        bundle.putString("selectedItem",selectedItem);

        RecyclerViewFragment recyclerFrag = new RecyclerViewFragment();

        //Set the arguments of the SumFragment
        recyclerFrag.setArguments(bundle);

        //Fragment transaction for the recycler view fragment
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
                .addToBackStack("")
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

}
