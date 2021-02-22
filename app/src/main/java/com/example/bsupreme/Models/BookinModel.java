package com.example.bsupreme.Models;

import com.google.firebase.firestore.DocumentReference;

public class BookinModel {
    //private String tableDocRef;
    private String date;
    private String time;
    private DocumentReference  tableDocRef;

    public BookinModel()
    {

    }

    public BookinModel(
                            DocumentReference tableDocRef,
                            String date,
                            String time){


        this.tableDocRef = tableDocRef;
        this.date = date;
        this.time = time;
    }

    public DocumentReference getTableDocRef() {
        return tableDocRef;
    }

    public void setTableDocRef(DocumentReference tableDocRef) {
        this.tableDocRef = tableDocRef;
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
