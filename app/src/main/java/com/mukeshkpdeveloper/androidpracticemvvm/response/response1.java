package com.mukeshkpdeveloper.androidpracticemvvm.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mukeshkpdeveloper.androidpracticemvvm.model.ingridients;

import java.util.List;

public class response1 {
    @SerializedName("meals")
    @Expose
    private List<com.mukeshkpdeveloper.androidpracticemvvm.model.ingridients> ingridients = null;

    public List<ingridients> getIngridients() {
        return ingridients;
    }

    public void setMeals(List<ingridients> ingridients) {
        this.ingridients = ingridients;
    }
}
