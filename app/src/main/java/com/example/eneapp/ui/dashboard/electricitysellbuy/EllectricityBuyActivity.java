package com.example.eneapp.ui.dashboard.electricitysellbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eneapp.MainActivity;
import com.example.eneapp.R;
import com.example.eneapp.ui.coin.result.PracticeActivity;

public class EllectricityBuyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellectricity_buy);

        Intent intent = this.getIntent();
        String text = intent.getStringExtra("buy2");
        TextView textView = (TextView)this.findViewById(R.id.textView16);
        textView.setText("取引電力:           "+text+"kWh");

        Button sendButton21 =findViewById(R.id.button9);
        // lambda式
        Intent intent21 = new Intent(this, MainActivity.class);
        sendButton21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理

                startActivity(intent21);
            }
        });




    }
}