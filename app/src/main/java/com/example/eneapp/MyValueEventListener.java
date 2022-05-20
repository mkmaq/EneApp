package com.example.eneapp;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;



public class MyValueEventListener implements ValueEventListener {
    public void onDataChange(DataSnapshot snapshot){
        String key=snapshot.getKey();
        Object value=snapshot.getValue();
        Log.d("eneapp","データを受信しました" + key + "=" + value);
    }



    public void onCancelled( DatabaseError error) {
        System.out.println("データの受信をキャンセルしました"+error.toString());
    }
}
