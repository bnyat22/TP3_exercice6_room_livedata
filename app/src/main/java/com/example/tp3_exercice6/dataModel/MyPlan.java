package com.example.tp3_exercice6.dataModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "planning")
public class MyPlan {
    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(name = "dates")
    public String dates;
    @ColumnInfo(name = "huit_heure")
    String huit;
    @ColumnInfo(name = "dix_heure")
    String dix;
    @ColumnInfo(name = "douze_heure")
    String douze;
    @ColumnInfo(name = "quatre_heure")
    String quatre;

    public MyPlan(String dates, String huit, String dix, String douze, String quatre) {
        this.dates = dates;
        this.huit = huit;
        this.dix = dix;
        this.douze = douze;
        this.quatre = quatre;
    }

    public String getHuit() {
        return huit;
    }

    public void setHuit(String huit) {
        this.huit = huit;
    }

    public String getDix() {
        return dix;
    }

    public void setDix(String dix) {
        this.dix = dix;
    }

    public String getDouze() {
        return douze;
    }

    public void setDouze(String douze) {
        this.douze = douze;
    }

    public String getQuatre() {
        return quatre;
    }

    public void setQuatre(String quatre) {
        this.quatre = quatre;
    }

    @Override
    public String toString() {
        return "MyPlan{" +
                "dates='" + dates + '\'' +
                ", huit='" + huit + '\'' +
                ", dix='" + dix + '\'' +
                ", douze='" + douze + '\'' +
                ", quatre='" + quatre + '\'' +
                '}';
    }
}
