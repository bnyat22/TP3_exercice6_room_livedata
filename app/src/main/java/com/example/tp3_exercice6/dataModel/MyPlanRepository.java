package com.example.tp3_exercice6.dataModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyPlanRepository {
    private MyPlanDoa myPlanDoa;
    private LiveData<List<MyPlan>> allPlans;


    public MyPlanRepository(Application application) {
        myDatabase database = myDatabase.getInstance(application);
        myPlanDoa = database.myPlanDoa();
        allPlans = myPlanDoa.getAllPlanning();

    }

    public LiveData<List<MyPlan>> getAllPlans() {
        return allPlans;
    }

    public void insert(MyPlan myPlan) {
        new InsertUserAsyncTask(myPlanDoa).execute(myPlan);
    }

    public LiveData<MyPlan> getTodayPlans(String today) {
        return myPlanDoa.getPlanningDay(today);

    }

    //elle est deprecated mais quand même ça marche à l'instant
    private static class InsertUserAsyncTask extends AsyncTask<MyPlan, Void, Void> {

        private MyPlanDoa myPlanDoa;

        private InsertUserAsyncTask(MyPlanDoa myPlanDoa) {


            this.myPlanDoa = myPlanDoa;
        }


        @Override
        protected Void doInBackground(MyPlan... myPlans) {
            myPlanDoa.insert(myPlans[0]);
            return null;
        }


    }


}