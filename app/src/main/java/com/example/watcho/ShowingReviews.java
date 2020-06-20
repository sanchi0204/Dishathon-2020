package com.example.watcho;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.watcho.Adapters.ReviewAdapter;
import com.example.watcho.Model.Review;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
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
    private CollectionReference collectionReference=db.collection("Reviews");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing_reviews);
        recyclerView=findViewById(R.id.rating_RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reviewList=new ArrayList<>();
        final Review review=new Review();
        collectionReference.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                if(e!=null)
                {
                    return;
                }
                else
                {
                    for(QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshots)
                    {
                        Review review=documentSnapshot.toObject(Review.class);
                        reviewList.add(review);
                    }
                    reviewAdapter=new ReviewAdapter(ShowingReviews.this,reviewList);
                    recyclerView.setAdapter(reviewAdapter);
                }
            }
        });
//        db.collection("Reviews")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if(task.isSuccessful())
//                        {
//                            for(QueryDocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())){
//
//                            }
//                            reviewAdapter=new ReviewAdapter(ShowingReviews.this,reviewList);
//                            recyclerView.setAdapter(reviewAdapter);
//                        }
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(ShowingReviews.this, e.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}