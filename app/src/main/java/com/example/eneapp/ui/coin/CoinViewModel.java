package com.example.eneapp.ui.coin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CoinViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CoinViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}