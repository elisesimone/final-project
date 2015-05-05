package com.example.elise.finalproject;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.Collections;

/**
 * Created by Elise on 5/4/2015.
 */
public class SortSpinnerActivity extends Activity implements OnItemSelectedListener {

    String selectedItem;

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        selectedItem = parent.getItemAtPosition(pos).toString();

        /**if (selectedItem.equals("Alignment")){
            Collections.sort(monsters, new MonsterAlignmentComparator());

        }**/
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
