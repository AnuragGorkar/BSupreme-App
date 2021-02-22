package com.example.bsupreme.Models;

public class RoomModel {
    private String cin;
    private String cout;
    private String roomDocRef;
    private String roomId;

    public RoomModel(String cin, String cout, String roomDocRef, String roomId) {
        this.cin = cin;
        this.cout = cout;
        this.roomDocRef = roomDocRef;

        this.roomId = roomId;
    }

    public RoomModel()
    {

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

    public String getRoomDocRef() {
        return roomDocRef;
    }

    public void setRoomDocRef(String roomDocRef) {
        this.roomDocRef = roomDocRef;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
