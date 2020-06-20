package com.example.watcho.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watcho.R;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {

    ArrayList Message;
    Context context;

    public RoomAdapter(ArrayList message, Context context) {
        Message = message;
        this.context = context;
    }

    @NonNull
    @Override
    public RoomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.custom_room, parent, false);
        RoomAdapter.MyViewHolder myViewHolder = new RoomAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.msg.setText(Message.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return Message.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView msg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            msg = itemView.findViewById(R.id.user_msg);




        }
    }
}

