package com.example.watcho.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.watcho.R;
import com.example.watcho.ShowingReviews;
import com.example.watcho.Videoview;

import java.io.File;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Spotlight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Spotlight extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button addVideo;
    int SELECT_VIDEO_REQUEST=100;
    String selectedVideoPath;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Spotlight() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Spotlight.
     */
    // TODO: Rename and change types and number of parameters
    public static Spotlight newInstance(String param1, String param2) {
        Spotlight fragment = new Spotlight();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addVideo=view.findViewById(R.id.add_video);

        addVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addVideoM();
            }
        });
        
    }

    private void addVideoM() {
        Intent intent;
        if(android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
        {
            intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        }
        else
        {
            intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Video.Media.INTERNAL_CONTENT_URI);
        }
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        startActivityForResult(intent,SELECT_VIDEO_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (resultCode == RESULT_OK) {
                if (requestCode == SELECT_VIDEO_REQUEST) {
                    Uri selectedvideo = data.getData();
                    String videopath = selectedvideo.getPath();
                    File file = new File(videopath);
                    Log.i("path",file.getAbsolutePath());
                    openDialogThanks();
                }
            }

        }catch (Exception e){
            Log.i("error",e.toString());
        }
    }

    public void openDialogThanks() {

        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_dialog_video_add);

        dialog.show();
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spotlight, container, false);
    }
}
