package com.mukeshkpdeveloper.androidpracticemvvm.retrofit;
import com.mukeshkpdeveloper.androidpracticemvvm.response.response;
import com.mukeshkpdeveloper.androidpracticemvvm.response.response1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apirequest {

    @GET("filter.php?c=dessert")
    Call<response> getMeal();

    @GET("lookup.php")
    Call<response1> getIngridients(@Query("i") String number);


}
