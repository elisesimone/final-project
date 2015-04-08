package com.example.elise.finalproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elise on 4/8/2015.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerMonsters;

    public RecyclerViewFragment(){
        //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Decides layout the fragment will use
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    //View passed in contains all of the XML views
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //Map the view
        recyclerMonsters = (RecyclerView) view.findViewById(R.id.recycler_monsters);

        //Creating a LayoutManager for the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        //Setting the LayoutManager to the RecyclerView
        recyclerMonsters.setLayoutManager(layoutManager);

        //Creating a list of monsters
        List<Monster> monsters = monsters();

        //Setting the adapter
        recyclerMonsters.setAdapter(new MonsterAdapter(monsters,getActivity().getApplicationContext()));

    }

    private List<Monster> monsters() {
        //Creating list of monsters and filling with data
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Monster 1"));

        return monsters;
    }

}
