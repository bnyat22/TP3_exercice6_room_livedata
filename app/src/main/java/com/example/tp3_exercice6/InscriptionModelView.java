package com.example.tp3_exercice6;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3_exercice6.dataModel.RegisterRepository;
import com.example.tp3_exercice6.dataModel.Registration;

import java.util.List;

public class InscriptionModelView extends AndroidViewModel {
    private RegisterRepository registerRepository;
    LiveData<List<Registration>> allUsers;
    public InscriptionModelView(@NonNull Application application) {
        super(application);

        registerRepository = new RegisterRepository(application);
        allUsers = registerRepository.getAllUsers();
    }
    public void insert(Registration registration)
    {
        registerRepository.insert(registration);
    }
    public LiveData<Registration> getUserInfo(String name)
    {

      return   registerRepository.getUserInfo(name);

    }
    LiveData<List<Registration>> getAllUsers() { return allUsers; }
}
