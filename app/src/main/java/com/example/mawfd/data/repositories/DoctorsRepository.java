package com.example.mawfd.data.repositories;


import androidx.lifecycle.LiveData;

import com.example.mawfd.data.protocols.DoctorsProtocol;
import com.example.mawfd.data.datasource.DoctorsDataSource;
import com.example.mawfd.data.models.DoctorListItem;

import java.util.List;

public class DoctorsRepository implements DoctorsProtocol {

    private final DoctorsDataSource dataSource = new DoctorsDataSource();

    @Override
    public LiveData<List<DoctorListItem>> getDoctorList() {
        return dataSource.getDoctorList();
    }

    @Override
    public LiveData<DoctorListItem> getProfileItem(int position) {
        return dataSource.getDoctorItem(position);
    }

}