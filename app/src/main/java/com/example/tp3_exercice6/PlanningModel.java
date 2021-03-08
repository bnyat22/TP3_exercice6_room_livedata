package com.example.tp3_exercice6;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3_exercice6.dataModel.MyPlan;
import com.example.tp3_exercice6.dataModel.MyPlanRepository;
import com.example.tp3_exercice6.dataModel.RegisterRepository;
import com.example.tp3_exercice6.dataModel.Registration;

import java.util.List;

public class PlanningModel extends AndroidViewModel {
    private MyPlanRepository myPlanRepository;
    LiveData<List<MyPlan>> allPlans;
    public PlanningModel(@NonNull Application application) {
        super(application);

        myPlanRepository = new MyPlanRepository(application);
        allPlans = myPlanRepository.getAllPlans();
    }
    public void insert(MyPlan myPlan)
    {
        myPlanRepository.insert(myPlan);
    }
    public LiveData<MyPlan> getTodayPlans(String today)
    {

        return   myPlanRepository.getTodayPlans(today);

    }
    LiveData<List<MyPlan>> getAllPlans() { return allPlans; }
}
