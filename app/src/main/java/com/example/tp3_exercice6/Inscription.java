package com.example.tp3_exercice6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tp3_exercice6.R;
import com.example.tp3_exercice6.dataModel.RegisterRepository;
import com.example.tp3_exercice6.dataModel.Registration;
import com.example.tp3_exercice6.dataModel.myDatabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.UUID;

public class Inscription extends AppCompatActivity {

    EditText nom , prenom , age , ntel , mPasse;
    TextView id;
    Button sub , plan;

    private static int compte =0;
    private static final String PRENOM = "prenom";
    private static final String NOM = "nom";
    private static final String AGE = "age";
    private static final String NTEL = "tel";
    private static final String ID = "id";


    private InscriptionModelView inscriptionView;
    private Registration registration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom =  findViewById(R.id.nom);
        prenom =  findViewById(R.id.prenom);
        age =  findViewById(R.id.age);
        ntel =  findViewById(R.id.nTel);
        id = findViewById(R.id.identite);
        sub =  findViewById(R.id.sub);
        plan =  findViewById(R.id.plan);
        mPasse = findViewById(R.id.mPasse);
        if (savedInstanceState != null)
        {
            nom.setText(savedInstanceState.getString(NOM));
            prenom.setText(savedInstanceState.getString(PRENOM));
            age.setText(savedInstanceState.getString(AGE));
            ntel.setText(savedInstanceState.getString(NTEL));
            id.setText(savedInstanceState.getString(ID));

        }
        if (id.getText().toString().equals(""))
        {
            id.setText(generateId());
        }

        getLifecycle().addObserver(new LifeCycleAware());

inscriptionView = new ViewModelProvider(this).get(InscriptionModelView.class);


        final Intent intent = new Intent(this,Profil.class);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registration = new Registration(nom.getText().toString().trim() ,
                        prenom.getText().toString().trim(),
                         Integer.parseInt(age.getText().toString()),
                        ntel.getText().toString() ,
                        mPasse.getText().toString().trim());
                inscriptionView.insert(registration);
                intent.putExtra(NOM , nom.getText().toString().trim());
                startActivity(intent);


            }
        });
        Intent plans = new Intent(this , MainPlanning.class);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(plans);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putString(NOM , nom.getText().toString());
        outState.putString(PRENOM , prenom.getText().toString());
        outState.putString(AGE , age.getText().toString());
        outState.putString(NTEL , ntel.getText().toString());
        outState.putString(ID ,id.getText().toString());

    }

    private String generateId()
    {
        // String secure = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        String secure = UUID.randomUUID().toString();
        return secure;
    }
    public static int getCompte()
    {
        return compte++;
    }

}
