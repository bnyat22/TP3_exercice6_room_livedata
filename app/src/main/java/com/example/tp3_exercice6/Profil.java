package com.example.tp3_exercice6;



import android.os.Bundle;
import android.util.Log;

import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3_exercice6.dataModel.RegisterAdapter;

import com.example.tp3_exercice6.dataModel.Registration;

import java.util.List;


public class Profil extends AppCompatActivity {
    TextView nom, prenom, age, ntel;
    private static final String NOM = "nom";
    private String name;
    public InscriptionModelView modelView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_activity);
        nom = findViewById(R.id.nomm);
        prenom = findViewById(R.id.prenome);
        age = findViewById(R.id.agee);
        ntel = findViewById(R.id.numero);


        Bundle extras = getIntent().getExtras();
        name = extras.getString(NOM);
        modelView = new ViewModelProvider(this).get(InscriptionModelView.class);


           modelView.getUserInfo(name).observe(this, new Observer<Registration>() {
               @Override
               public void onChanged(Registration registration) {


                   nom.setText(registration.getNom());
                   prenom.setText(registration.getPrenom());
                   age.setText(String.valueOf(registration.getAge()));
                   ntel.setText(String.valueOf(registration.getmPasse()));
               }
           });


    }




    }


