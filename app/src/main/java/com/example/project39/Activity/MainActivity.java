package com.example.project39.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project39.Adaptor.CategoryAdaptor;
import com.example.project39.Adaptor.PoplurarAdaptor;
import com.example.project39.Domain.CategoryDomain;
import com.example.project39.Domain.FoodDomain;
import com.example.project39.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Salads", "salad1", "Fresh and healthy salads", 1190));
        foodList.add(new FoodDomain("Candies", "candies", "Chocolate bars, cookies, chewing gums", 750));
        foodList.add(new FoodDomain("Pastry", "pastry", "Handmade fresh baked goods", 990));
        foodList.add(new FoodDomain("Hot drinks","hotdrinks","Tea and coffee",550));
        foodList.add(new FoodDomain("Cold drinks","colddrinks","Soda and water",450));
        foodList.add(new FoodDomain("Soups","soups","Fresh and healthy",650));
        foodList.add(new FoodDomain("Chicken Dishes","chicken","Fresh and healthy",880));
        foodList.add(new FoodDomain("Meat dishes","meat","Fresh and healthy",990));
        foodList.add(new FoodDomain("Fruit","fruit","Fresh and healthy",650));

        adapter2 = new PoplurarAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}