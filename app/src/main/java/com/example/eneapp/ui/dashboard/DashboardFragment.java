package com.example.eneapp.ui.dashboard;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eneapp.R;
import com.example.eneapp.databinding.FragmentElectrictyBinding;

import com.example.eneapp.databinding.FragmentElectrictyBinding;
import com.example.eneapp.ui.coin.result.PracticeActivity;
import com.example.eneapp.ui.dashboard.electricitysellbuy.ElectricitySellActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class DashboardFragment extends Fragment {

    private FragmentElectrictyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentElectrictyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child("storage_battery").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                HashMap value = (HashMap) dataSnapshot.getValue();
                Log.d(TAG, "Value is: " + value);

                long souhatuden = (long) value.get("souhatuden");
                long syouhi = (long) value.get("syouhi");
                long yojo = (long) value.get("yojo");

                //↑テキストビューに入れる

//                TextView souhatudenNum1 = binding.souhatuden2;
//                souhatudenNum1.setText(value.get("souhatuden") + " kWh");
//
//                TextView syouhi1 = binding.syouhi2;
//                syouhi1.setText(value.get("syouhi") + " kWh");

                TextView yojo1 = binding.yojo2;
                yojo1.setText(value.get("yojo") + " kWh");

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);



        Button sendButton = binding.sell1;
        // lambda式
        Intent intent = new Intent(getActivity(), ElectricitySellActivity.class);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理

            final EditText editText=binding.buynumber;
            String Value=editText.getText().toString();
            intent.putExtra("buynumber",Value);

                startActivity(intent);

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}