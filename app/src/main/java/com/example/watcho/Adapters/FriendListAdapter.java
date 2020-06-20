package com.example.watcho.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watcho.R;
import com.example.watcho.Showcase;

import java.util.ArrayList;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.MyViewHolder> {

    ArrayList Name;
    ArrayList gen1;
    ArrayList gen2;
    ArrayList gen3;
    Context context;

    public FriendListAdapter(ArrayList name, ArrayList gen1, ArrayList gen2, ArrayList gen3, Context context) {
        Name = name;
        this.gen1 = gen1;
        this.gen2 = gen2;
        this.gen3 = gen3;
        this.context = context;
    }

    @NonNull
    @Override
    public FriendListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.content_frnd_list, parent, false);
        FriendListAdapter.MyViewHolder myViewHolder = new FriendListAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final FriendListAdapter.MyViewHolder holder, final int position) {


        holder.name.setText(Name.get(position).toString());
        holder.g1.setText(gen1.get(position).toString());
        holder.g2.setText(gen2.get(position).toString());
        holder.g3.setText(gen3.get(position).toString());
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, Showcase.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return Name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView g1;
        TextView g2;
        TextView g3;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.user_name);
            g1 = itemView.findViewById(R.id.g1);
            g2 = itemView.findViewById(R.id.g2);
            g3 = itemView.findViewById(R.id.g3);



        }
    }
}

