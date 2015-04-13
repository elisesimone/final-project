package com.example.elise.finalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
                Integer ac = monsters.get(position).getAc();
                Integer hp = monsters.get(position).getHp();
                Integer speed = monsters.get(position).getSpeed();
                Integer str = monsters.get(position).getStr();
                Integer dex = monsters.get(position).getDex();
                Integer con = monsters.get(position).getCon();
                Integer intel = monsters.get(position).getIntel();
                Integer wis = monsters.get(position).getWis();
                Integer cha = monsters.get(position).getCha();
                String skills = monsters.get(position).getSkills();
                String actions = monsters.get(position).getActions();

                //Adding a new intent with flags because the adapter is not an activity
                Intent intent = new Intent(context, SecondActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //Adding the strings to the new intent
                intent.putExtra("name", name);
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
                intent.putExtra("actions",actions);

                //Start the second activity
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    //Assigns values from the monsters list to the views
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText("Name: "+monsters.get(position).getName());
        holder.tvAc.setText("AC: "+monsters.get(position).getAc());
        holder.tvHp.setText("HP: "+monsters.get(position).getHp());
        holder.tvSpeed.setText("Speed: "+monsters.get(position).getSpeed()+" ft.");
        holder.tvStr.setText("STR: "+monsters.get(position).getStr());
        holder.tvDex.setText("DEX: "+monsters.get(position).getDex());
        holder.tvCon.setText("CON: "+monsters.get(position).getCon());
        holder.tvWis.setText("WIS: "+monsters.get(position).getWis());
        holder.tvIntel.setText("INT: "+monsters.get(position).getIntel());
        holder.tvSkills.setText("Skills: "+monsters.get(position).getSkills());
        holder.tvActions.setText("Actions: "+monsters.get(position).getActions());
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
        TextView tvAc;
        TextView tvHp;
        TextView tvSpeed;
        TextView tvStr;
        TextView tvDex;
        TextView tvCon;
        TextView tvWis;
        TextView tvIntel;
        TextView tvCha;
        TextView tvSkills;
        TextView tvActions;

        //ViewHolder constructor maps views and assigns listeners to each view
        public ViewHolder (View itemView, ItemClickListener listener){
            super(itemView);
            this.listener = listener;

            //Mapping views
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAc = (TextView) itemView.findViewById(R.id.tv_ac);
            tvHp = (TextView) itemView.findViewById(R.id.tv_hp);
            tvSpeed = (TextView) itemView.findViewById(R.id.tv_speed);
            tvStr = (TextView) itemView.findViewById(R.id.tv_str);
            tvDex = (TextView) itemView.findViewById(R.id.tv_dex);
            tvCon = (TextView) itemView.findViewById(R.id.tv_con);
            tvWis = (TextView) itemView.findViewById(R.id.tv_wis);
            tvIntel = (TextView) itemView.findViewById(R.id.tv_intel);
            tvCha = (TextView) itemView.findViewById(R.id.tv_cha);
            tvSkills = (TextView) itemView.findViewById(R.id.tv_skills);
            tvActions = (TextView) itemView.findViewById(R.id.tv_actions);

            //Assigning listeners
            tvName.setOnClickListener(this);
            tvAc.setOnClickListener(this);
            tvHp.setOnClickListener(this);
            tvSpeed.setOnClickListener(this);
            tvStr.setOnClickListener(this);
            tvDex.setOnClickListener(this);
            tvCon.setOnClickListener(this);
            tvWis.setOnClickListener(this);
            tvIntel.setOnClickListener(this);
            tvCha.setOnClickListener(this);
            tvSkills.setOnClickListener(this);
            tvActions.setOnClickListener(this);

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
