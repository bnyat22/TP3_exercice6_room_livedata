package com.example.tp3_exercice6.dataModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Registration.class,MyPlan.class} , version = 2)
public abstract class myDatabase extends RoomDatabase {
    private static myDatabase instance;

    public abstract RegistrationDao registrationDao();
    public abstract MyPlanDoa myPlanDoa();

    public static synchronized myDatabase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(application.getApplicationContext(),
                    myDatabase.class, "my_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }



}

