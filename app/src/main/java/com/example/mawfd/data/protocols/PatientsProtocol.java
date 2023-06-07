package com.example.mawfd.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Patient;

import java.util.List;

public interface PatientsProtocol {
    LiveData<List<Patient>> getPatientsList();
    LiveData<Patient> getPatientsItem(int position);
    void addPatient();
    void deletePatient(int id);
    void updatePatient(
            int id,
            String name,
            String diagnosis,
            int age
    );
}
