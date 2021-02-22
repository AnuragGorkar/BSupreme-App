package com.example.bsupreme.Models;

public class BookingCardModel {
    private boolean is_counter;
    private boolean is_ac;
    private boolean is_grill;
    private long seating;
    private String hotelName;
    private String status;
    private String date;
    private String time;

    public BookingCardModel()
    {

    }

    public BookingCardModel(boolean is_ac,
                            boolean is_counter,
                            boolean is_grill,
                            long seating,
                            String hotelName,
                            String status,
                            String date,
                            String time){

        this.is_ac = is_ac;
        this.is_counter = is_counter;
        this.is_grill = is_grill;
        this.seating = seating;
        this.hotelName = hotelName;
        this.status = status;
        this.date = date;
        this.time = time;
    }

    public boolean isIs_counter() {
        return is_counter;
    }

    public void setIs_counter(boolean is_counter) {
        this.is_counter = is_counter;
    }

    public boolean isIs_ac() {
        return is_ac;
    }

    public void setIs_ac(boolean is_ac) {
        this.is_ac = is_ac;
    }

    public boolean isIs_grill() {
        return is_grill;
    }

    public void setIs_grill(boolean is_grill) {
        this.is_grill = is_grill;
    }

    public long getSeating() {
        return seating;
    }

    public void setSeating(long seating) {
        this.seating = seating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
