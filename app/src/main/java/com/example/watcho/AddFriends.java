package com.example.watcho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.watcho.Adapters.FriendsAdapter;
import com.example.watcho.Adapters.RoomAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class AddFriends extends AppCompatActivity {

     RecyclerView users;
     ArrayList Name;
    ArrayList genre1;
    ArrayList genre2;
    ArrayList genre3;
    ArrayList<Integer> img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friends);

        Name = new ArrayList<>(Arrays.asList("Radhika Bawa",
                "Jayansh Jain", "Vihan Bhalla"));
        genre1 = new ArrayList<>(Arrays.asList("English",
                "Kannada", "Hindi"));
        genre2 = new ArrayList<>(Arrays.asList("Comic",
                "Thrill", "Romance"));
        genre3 = new ArrayList<>(Arrays.asList("Vlog",
                "Science", "Life"));
        img = new ArrayList<>(Arrays.asList(R.drawable.m1,
                R.drawable.m2, R.drawable.m3));


        users = findViewById(R.id.user_list);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddFriends.this);
        users.setLayoutManager(linearLayoutManager);

        final FriendsAdapter friendsAdapter = new FriendsAdapter(Name,genre1,genre2,genre3,this);
        users.setAdapter(friendsAdapter);

    }
}
