package com.example.mawfd.data.repositories;


import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.protocols.DoctorsProtocol;
import com.example.mawfd.data.datasource.DoctorsDataSource;
import com.example.mawfd.data.models.DoctorListItem;

import java.util.List;

public class DoctorsRepository implements DoctorsProtocol {

    private final Context context;
    private final DoctorsDataSource dataSource;

    public DoctorsRepository(Context context){
        this.context = context;
        dataSource = new DoctorsDataSource(context);
    }

    @Override
    public LiveData<List<Doctor>> getDoctorList() {
        return dataSource.getDoctorList();
    }

    @Override
    public LiveData<Doctor> getDoctorItem(int position) {
        return dataSource.getDoctorItem(position);
    }

}