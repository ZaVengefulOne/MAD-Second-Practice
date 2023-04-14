package com.example.mawfd.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.DoctorListItem;

import java.util.List;

public interface DoctorsProtocol {
    LiveData<List<DoctorListItem>> getDoctorList();

    LiveData<DoctorListItem> getDoctorItem(int position);

}
