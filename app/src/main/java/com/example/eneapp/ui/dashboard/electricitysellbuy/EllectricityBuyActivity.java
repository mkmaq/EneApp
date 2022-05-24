package com.example.eneapp.ui.dashboard.electricitysellbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.eneapp.R;

public class EllectricityBuyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellectricity_buy);

        Intent intent = this.getIntent();
        String text = intent.getStringExtra("buy2");
        TextView textView = (TextView)this.findViewById(R.id.textView16);
        textView.setText("取引電力:           "+text+"kWh");

    }
}