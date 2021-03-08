package com.example.tp3_exercice6;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3_exercice6.dataModel.MyPlan;

import java.io.IOException;
import java.io.InputStream;

public class AllPlans extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_plan_activity);
        list = findViewById(R.id.list);




        PlanningModel model = new ViewModelProvider(this).get(PlanningModel.class);
        model.getAllPlans().observe(this , plans -> {
            ArrayAdapter<MyPlan> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, plans);
            list.setAdapter(adapter);

        });

    }
}
