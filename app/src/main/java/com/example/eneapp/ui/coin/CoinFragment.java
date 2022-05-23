package com.example.eneapp.ui.coin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eneapp.MainActivity;
import com.example.eneapp.R;
import com.example.eneapp.databinding.FragmentCoinBinding;
import com.example.eneapp.ui.coin.result.PracticeActivity;
import com.example.eneapp.ui.coin.result.Result100Activity;
import com.example.eneapp.ui.coin.result.Result10Activity;
import com.example.eneapp.ui.coin.result.Result50Activity;
import com.example.eneapp.ui.coin.result.ResultActivity;


public class CoinFragment extends Fragment {

    private FragmentCoinBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CoinViewModel notificationsViewModel =
                new ViewModelProvider(this).get(CoinViewModel.class);

        binding = FragmentCoinBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final TextView textView = binding.textCoin;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Button sendButton =root.findViewById(R.id.button5);
        // lambda式
        root.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // クリック時の処理
                Intent intent = new Intent(getActivity(), ResultActivity.class);
                startActivity(intent);
            }
        });

        Button button3 =root.findViewById(R.id.button3);
        root.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // クリック時の処理
                Intent intent = new Intent(getActivity(), Result10Activity.class);
                startActivity(intent);
            }
        });

        Button button4 =root.findViewById(R.id.button4);
        root.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // クリック時の処理
                Intent intent = new Intent(getActivity(), Result50Activity.class);
                startActivity(intent);
            }
        });


        sendButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Result100Activity.class);
            startActivity(intent);
        });
        return root;
    }





    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }





}