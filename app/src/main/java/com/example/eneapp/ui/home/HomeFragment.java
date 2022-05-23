package com.example.eneapp.ui.home;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eneapp.R;
import com.example.eneapp.databinding.FragmentTopBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class HomeFragment extends Fragment {

    private FragmentTopBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentTopBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
//

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();


        myRef.child("message").setValue("Hello, World",null);

        myRef.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        myRef.child("storage_battery").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                HashMap value = (HashMap) dataSnapshot.getValue();
                Log.d(TAG, "Value is: " + value);

//                long souhatuden = (long) value.get("souhatuden");
//                long syouhi = (long) value.get("syouhi");
//                long yojo = (long) value.get("yojo");

                //↑テキストビューに入れる

                TextView souhatudenNum1 = binding.souhatuden1;
                souhatudenNum1.setText(value.get("souhatuden") + " kWh");

                TextView syouhi1 = binding.syouhi1;
                syouhi1.setText(value.get("syouhi") + " kWh");

                TextView yojo1 = binding.yojo1;
                yojo1.setText(value.get("yojo") + " kWh");

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_top);


    }

    private void setContentView(int fragment_top) {
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}