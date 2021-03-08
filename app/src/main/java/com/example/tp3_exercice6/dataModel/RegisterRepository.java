package com.example.tp3_exercice6.dataModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class RegisterRepository {
    private RegistrationDao registrationDao;
    private LiveData<List<Registration>> allUsers;
   // private LiveData<Registration> user;

    public RegisterRepository(Application application) {
        myDatabase database = myDatabase.getInstance(application);
        registrationDao = database.registrationDao();
        allUsers = registrationDao.getAllRegistration();

    }
    public LiveData<List<Registration>> getAllUsers()
    {
        return allUsers;
    }
    public void insert(Registration registration)
    {
    new InsertUserAsyncTask(registrationDao).execute(registration);
    }
    public LiveData<Registration> getUserInfo(String name)
    {
       return registrationDao.getUserInfo(name);

    }

    //elle est deprecated mais quand même ça marche à l'instant
    private static class InsertUserAsyncTask extends AsyncTask<Registration ,Void ,Void> {

        private RegistrationDao registrationDao;
        private InsertUserAsyncTask(RegistrationDao registrationDao )
        {


            this.registrationDao = registrationDao;
        }




        @Override
        protected Void doInBackground(Registration... registrations) {
            registrationDao.insert(registrations[0]);
            return null;
        }


    }
    private static class getUserAsyncTask extends AsyncTask<String ,Void ,Void> {

        private RegistrationDao registrationDao;
        private getUserAsyncTask(RegistrationDao registrationDao )
        {


            this.registrationDao = registrationDao;
        }




        @Override
        protected Void doInBackground(String... names) {
            registrationDao.getUserInfo(names[0]);
            return null;
        }


    }
}
