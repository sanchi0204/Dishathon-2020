package com.example.watcho;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watcho.Adapters.ReviewAdapter;
import com.example.watcho.Model.Review;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShowingReviews extends AppCompatActivity {
    RecyclerView recyclerView;
    ReviewAdapter reviewAdapter;
    List<Review> reviewList;
    FirebaseFirestore db= FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing_reviews);
        recyclerView=findViewById(R.id.rating_RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reviewList=new ArrayList<>();
        final Review review=new Review();
        db.collection("Reviews")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful())
                        {
                            for(QueryDocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())){
                                review.setName(documentSnapshot.get("name").toString());
                                review.setReview(documentSnapshot.get("review").toString());
                                review.setRating(documentSnapshot.get("rating").toString());
                                review.setTime(documentSnapshot.get("time").toString());
                                reviewList.add(review);
                            }
                            reviewAdapter=new ReviewAdapter(ShowingReviews.this,reviewList);
                            recyclerView.setAdapter(reviewAdapter);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ShowingReviews.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}