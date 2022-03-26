package com.mukeshkpdeveloper.androidpracticemvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mukeshkpdeveloper.androidpracticemvvm.R;
import com.mukeshkpdeveloper.androidpracticemvvm.adapter.FoodAdapter;
import com.mukeshkpdeveloper.androidpracticemvvm.model.Meal;
import com.mukeshkpdeveloper.androidpracticemvvm.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodAdapter foodadapter;
    private List<Meal> mealList = new ArrayList<>();
    MainViewModel mainViewModel;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intialization();
        getMeals();

    }

    private void intialization(){
        FloatingActionButton fab = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        foodadapter = new FoodAdapter(MainActivity.this, mealList);

        recyclerView.setAdapter(foodadapter);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void getMeals()
    {
        mainViewModel.getResponseLiveData().observe(this, mealResponse ->
        {
            if(mealResponse != null)
            {
                List<Meal> meals = mealResponse.getMeals();
                mealList.addAll(meals);
                Log.d("Hello", mealList.get(0).getStrMeal());
                foodadapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}