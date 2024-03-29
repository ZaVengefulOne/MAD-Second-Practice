package com.example.mawfd.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mawfd.data.database.entity.Doctor;
import java.util.List;

@Dao
public interface DoctorProfilesDao {
    @Query("SELECT * FROM doctor_profiles_table")
    LiveData<List<Doctor>> getDoctorList();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Doctor doctor);
    @Query("SELECT * FROM doctor_profiles_table WHERE :id LIKE id")
    LiveData<Doctor> getItem(int id);

    @Query("DELETE FROM doctor_profiles_table WHERE :id = id")
    void delete(int id);
    @Query("UPDATE doctor_profiles_table SET doctorName = :doctorName, doctorSpec = :doctorSpec WHERE id = :id")
    void update(
            int id,
            String doctorName,
            String doctorSpec
    );
}
