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
 * Created by Elise on 4/8/2015.
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

                //Adding a new intent with flags because the adapter is not an activity
                Intent intent = new Intent(context, SecondActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //Adding the strings to the new intent
                intent.putExtra("name", name);

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

        //ViewHolder constructor maps views and assigns listeners to each view
        public ViewHolder (View itemView, ItemClickListener listener){
            super(itemView);
            this.listener = listener;

            //Mapping views
            tvName = (TextView) itemView.findViewById(R.id.tv_name);

            //Assigning listeners
            tvName.setOnClickListener(this);

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
