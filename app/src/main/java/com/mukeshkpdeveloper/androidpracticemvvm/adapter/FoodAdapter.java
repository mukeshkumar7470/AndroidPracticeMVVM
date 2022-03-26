package com.mukeshkpdeveloper.androidpracticemvvm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mukeshkpdeveloper.androidpracticemvvm.ui.IngereidentsActivity;
import com.mukeshkpdeveloper.androidpracticemvvm.R;
import com.mukeshkpdeveloper.androidpracticemvvm.model.Meal;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private final Context mContext;
    List<Meal> mealList;

    public FoodAdapter(Context mContext, List<Meal> mealList) {
        this.mContext = mContext;
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Meal meal = mealList.get(position);
        holder.textView.setText(meal.getStrMeal());
        Glide.with(mContext).load(meal.getStrMealThumb()).into(holder.imageView);
        holder.cardView.setOnClickListener(view -> {
            Intent myIntent = new Intent(mContext, IngereidentsActivity.class);
            myIntent.putExtra("key", meal.getIdMeal());
            mContext.startActivity(myIntent);
        });
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView imageView;
        final TextView textView;
        final CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
