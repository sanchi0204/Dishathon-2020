package com.example.watcho.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.watcho.Adapters.CustomerAdapter;
import com.example.watcho.Adapters.FriendListAdapter;
import com.example.watcho.AddFriends;
import com.example.watcho.FriendList;
import com.example.watcho.InviteFriends;
import com.example.watcho.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Friends#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Friends extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String message;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;

    public Friends() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Friends.
     */
    // TODO: Rename and change types and number of parameters
    public static Friends newInstance(String param1, String param2) {
        Friends fragment = new Friends();
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
        // Inflate the layout for this fragment
//        FloatingActionButton add;
//        add = Objects.requireNonNull(getActivity()).findViewById(R.id.add_btn);
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                InviteContacts();
//            }
//        });
        View view =  inflater.inflate(R.layout.fragment_friends, container, false);

        RecyclerView frnd_list;
            FriendList friendList = new FriendList();
        assert friendList != null;
        int length = friendList.getName().size();

        ArrayList<String> name = new ArrayList<String>(length);
        ArrayList<String> gen1 = new ArrayList<String>(length);
        ArrayList<String> gen2 = new ArrayList<String>(length);
        ArrayList<String> gen3 = new ArrayList<String>(length);


   for(int i=0;i<length;i++)
   {
       name.add(i,friendList.getName(i));
       gen1.add(i,friendList.getGen1(i));
       gen2.add(i,friendList.getGen2(i));
       gen3.add(i,friendList.getGen3(i));

   }

        frnd_list = view.findViewById(R.id.recycler_friends);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Objects.requireNonNull(getActivity()).getApplicationContext());
        frnd_list.setLayoutManager(linearLayoutManager);

        final FriendListAdapter friendListAdapter = new FriendListAdapter(name,gen1, gen2,gen3, getContext());
        frnd_list.setAdapter(friendListAdapter);


        Button invite_frnds;
        Button add_frnds;

        invite_frnds = view.findViewById(R.id.btn_invite);
        add_frnds = view.findViewById(R.id.btn_add);

        invite_frnds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), InviteFriends.class);
                startActivity(i);
            }
        });

        add_frnds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AddFriends.class);
                startActivity(i);
            }
        });

        return view;
    }

//    private void InviteContacts() {
//
//        Intent i = new Intent(getContext(), SendMessages.class);
//        startActivity(i);
//    }
//
//    protected void sendSMSMessage() {
//        phoneNo = txtphoneNo.getText().toString();
//        message = getString(R.string.sms_msg);
//
//        if (ContextCompat.checkSelfPermission(Objects.requireNonNull(getContext()),
//                Manifest.permission.SEND_SMS)
//                != PackageManager.PERMISSION_GRANTED) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(Objects.requireNonNull(getActivity()),
//                    Manifest.permission.SEND_SMS)) {
//            } else {
//                ActivityCompat.requestPermissions(getActivity(),
//                        new String[]{Manifest.permission.SEND_SMS},
//                        MY_PERMISSIONS_REQUEST_SEND_SMS);
//            }
//        }
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    SmsManager smsManager = SmsManager.getDefault();
//                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
//                    Toast.makeText(getContext(), "SMS sent.",
//                            Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getContext(),
//                            "SMS failed, please try again.", Toast.LENGTH_LONG).show();
//                    return;
//                }
//            }
//        }
//
//    }
}
