package com.mukeshkpdeveloper.androidpracticemvvm.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mukeshkpdeveloper.androidpracticemvvm.response.response;
import com.mukeshkpdeveloper.androidpracticemvvm.response.response1;
import com.mukeshkpdeveloper.androidpracticemvvm.retrofit.apirequest;
import com.mukeshkpdeveloper.androidpracticemvvm.retrofit.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class repository {

    private com.mukeshkpdeveloper.androidpracticemvvm.retrofit.apirequest apirequest;

    public repository()
    {
        apirequest = retrofit.getRetrofitInstance().create(apirequest.class);

    }

    public LiveData<response> getMeals()
    {
        final MutableLiveData<response> data = new MutableLiveData<>();
        apirequest.getMeal().enqueue(new Callback<response>() {
            @Override
            public void onResponse(Call<response> call, Response<response> response) {
                if(response.body() != null)
                {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<response> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }


    public LiveData<response1> getIngredients(String id)
    {
        final MutableLiveData<response1> data = new MutableLiveData<>();
        apirequest.getIngridients(id).enqueue(new Callback<response1>() {
            @Override
            public void onResponse(Call<response1> call, Response<response1> response) {
                if(response.body() != null)
                {
                    data.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<response1> call, Throwable t) {

            }
    });
    return data;
    }
}
