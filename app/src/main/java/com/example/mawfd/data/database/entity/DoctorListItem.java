package com.example.mawfd.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "doctor_profiles_table")
public class DoctorListItem {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public Integer uid;
    private static String doctorSpec;
    private static String doctorName;


public DoctorListItem(String doctorSpec, String doctorName){
    this.doctorSpec = doctorSpec;
    this.doctorName = doctorName;
}


    public static String getDoctorSpec() {
        return doctorSpec;
    }

    public static String getDoctorName() {
        return doctorName;
    }
}
