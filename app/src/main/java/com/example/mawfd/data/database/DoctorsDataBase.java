package com.example.mawfd.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mawfd.data.database.dao.DoctorProfilesDao;
import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.models.DoctorListItem;

@Database(entities = {Doctor.class}, version = 1, exportSchema = false)
public abstract class DoctorsDataBase extends RoomDatabase {
    private static volatile DoctorsDataBase INSTANCE;

    public abstract DoctorProfilesDao doctorProfilesDao();

    public static DoctorsDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DoctorsDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DoctorsDataBase.class, "doctors_profile_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}