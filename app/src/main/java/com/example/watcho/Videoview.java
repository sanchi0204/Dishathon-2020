package com.example.watcho;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Videoview extends AppCompatActivity {
    final Context context = this;
    final FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoview);

        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(Videoview.this, "You have watched complete video", Toast.LENGTH_SHORT).show();
                openDialog();
            }
        });

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }
    public void openDialog() {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog_complete);
        Button dialogButton = dialog.findViewById(R.id.btn_rate);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openDialogRate();
                dialog.dismiss();
            }
        });
        dialog.show();


    }

    public void openDialogRate() {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);
        Button dialogButton = dialog.findViewById(R.id.btn_submit);
         final EditText Review = dialog.findViewById(R.id.review);
         final RatingBar ratingBar = dialog.findViewById(R.id.rating_bar);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = String.valueOf(ratingBar.getRating());
                String review = Review.getText().toString();
                addToDb(rating,review);

                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void addToDb(String rating, String review) {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Submitting");
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        Calendar c = Calendar .getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("HH:mm dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());

        Map<String,Object> Rating=new HashMap<>();
        Rating.put("rating",rating);
        Rating.put("review",review);
        Rating.put("time", formattedDate);
        Rating.put("name","User");

        db.collection("Reviews")
                .add(Rating)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        openDialogThanks();

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            progressDialog.dismiss();
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void openDialogThanks() {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_thanks);

        dialog.show();
        dialog.dismiss();
        Intent intent=new Intent(Videoview.this,ShowingReviews.class);
        startActivity(intent);
    }

}
