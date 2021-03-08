package com.example.tp3_exercice6.dataModel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyPlanDoa {
    @Insert
    void insert(MyPlan myPlan);

    @Query("SELECT * FROM planning")
    LiveData<List<MyPlan>> getAllPlanning();

    @Query("SELECT * FROM planning where dates LIKE :today")
    LiveData<MyPlan> getPlanningDay(String today);
}
