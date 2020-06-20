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

import com.example.watcho.Adapters.CustomerAdapter;
import com.example.watcho.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomerSupport#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomerSupport extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CustomerSupport() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomerSupport.
     */
    // TODO: Rename and change types and number of parameters
    public static CustomerSupport newInstance(String param1, String param2) {
        CustomerSupport fragment = new CustomerSupport();
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
        View view =  inflater.inflate(R.layout.fragment_customer_support, container, false);


        RecyclerView cust_query;
        final ArrayList Name;
        final ArrayList Ques;
        final ArrayList Ans;
        final EditText enter_query;
        Button add_query;

        Name = new ArrayList<>(Arrays.asList("Radhika Bawa",
                "Jayansh Jain", "Vihan Bhalla"));

        Ques = new ArrayList<>(Arrays.asList("Unable to play content in our region.",
                "Video is not playing, only black screen is displaying with the audio",
                "Paid for subscription but the content is not playing"));

        Ans = new ArrayList<>(Arrays.asList("The content is geo-restricted and available only in India.",
               "We have ABR enabled on Watcho, due to bandwidth it auto-adjusts and play only audio. Please connect with Wifi or use the application in better network reception",
                "It takes couple of minutes for the system to process and enable the entitlements."));

        cust_query = view.findViewById(R.id.list_cust);
        enter_query = view.findViewById(R.id.enter_item);
        add_query = view.findViewById(R.id.btn_add);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Objects.requireNonNull(getActivity()).getApplicationContext());
        cust_query.setLayoutManager(linearLayoutManager);

        final CustomerAdapter customerAdapter = new CustomerAdapter(Name,Ques, Ans, getContext());
        cust_query.setAdapter(customerAdapter);

        add_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ques = enter_query.getText().toString();
                Ques.add(ques);
                Name.add("User");
                Ans.add(" ");
                customerAdapter.notifyDataSetChanged();
            }
        });


        return view;
    }
}
