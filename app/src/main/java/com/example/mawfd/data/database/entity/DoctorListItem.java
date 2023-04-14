package com.example.mawfd.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NonNls;

@Entity(tableName = "doctor_profiles_table")
public class DoctorListItem {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private static String doctorSpec;
    private static String doctorName;
    public Integer id;

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
