package com.example.bsupreme.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bsupreme.Models.RoomCardModel;
import com.example.bsupreme.R;

import java.util.ArrayList;
import java.util.List;

public class RoomCardAdapter extends RecyclerView.Adapter<RoomCardAdapter.RoomCardListHolder> {

    List<RoomCardModel> list;
    Context context;
    public RoomCardAdapter(Context context, List<RoomCardModel> list) {
        this.list = list;
        this.context = context;
        // Log.d("In adapter", "onCreateViewHolder: ");
    }

    @NonNull
    @Override
    public RoomCardListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.booking_status_room_card,parent,false);
        return new RoomCardListHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RoomCardListHolder holder, int position) {
        Log.d("data", "onBindViewHolder: "+list.get(position).getHotelName());

        holder.HotelName.setText(list.get(position).getHotelName());
        holder.roomType.setText(list.get(position).getType());
        holder.beds.setText(String.valueOf(list.get(position).getBeds()));
        holder.cin.setText(list.get(position).getCin());
        holder.cout.setText(list.get(position).getCout());
        Log.d("f1", "f1: "+list.get(position).getCout());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RoomCardListHolder extends RecyclerView.ViewHolder{

        TextView cin,cout,HotelName,beds,roomType;
        List<RoomCardModel> obj = new ArrayList<RoomCardModel>();
        public RoomCardListHolder(@NonNull View itemView) {
            super(itemView);

            cin = itemView.findViewById(R.id.check_in_date2);
            cout = itemView.findViewById(R.id.check_out_date2);
            HotelName = itemView.findViewById(R.id.b_hotel_name);
            beds = itemView.findViewById(R.id.roomBedsTextCard2);
            roomType = itemView.findViewById(R.id.roomTypeTextCard2);
        }
    }

}