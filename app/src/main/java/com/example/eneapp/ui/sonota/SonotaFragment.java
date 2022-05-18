package com.example.eneapp.ui.sonota;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eneapp.databinding.FragmentSonotaBinding;

public class SonotaFragment extends Fragment {

    private FragmentSonotaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SonotaViewModel coinViewModel =
                new ViewModelProvider(this).get(SonotaViewModel.class);

        binding = FragmentSonotaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSonota;
        coinViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}