package com.example.mawfd.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mawfd.data.database.dao.AccountsDao;

import com.example.mawfd.data.database.dao.AppointmentDao;
import com.example.mawfd.data.database.entity.Appointment;

@Database(entities = {Appointment.class}, version = 1, exportSchema = false)
public abstract class AppointmentsDataBase extends RoomDatabase {
    private static volatile AppointmentsDataBase INSTANCE;

    public abstract AppointmentDao appointmentDao();

    public static AppointmentsDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppointmentsDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppointmentsDataBase.class, "appointments_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}