package com.example.bsupreme.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bsupreme.Adapters.RoomCardAdapter;
import com.example.bsupreme.Models.RoomCardModel;
import com.example.bsupreme.Models.RoomModel;
import com.example.bsupreme.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class RoomFragment extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference usersRef = db.collection("users");
    private RoomCardAdapter roomCardAdapter;
    RecyclerView recyclerView ;
    TextView loading2;
    List<RoomCardModel> obj = new ArrayList<RoomCardModel>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_room, container, false);
        recyclerView = view.findViewById(R.id.rv2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false) );
        loading2 = view.findViewById(R.id.loading);
        setUpRecyclerView();
        return view;

    }

    private void setUpRecyclerView() {
        loading2.setVisibility(View.VISIBLE);
        db.collection("users").document("anuragGorkar").collection("roomBookings").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error!=null)
                {
                    //Error occured
                    Log.d("RoomFragrent error", "RoomFragrent error: ");
                }
                else {
                    for (DocumentSnapshot documentSnapshot : value) {
                        final String[] name = new String[1];
                        RoomModel roomModel = documentSnapshot.toObject(RoomModel.class);
                        roomModel.getRoomId();
                        //Log.d("Success + Roomsss", "onSuccess: "+roomModel.getCin());

                        db.collection("restaurants").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                for (DocumentSnapshot doc : queryDocumentSnapshots) {
                                    db.collection("restaurants").document(doc.getId()).collection("rooms").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                        @Override
                                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                            loading2.setVisibility(View.GONE);
                                            for (DocumentSnapshot documentSnapshot1 : queryDocumentSnapshots) {
                                                RoomCardModel roomCardModel = documentSnapshot1.toObject(RoomCardModel.class);
                                                //Log.d("Success + RoomFragment", "onSuccess: "+roomCardModel.getBeds());
                                                if (documentSnapshot1.get("roomId").equals(roomModel.getRoomId())) {
                                                    //Log.d("Data ", "DAta bes: "+roomCardModel.getBeds());
                                                    roomCardModel.setCin(roomModel.getCin());
                                                    roomCardModel.setCout(roomModel.getCout());
                                                    doc.get("name");
                                                    roomCardModel.setHotelName((String) doc.get("name"));

                                                    obj.add(roomCardModel);
                                                    RoomCardAdapter roomCardAdapter = new RoomCardAdapter(getContext(), obj);

                                                    recyclerView.setAdapter(roomCardAdapter);
                                                }
                                            }


                                            Log.d("D1", "D1: " + obj.get(0).getCin());
                                        }
                                    });

                                }
                            }
                        });

                    }
                }
            }
        });
    }
}