package com.example.watcho.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watcho.R;

import java.util.ArrayList;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.MyViewHolder> {

    ArrayList Name;
    ArrayList genre1;
    ArrayList genre2;
    ArrayList genre3;
    ArrayList img;
    Context context;

    public FriendsAdapter(ArrayList name, ArrayList genre1, ArrayList genre2, ArrayList genre3, ArrayList img, Context context) {
        Name = name;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
        this.img = img;
        this.context = context;
    }

    @NonNull
    @Override
    public FriendsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.content_recycle_add_frnds, parent, false);
        FriendsAdapter.MyViewHolder myViewHolder = new FriendsAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final FriendsAdapter.MyViewHolder holder, final int position) {


        holder.name.setText(Name.get(position).toString());
        holder.g1.setText(genre1.get(position).toString());
        holder.g2.setText(genre2.get(position).toString());
        holder.g3.setText(genre3.get(position).toString());
        holder.img.setImageDrawable(img.get(position).get);
        // implement setOnClickListener event on item view.
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Friend Added", Toast.LENGTH_SHORT).show();
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
        ImageView img;
        ImageButton add;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.user_name);
            g1 = itemView.findViewById(R.id.g1);
            g2 = itemView.findViewById(R.id.g2);
            g3 = itemView.findViewById(R.id.g3);
            img = itemView.findViewById(R.id.user_img);
            add = itemView.findViewById(R.id.add_frnd);



        }
    }
}

