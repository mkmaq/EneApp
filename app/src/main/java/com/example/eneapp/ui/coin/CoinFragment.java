package com.example.eneapp.ui.coin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eneapp.databinding.FragmentCoinBinding;

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
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}