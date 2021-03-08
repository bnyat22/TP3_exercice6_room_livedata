package com.example.tp3_exercice6;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainPlanning extends AppCompatActivity {
   private Button today , insert , all , update;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  setContentView(R.layout.main_planning);

  today = findViewById(R.id.today);
  insert = findViewById(R.id.insert);
  all = findViewById(R.id.all);





        Intent insertIntent = new Intent(this , InsertPlan.class);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(insertIntent);
            }
        });
        Intent todayIntent = new Intent(this ,TodayPlans.class);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(todayIntent);
            }
        });
        Intent allIntent = new Intent(this ,AllPlans.class);
  all.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          startActivity(allIntent);
      }
  });

    }
}
