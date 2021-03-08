package com.example.tp3_exercice6.dataModel;

import android.widget.EditText;
import android.widget.TextView;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "register")
public class Registration {

    @PrimaryKey(autoGenerate = true)
        public long id;
    @ColumnInfo(name = "nom")
        public String nom;
    @ColumnInfo(name = "prenom")
        public String prenom ;
    @ColumnInfo(name = "age")
        public int age ;
    @ColumnInfo(name = "numero_telephone")
        public String ntel ;
    @ColumnInfo(name = "mot_de_passe")
        public String mPasse;

    public Registration(String nom, String prenom, int age, String ntel, String mPasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ntel = ntel;
        this.mPasse = mPasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNtel() {
        return ntel;
    }

    public void setNtel(String ntel) {
        this.ntel = ntel;
    }

    public String getmPasse() {
        return mPasse;
    }

    public void setmPasse(String mPasse) {
        this.mPasse = mPasse;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", ntel='" + ntel + '\'' +
                ", mPasse='" + mPasse + '\'' +
                '}';
    }
}
