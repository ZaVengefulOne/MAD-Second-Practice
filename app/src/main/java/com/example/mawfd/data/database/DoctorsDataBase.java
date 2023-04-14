package com.example.mawfd.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mawfd.data.database.dao.DoctorProfilesDao;
import com.example.mawfd.data.database.entity.DoctorListItem;

@Database(entities = {DoctorListItem.class}, version = 1, exportSchema = false)
public abstract class DoctorsDataBase extends RoomDatabase {
    private static volatile DoctorsDataBase INSTANCE;

    public abstract DoctorProfilesDao profileSettingDao();

    public static DoctorsDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DoctorsDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DoctorsDataBase.class, "settings_profile_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}