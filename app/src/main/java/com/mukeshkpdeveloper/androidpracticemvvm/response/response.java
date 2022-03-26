package com.mukeshkpdeveloper.androidpracticemvvm.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mukeshkpdeveloper.androidpracticemvvm.model.Meal;

import java.util.List;

public class response {
    @SerializedName("meals")
    @Expose
    private List<Meal> meals = null;

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

}
