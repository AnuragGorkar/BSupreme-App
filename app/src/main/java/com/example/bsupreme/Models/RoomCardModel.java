package com.example.bsupreme.Models;

public class RoomCardModel {
    private long beds;
    private String hotelName;
    private String type,cin,cout;

    public RoomCardModel(){}

    public RoomCardModel(long beds, String hotelName, String type, String cin, String cout) {
        this.beds = beds;
        this.hotelName = hotelName;
        this.type = type;
        this.cin = cin;
        this.cout = cout;
    }

    public long getBeds() {
        return beds;
    }

    public void setBeds(long beds) {
        this.beds = beds;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }
}
