package com.example.watcho;

import android.app.Dialog;
import android.content.Context;
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

import androidx.appcompat.app.AppCompatActivity;

public class Videoview extends AppCompatActivity {
    final Context context = this;

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
                        //add to database
                openDialogThanks();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void openDialogThanks() {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_thanks);

        dialog.show();
    }

}
