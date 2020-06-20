package com.example.watcho.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watcho.Model.Review;
import com.example.watcho.R;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
    Context ctx;
    List<Review> reviews;

    public ReviewAdapter(Context ctx, List<Review> reviews){
        this.ctx=ctx;
        this.reviews=reviews;
    }


    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.single_review_layout,parent,false);
        ReviewViewHolder reviewViewHolder=new ReviewViewHolder(view);
        return reviewViewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {

        final Review review=reviews.get(position);
        holder.Name.setText(review.getName());
        holder.review.setText(review.getReview());
        holder.rating.setText(review.getRating()+"/5.0");
        holder.time.setText(review.getTime());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView Name,rating,review,time;
        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.Name);
            rating=itemView.findViewById(R.id.rating);
            review=itemView.findViewById(R.id.review1);
            time=itemView.findViewById(R.id.time);
        }
    }
}
