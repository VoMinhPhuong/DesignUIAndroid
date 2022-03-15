package com.example.designui.tuan5DuLieu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.designui.R;

import java.util.ArrayList;

public class CakeActivity extends AppCompatActivity {
    ListView lvw1;
    ArrayList<Cake> listCake;
    CakeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);

        lvw1 = findViewById(R.id.lvwMain);
        listCake = new ArrayList<>();

        listCake.add(new Cake("Tasty Donut","Spicy tasty donut family","$10.00",R.drawable.donut_yellow_1));
        listCake.add(new Cake("Pink Donut","Spicy tasty donut family","$20.00",R.drawable.tasty_donut_1));
        listCake.add(new Cake("Floating Donut","Spicy tasty donut family","$30.00",R.drawable.green_donut_1));
        listCake.add(new Cake("Tasty Donut","Spicy tasty donut family","$40.00",R.drawable.donut_red_1));

        adapter = new CakeAdapter(this, R.layout.item_cake_tuan5, listCake);
        lvw1.setAdapter(adapter);
    }
}