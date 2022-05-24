package com.example.eneapp.ui.coin.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eneapp.MainActivity;
import com.example.eneapp.R;

public class Result10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result10);

        Button sendButton =findViewById(R.id.send_button);
        // lambda式
        Intent intent = new Intent(this, PracticeActivity.class);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理

                startActivity(intent);
            }
        });

        Button sendButton8 =findViewById(R.id.button8);
        // lambda式
        Intent intent8 = new Intent(this, MainActivity.class);
        sendButton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理

                startActivity(intent8);
            }
        });

    }
}