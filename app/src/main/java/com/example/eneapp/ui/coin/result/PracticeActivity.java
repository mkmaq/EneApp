package com.example.eneapp.ui.coin.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eneapp.R;

import com.example.eneapp.MainActivity;
import com.example.eneapp.R;
import com.example.eneapp.databinding.FragmentCoinBinding;

public class PracticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);


        Button sendButton =findViewById(R.id.button3);
        // lambda式
        Intent intent = new Intent(this, Result10Activity.class);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理

                startActivity(intent);
            }
        });

        Button sendButton1 =findViewById(R.id.button4);
        // lambda式
        Intent intent1 = new Intent(this, Result50Activity.class);
        sendButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理

                startActivity(intent1);
            }
        });

        Button sendButton2 =findViewById(R.id.button5);
        // lambda式
        Intent intent2 = new Intent(this, Result100Activity.class);
        sendButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理

                startActivity(intent2);
            }
        });

        Button sendButton3 =findViewById(R.id.button);
        // lambda式
        Intent intent3 = new Intent(this, ResultActivity.class);
        sendButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理

                startActivity(intent3);
            }
        });

    }
}