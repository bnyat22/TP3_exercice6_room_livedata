package com.example.tp3_exercice6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3_exercice6.dataModel.MyPlan;

public class InsertPlan extends AppCompatActivity {
    EditText jour , huit , dix , douze , quatre;
    Button retour , insert;
    PlanningModel model;
    MyPlan plan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_plan_activity);
        huit = findViewById(R.id.huitE);
        jour = findViewById(R.id.jour);
        dix = findViewById(R.id.dixE);
        douze = findViewById(R.id.douzeE);
        quatre = findViewById(R.id.quatreE);
        retour = findViewById(R.id.retoure);
        insert = findViewById(R.id.inserty);




        model = new ViewModelProvider(this).get(PlanningModel.class);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plan = new MyPlan(jour.getText().toString(),
                        huit.getText().toString(),
                        dix.getText().toString(),
                        douze.getText().toString(),
                        quatre.getText().toString());
                model.insert(plan);
            }
        });


        Intent retoure = new Intent(this , MainPlanning.class);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(retoure);
            }
        });


    }
}
