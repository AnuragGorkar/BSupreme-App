package com.example.bsupreme.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bsupreme.Adapters.BookingCardAdapter;
import com.example.bsupreme.Models.BookinModel;
import com.example.bsupreme.Models.BookingCardModel;
import com.example.bsupreme.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class RestaurantFragment extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference usersRef = db.collection("users");
    private BookingCardAdapter bookingCardAdapter;
    RecyclerView recyclerView ;
    TextView loading;
    List<BookingCardModel> obj = new ArrayList<BookingCardModel>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_restaurant, container, false);

        recyclerView = view.findViewById(R.id.rv);
        loading = view.findViewById(R.id.loadingRes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false) );

        setUpRecyclerView();
        return view;


    }

    private void setUpRecyclerView() {

        loading.setVisibility(View.VISIBLE);
        db.collection("users").document("anuragGorkar").collection("bookings").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error!=null)
                {
                    //Error occured
                    Log.d("RestFragrent error", "RestFragrent error: ");
                }
                else {
                    for (DocumentSnapshot documentSnapshot : value) {
                        final String[] name = new String[1];
                        BookinModel bookingCardModel = documentSnapshot.toObject(BookinModel.class);

                        bookingCardModel.getTableDocRef().getParent().getParent().get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                //  Log.d("User data", "onSuccess: "+documentSnapshot.get("seating"));


                                bookingCardModel.getTableDocRef().getParent().getParent().getParent().getParent().get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentS) {
                                        loading.setVisibility(View.GONE);
                                        name[0] = (String) documentS.get("name");
                                        Log.d("data", "onSuccess: " + name[0]);
                                        BookingCardModel b = new BookingCardModel((boolean) documentSnapshot.get("is_ac"), (boolean) documentSnapshot.get("is_counter"), (boolean) documentSnapshot.get("is_grill"), (long) documentSnapshot.get("seating"),
                                                name[0], "open", bookingCardModel.getDate(), bookingCardModel.getTime());
                                        obj.add(b);
                                        BookingCardAdapter adapter = new BookingCardAdapter(getContext(), obj);
                                        recyclerView.setAdapter(adapter);
                                    }
                                });
                                //  Log.d("size of list", "onEvent: "+b.toString());
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("failure", "onFailure: " + e.toString());
                            }
                        });

                    }
                }
              //  Log.d("size of list", "onEvent: "+obj.size());

            }
        });

    }
}