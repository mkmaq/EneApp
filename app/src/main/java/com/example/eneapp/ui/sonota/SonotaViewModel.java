package com.example.eneapp.ui.sonota;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SonotaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SonotaViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue();
    }

    public LiveData<String> getText() {
        return mText;
    }
}