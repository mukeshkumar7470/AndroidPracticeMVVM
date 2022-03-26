package com.mukeshkpdeveloper.androidpracticemvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.mukeshkpdeveloper.androidpracticemvvm.repository.repository;
import com.mukeshkpdeveloper.androidpracticemvvm.response.response;

public class MainViewModel extends AndroidViewModel {

    private com.mukeshkpdeveloper.androidpracticemvvm.repository.repository repository;
    private LiveData<response> responseLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = new repository();
        this.responseLiveData = repository.getMeals();
    }

    public LiveData<response> getResponseLiveData()
    {
        return responseLiveData;
    }
}

