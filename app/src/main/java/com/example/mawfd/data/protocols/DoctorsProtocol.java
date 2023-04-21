package com.example.mawfd.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.models.DoctorListItem;

import java.util.List;

public interface DoctorsProtocol {
    LiveData<List<Doctor>> getDoctorList();

    LiveData<Doctor> getDoctorItem(int position);

}
