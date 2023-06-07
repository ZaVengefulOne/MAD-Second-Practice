package com.example.mawfd.data.database.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "appointments_table")
public class Appointment {

    @PrimaryKey(autoGenerate = true)
    public  int id;


    public  String doctorName = "";
    public  String doctorSpec = "";
    public  String patientName = "";
    public  String patientDiagnosis = "";


    public String getDoctorName() {
        return doctorName;
    }

    public String getDoctorSpec() {
        return doctorSpec;
    }

    public String getPatientName() {
        return patientName;
    }
    public String getPatientDiagnosis() {
        return patientDiagnosis;
    }

    public int getId() {
        return id;
    }
}
