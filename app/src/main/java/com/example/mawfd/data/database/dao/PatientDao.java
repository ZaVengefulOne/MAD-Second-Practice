package com.example.mawfd.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mawfd.data.database.entity.Patient;

import java.util.List;

@Dao
public interface PatientDao {

    @Query("SELECT * FROM patients_table")
    LiveData<List<Patient>> getPatients();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Patient patient);

    @Query("DELETE FROM patients_table WHERE :id = id")
    void delete(int id);

    @Query("SELECT * FROM patients_table WHERE :id = id")
    LiveData<Patient> getItem(int id);

    @Query("UPDATE patients_table SET age = :age, name = :name, diagnosis = :diagnosis WHERE id = :id")
    void update(
            int id,
            String name,
            String diagnosis,
            int age
    );
}
