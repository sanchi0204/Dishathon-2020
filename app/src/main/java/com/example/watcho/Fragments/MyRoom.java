package com.example.watcho.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.watcho.Adapters.CustomerAdapter;
import com.example.watcho.Adapters.RoomAdapter;
import com.example.watcho.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyRoom#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyRoom extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyRoom() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyRoom.
     */
    // TODO: Rename and change types and number of parameters
    public static MyRoom newInstance(String param1, String param2) {
        MyRoom fragment = new MyRoom();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_my_room, container, false);


        final RecyclerView room_list;
        final ArrayList Message;
        final EditText enter_msg;
        ImageButton send_msg;

        Message = new ArrayList<>(Arrays.asList("You should watch The sentimentals. Its a good show",
                "I am awaiting new episodes of Four Thieves", "Me too.When will the new season come?"));

        room_list = view.findViewById(R.id.list_room);
        enter_msg = view.findViewById(R.id.enter_msg);
        send_msg = view.findViewById(R.id.btn_send);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Objects.requireNonNull(getActivity()).getApplicationContext());
        room_list.setLayoutManager(linearLayoutManager);

        final RoomAdapter roomAdapter = new RoomAdapter(Message,getContext());
        room_list.setAdapter(roomAdapter);

        send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = enter_msg.getText().toString();
                Message.add(msg);
                roomAdapter.notifyDataSetChanged();
                enter_msg.setText(" ");
                Toast.makeText(getContext(), "Message sent", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
