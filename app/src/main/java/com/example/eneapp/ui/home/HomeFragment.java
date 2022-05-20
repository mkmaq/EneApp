package com.example.eneapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

//import com.example.eneapp.databinding.FragmentHomeBinding;
import com.example.eneapp.databinding.FragmentTopBinding;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    private FragmentTopBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentTopBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

//    TextView firebasetextview1;
//
//    public View onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        fireBaseTextView = findViewById(R.id.fireBaseTextView1);
//
//
//            root.find
//    )


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}