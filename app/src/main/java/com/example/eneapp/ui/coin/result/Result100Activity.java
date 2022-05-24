package com.example.eneapp.ui.coin.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eneapp.MainActivity;
import com.example.eneapp.R;

public class Result100Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result100);

        Button sendButton =findViewById(R.id.send_button);
        // lambda式
        Intent intent = new Intent(this, PracticeActivity.class);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理

                startActivity(intent);
            }
        });

        Button sendButton6 =findViewById(R.id.button6);
        // lambda式
        Intent intent6 = new Intent(this, MainActivity.class);
        sendButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理

                startActivity(intent6);
            }
        });
    }
}