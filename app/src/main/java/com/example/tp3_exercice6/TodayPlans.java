package com.example.tp3_exercice6;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3_exercice6.dataModel.MyPlan;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodayPlans extends AppCompatActivity {
    TextView huit , dix ,douze , quatre;
    Button retour;
    PlanningModel model;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_activity);

        huit = findViewById(R.id.huit);
        dix = findViewById(R.id.dix);
        douze = findViewById(R.id.douze);
        quatre = findViewById(R.id.quatre);
        retour = findViewById(R.id.retour);

        Log.i("e" , "fdfdsgsdgsdsdgsdgdsgsd" +getCurrentDate());
         model = new ViewModelProvider(this).get(PlanningModel.class);
        model.getTodayPlans(getCurrentDate()).observe(this, new Observer<MyPlan>() {
            @Override
            public void onChanged(MyPlan myPlan) {
                huit.setText(myPlan.getHuit());
                dix.setText(myPlan.getDix());
                douze.setText(String.valueOf(myPlan.getDouze()));
                quatre.setText(String.valueOf(myPlan.getQuatre()));
            }
        });

        Intent intent = new Intent(this , MainPlanning.class);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


    }
    private String getCurrentDate()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = format.format(new Date());
        return  currentDate;
    }
}
