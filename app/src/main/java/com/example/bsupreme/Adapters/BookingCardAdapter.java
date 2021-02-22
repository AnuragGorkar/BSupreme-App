package com.example.bsupreme.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bsupreme.Models.BookingCardModel;
import com.example.bsupreme.R;

import java.util.ArrayList;
import java.util.List;

public class BookingCardAdapter extends RecyclerView.Adapter<BookingCardAdapter.BookingCardListHolder> {

    List<BookingCardModel> list;
    Context context;
    public BookingCardAdapter(Context context, List<BookingCardModel> list) {
        this.list = list;
        this.context = context;
       // Log.d("In adapter", "onCreateViewHolder: ");
    }

    class BookingCardListHolder extends RecyclerView.ViewHolder {
        TextView seatNumber,hotelName,date,time;
        LinearLayout ac, barCounter, grill;
        List<BookingCardModel> obj = new ArrayList<BookingCardModel>();


        public BookingCardListHolder(View itemView) {
            super(itemView);
            seatNumber = itemView.findViewById(R.id.tableSeats);
            ac = itemView.findViewById(R.id.acIndicator);
            grill = itemView.findViewById(R.id.grillIndicator);
            barCounter = itemView.findViewById(R.id.barIndicator);
            hotelName = itemView.findViewById(R.id.b_hotel_name);
            date = itemView.findViewById(R.id.b_h_date);
            time = itemView.findViewById(R.id.b_h_time);


//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    if (position != RecyclerView.NO_POSITION && listener != null) {
//                        listener.OnItemClick(getSnapshots().getSnapshot(position), position);
//                    }
//                }
//            });

        }

    }



    @NonNull
    @Override
    public BookingCardListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.booking_status_card_view, parent, false);
     //   Log.d("In adapter", "onCreateViewHolder: ");
        return new BookingCardListHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BookingCardListHolder holder, int position) {
        Log.d("data", "onBindViewHolder: "+list.get(position).getHotelName());
        //Log.d("data", "onBindViewHolder: "+"Hello");
        holder.seatNumber.setText(String.valueOf(list.get(position).getSeating()));
        holder.hotelName.setText(list.get(position).getHotelName());
        holder.date.setText(list.get(position).getDate());
        //holder.time.setText(list.get(position).getTime());
        String time = list.get(position).getTime();
        if(time.equals("one"))
            holder.time.setText("08:00pm - 09:00pm");
        if(time.equals("two"))
            holder.time.setText("09:00pm - 10:00pm");
        if(time.equals("three"))
            holder.time.setText("10:00pm - 11:00pm");
        if(time.equals("four"))
            holder.time.setText("11:00pm - 12:00pm");
     //   Log.d("data", "onBindViewHolder: "+list.get(position));
       // Log.d("data", "onBindViewHolder: "+"Hello");
        if(!list.get(position).isIs_ac())
            holder.ac.setVisibility(LinearLayout.GONE);
        else
            holder.ac.setVisibility(LinearLayout.VISIBLE);

        if(!list.get(position).isIs_counter())
            holder.barCounter.setVisibility(LinearLayout.GONE);
        else
            holder.barCounter.setVisibility(LinearLayout.VISIBLE);

        if(!list.get(position).isIs_grill())
            holder.grill.setVisibility(LinearLayout.GONE);
        else
            holder.grill.setVisibility(LinearLayout.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



//    @Override
//    protected void onBindViewHolder(@NonNull BookingCardListHolder holder, int position, @NonNull BookingCardModel model) {
//
//        holder.seatNumber.setText(String.valueOf(model.getSeating()));
//        holder.hotelName.setText(model.getHotelName());
//        holder.date.setText(model.getDate());
//        holder.time.setText(model.getTime());
//
//        if(!model.isIs_ac())
//            holder.ac.setVisibility(LinearLayout.GONE);
//        else
//            holder.ac.setVisibility(LinearLayout.VISIBLE);
//
//        if(!model.isIs_counter())
//            holder.barCounter.setVisibility(LinearLayout.GONE);
//        else
//            holder.barCounter.setVisibility(LinearLayout.VISIBLE);
//
//        if(!model.isIs_grill())
//            holder.grill.setVisibility(LinearLayout.GONE);
//        else
//            holder.grill.setVisibility(LinearLayout.VISIBLE);
//
//    }


}
