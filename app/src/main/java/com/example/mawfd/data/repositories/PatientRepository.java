package com.example.mawfd.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Patient;
import com.example.mawfd.data.datasource.PatientDataSource;
import com.example.mawfd.data.protocols.PatientsProtocol;

import java.util.List;

public class PatientRepository implements PatientsProtocol {

    private final PatientDataSource dataSource;

    public PatientRepository(Context context) {
        dataSource = new PatientDataSource(context);
    }

    @Override
    public LiveData<List<Patient>> getPatientsList() {
        return dataSource.getPatients();
    }

    @Override
    public LiveData<Patient> getPatientsItem(int id) {
        return dataSource.getPatientItem(id);
    }

    @Override
    public void addPatient() {
        dataSource.addPatient();
    }

    @Override
    public void deletePatient(int id) {
        dataSource.deletePatient(id);
    }

    @Override
    public void updatePatient(
            int id,
            String name,
            String diagnosis,
            int age
    ) {
        dataSource.updatePatient(id, name, diagnosis, age);
    }
}