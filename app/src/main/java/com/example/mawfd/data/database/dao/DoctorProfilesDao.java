package com.example.mawfd.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mawfd.data.database.entity.DoctorListItem;
import java.util.List;

@Dao
public interface DoctorProfilesDao {
    @Query("SELECT * FROM doctor_profiles_table")
    LiveData<List<DoctorListItem>> getProfileSettingList();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(DoctorListItem profileSettingListItem);
    @Query("SELECT * FROM doctor_profiles_table WHERE :id LIKE id")
    LiveData<DoctorListItem> getItem(int id);
}
