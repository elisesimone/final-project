package com.example.elise.finalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elise Johnson and Alex Gwaltney on 4/8/2015.
 */

public class MonsterAdapter extends RecyclerView.Adapter<MonsterAdapter.ViewHolder> {

    //Variables
    Context context;
    List<Monster> monsters;

    //Constructor to create the adapter and pass in necessary values from recycler view fragment
    public MonsterAdapter(List<Monster> monsters, Context context){
        this.monsters=monsters;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflates layout to repeat for each monster in the list
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_monster, parent, false);

        //Create instance of the ViewHolder to handle when the user clicks on a monster
        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener(){
            @Override
            public void onItemClick(View view, int position){

                //Getting the monster information for the item clicked on
                String name = monsters.get(position).getName();
                String type = monsters.get(position).getType();
                String alignment = monsters.get(position).getAlignment();
                int ac = monsters.get(position).getAc();
                int hp = monsters.get(position).getHp();
                int speed = monsters.get(position).getSpeed();
                int str = monsters.get(position).getStr();
                int dex = monsters.get(position).getDex();
                int con = monsters.get(position).getCon();
                int intel = monsters.get(position).getIntel();
                int wis = monsters.get(position).getWis();
                int cha = monsters.get(position).getCha();
                String skills = monsters.get(position).getSkills();
                String savingThrows = monsters.get(position).getSavingThrows();
                String damageImmunities = monsters.get(position).getDamageImmunities();
                String damageResistance = monsters.get(position).getDamageResistance();
                String conditionImmunities = monsters.get(position).getConditionImmunities();
                String senses = monsters.get(position).getSenses();
                String languages = monsters.get(position).getLanguages();
                int challenge = monsters.get(position).getChallenge();
                ArrayList actions = monsters.get(position).getActions();
                ArrayList special = monsters.get(position).getSpecial();

                //Adding a new intent with flags because the adapter is not an activity
                Intent intent = new Intent(context, SecondActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //Adding the strings to the new intent
                intent.putExtra("name",name);
                intent.putExtra("type",type);
                intent.putExtra("alignment",alignment);
                intent.putExtra("ac",ac);
                intent.putExtra("hp",hp);
                intent.putExtra("speed",speed);
                intent.putExtra("str",str);
                intent.putExtra("dex",dex);
                intent.putExtra("con",con);
                intent.putExtra("intel",intel);
                intent.putExtra("wis",wis);
                intent.putExtra("cha",cha);
                intent.putExtra("skills",skills);
                intent.putExtra("savingThrows",savingThrows);
                intent.putExtra("damageImmunities",damageImmunities);
                intent.putExtra("damageResistance",damageResistance);
                intent.putExtra("conditionImmunities",conditionImmunities);
                intent.putExtra("senses",senses);
                intent.putExtra("languages",languages);
                intent.putExtra("challenge",challenge);
                intent.putExtra("actions",actions);
                intent.putExtra("special",special);

                //Start the second activity
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    //Assigns values from the monsters list to the views
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(monsters.get(position).getName());
        holder.tvType.setText(monsters.get(position).getType());
        holder.tvChallenge.setText("Challenge: "+ monsters.get(position).getChallenge()+" XP");
        holder.tvAc.setText("AC: "+monsters.get(position).getAc());
        holder.tvHp.setText("HP: "+monsters.get(position).getHp());
        holder.tvSpeed.setText("Speed: "+monsters.get(position).getSpeed()+" ft.");
        holder.tvStr.setText("STR: "+monsters.get(position).getStr());
        holder.tvDex.setText("DEX: "+monsters.get(position).getDex());
        holder.tvCon.setText("CON: "+monsters.get(position).getCon());
        holder.tvWis.setText("WIS: "+monsters.get(position).getWis());
        holder.tvIntel.setText("INT: "+monsters.get(position).getIntel());
    }

    @Override
    //Required method for RecyclerView
    public int getItemCount() {
        return monsters.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //Variables
        ItemClickListener listener;

        TextView tvName;
        TextView tvType;
        TextView tvChallenge;
        TextView tvAc;
        TextView tvHp;
        TextView tvSpeed;
        TextView tvStr;
        TextView tvDex;
        TextView tvCon;
        TextView tvWis;
        TextView tvIntel;
        TextView tvCha;

        //ViewHolder constructor maps views and assigns listeners to each view
        public ViewHolder (View itemView, ItemClickListener listener){
            super(itemView);
            this.listener = listener;

            //Mapping views
            tvName = (TextView) itemView.findViewById(R.id.tvName2);
            tvType = (TextView) itemView.findViewById(R.id.tvType2);
            tvChallenge = (TextView) itemView.findViewById(R.id.tvChallenge2);
            tvAc = (TextView) itemView.findViewById(R.id.tvAC2);
            tvHp = (TextView) itemView.findViewById(R.id.tvHP2);
            tvSpeed = (TextView) itemView.findViewById(R.id.tvSpeed2);
            tvStr = (TextView) itemView.findViewById(R.id.tvSTRscore2);
            tvDex = (TextView) itemView.findViewById(R.id.tvDEXscore2);
            tvCon = (TextView) itemView.findViewById(R.id.tvCONscore2);
            tvWis = (TextView) itemView.findViewById(R.id.tvWISscore2);
            tvIntel = (TextView) itemView.findViewById(R.id.tvINTscore2);
            tvCha = (TextView) itemView.findViewById(R.id.tvCHAscore2);

            //Assigning listeners
            tvName.setOnClickListener(this);
            tvType.setOnClickListener(this);
            tvChallenge.setOnClickListener(this);
            tvAc.setOnClickListener(this);
            tvHp.setOnClickListener(this);
            tvSpeed.setOnClickListener(this);
            tvStr.setOnClickListener(this);
            tvDex.setOnClickListener(this);
            tvCon.setOnClickListener(this);
            tvWis.setOnClickListener(this);
            tvIntel.setOnClickListener(this);
            tvCha.setOnClickListener(this);

        }

        @Override
        //Passes the onClick event to individual items
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }

        //Interface which forces the adapter to implement the OnClickListener
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }

}
