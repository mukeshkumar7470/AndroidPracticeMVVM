package com.mukeshkpdeveloper.androidpracticemvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mukeshkpdeveloper.androidpracticemvvm.repository.repository;
import com.mukeshkpdeveloper.androidpracticemvvm.response.response1;


public class IngreidentsViewModel extends AndroidViewModel {

    private repository repository;
    private LiveData<response1> responseLiveData;


    public IngreidentsViewModel(@NonNull Application application) {
        super(application);
        repository = new repository();
    }

    public LiveData<response1> getResponseLiveData(String id)
    {
        this.responseLiveData = repository.getIngredients(id);
        return responseLiveData;
    }
}
