package com.example.tp3_exercice6.dataModel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RegistrationDao {

    @Insert
    void insert(Registration registrations);

    @Query("SELECT * FROM register")
    LiveData<List<Registration>> getAllRegistration();

    @Query("SELECT * FROM register where nom LIKE :name")
    LiveData<Registration> getUserInfo(String name);
}
