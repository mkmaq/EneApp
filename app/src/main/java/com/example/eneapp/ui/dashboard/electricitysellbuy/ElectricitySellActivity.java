package com.example.eneapp.ui.dashboard.electricitysellbuy;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eneapp.MainActivity;
import com.example.eneapp.R;
import com.example.eneapp.databinding.FragmentSonotaBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import com.example.eneapp.databinding.ActivityEllectricityBuyBinding;

public class ElectricitySellActivity extends AppCompatActivity {

    private ActivityEllectricityBuyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_sell);

        Intent intent = this.getIntent();
        String text = intent.getStringExtra("buynumber");
        TextView textView = (TextView)this.findViewById(R.id.textView16);
        textView.setText("取引電力：     "+text+"kWh");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child("storage_battery").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                HashMap value = (HashMap) dataSnapshot.getValue();
                Log.d(TAG, "Value is: " + value);

                long souhatuden = (long) value.get("souhatuden");
                long syouhi = (long) value.get("syouhi");
                long yojo = (long) value.get("yojo");

                TextView yojo1 = binding.yojosell1;
                yojo1.setText(value.get("yojo") + " kWh");

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });






    }
}