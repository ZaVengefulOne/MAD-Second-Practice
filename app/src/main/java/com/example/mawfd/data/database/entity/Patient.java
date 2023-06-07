package com.example.mawfd.data.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patients_table")
public class Patient {

    @PrimaryKey(autoGenerate = true)
    public  int id;


    public  String name = "";
    public  String diagnosis = "";
    public  int age = 0;

    public String getName() {
        return name;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}
