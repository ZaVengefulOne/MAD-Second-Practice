package com.example.mawfd.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mawfd.data.database.dao.PatientDao;
import com.example.mawfd.data.database.entity.Patient;

@Database(entities = {Patient.class}, version = 1, exportSchema = false)
public abstract class PatientsDataBase extends RoomDatabase {
    private static volatile PatientsDataBase INSTANCE;
    public abstract PatientDao patientDao();
    public static PatientsDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PatientsDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PatientsDataBase.class, "patients_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}