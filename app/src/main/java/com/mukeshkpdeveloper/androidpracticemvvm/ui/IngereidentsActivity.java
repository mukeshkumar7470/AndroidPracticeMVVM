package com.mukeshkpdeveloper.androidpracticemvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mukeshkpdeveloper.androidpracticemvvm.R;
import com.mukeshkpdeveloper.androidpracticemvvm.adapter.FoodAdapter;
import com.mukeshkpdeveloper.androidpracticemvvm.model.Meal;
import com.mukeshkpdeveloper.androidpracticemvvm.viewmodel.IngreidentsViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngereidentsActivity extends AppCompatActivity {

    IngreidentsViewModel mainViewModel;
    private ImageView imageViewMain;
    private TextView textView;
    private TextView catText;
    private LinearLayout ingr;
    private TextView instructions;
    private String value;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingereidents);

        Intent intent = getIntent();
        value = intent.getStringExtra("key"); //if it's a string you store

        intialization();
    }

    private void intialization(){


        imageViewMain = findViewById(R.id.imageViewMain);
        collapsingToolbarLayout = findViewById(R.id.name);
        catText = findViewById(R.id.cat);

        ingr = findViewById(R.id.ingr);
        instructions = findViewById(R.id.instructions);

        mainViewModel = new ViewModelProvider(this).get(IngreidentsViewModel.class);

        mainViewModel.getResponseLiveData(value).observe(this, response ->
        {
            if(response != null)
            {
                HashMap<String, String> map = response.getIngridients().get(0).getMap();

                Glide.with(getApplicationContext()).load(response.getIngridients().get(0).getStrMealThumb()).into(imageViewMain);

               // textView.setText(response.getIngridients().get(0).getStrMeal());
                collapsingToolbarLayout.setTitle(response.getIngridients().get(0).getStrMeal());

                catText.setText(response.getIngridients().get(0).getStrCategory());

                TextView v = new TextView(getApplicationContext());
                v.setTextAppearance(androidx.constraintlayout.widget.R.style.TextAppearance_AppCompat_Body2);
                v.setText("Ingreidents \t : \t Quantity");

                ingr.addView(v);

                for(Map.Entry<String, String> e : map.entrySet())
                {
                    TextView v1 = new TextView(getApplicationContext());
                    v.setTextAppearance(androidx.constraintlayout.widget.R.style.TextAppearance_AppCompat_Body2);
                    v1.setText(e.getKey() + "\t : \t" + e.getValue());
                    ingr.addView(v1);
                }

                instructions.setText(response.getIngridients().get(0).getStrInstructions());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}