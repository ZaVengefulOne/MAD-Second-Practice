package com.example.mawfd.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "doctor_profiles_table")
public class Doctor {

    @PrimaryKey(autoGenerate = true)
    public Integer id;
    public String doctorSpec = "";
    public String doctorName = "";

//    public Doctor(String doctorSpec, String doctorName) {
//        this.doctorSpec = doctorSpec;
//        this.doctorName = doctorName;
//    }
    public String getDoctorSpec() {
        return doctorSpec;
    }

    public int getId() {
        return id;
    }
    public String getDoctorName() {
        return doctorName;
    }
}
