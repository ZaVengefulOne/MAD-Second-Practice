package com.example.mawfd.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mawfd.data.database.entity.Appointment;
import com.example.mawfd.data.database.entity.Patient;

import java.util.List;

@Dao
public interface AppointmentDao {

    @Query("SELECT * FROM appointments_table")
    LiveData<List<Appointment>> getAppointments();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Appointment appointment);

    @Query("DELETE FROM appointments_table WHERE :id = id")
    void delete(int id);

    @Query("SELECT * FROM appointments_table WHERE :id = id")
    LiveData<Appointment> getItem(int id);

    @Query("UPDATE appointments_table SET doctorName = :doctorName, doctorSpec = :doctorSpec, patientName = :patientName, patientDiagnosis = :patientDiagnosis WHERE id = :id")
    void update(
            int id,
            String doctorName,
            String doctorSpec,
            String patientName,
            String patientDiagnosis
    );
}