package com.example.watcho.Adapters;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watcho.R;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {

    ArrayList Name;
    ArrayList Ques;
    ArrayList Ans;
    Context context;

    public CustomerAdapter(ArrayList name, ArrayList ques, ArrayList ans, Context context) {
        Name = name;
        Ques = ques;
        Ans = ans;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.custom_list_customer, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


        holder.name.setText(Name.get(position).toString());
        holder.ques.setText(Ques.get(position).toString());
        // implement setOnClickListener event on item view.
        holder.ques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ques.setVisibility(View.GONE);
                holder.ans.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Ques.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView ques;
        TextView ans;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.user_name);
            ques = itemView.findViewById(R.id.user_ques);
            ans = itemView.findViewById(R.id.user_ans);



        }
    }
}

