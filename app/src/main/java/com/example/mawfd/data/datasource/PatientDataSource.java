package com.example.mawfd.data.datasource;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.PatientsDataBase;
import com.example.mawfd.data.database.dao.PatientDao;
import com.example.mawfd.data.database.entity.Patient;

import java.util.List;

public class PatientDataSource {

    private final PatientsDataBase db;
    private final PatientDao  dao;

    public PatientDataSource(Context context) {
        db = PatientsDataBase.getDatabase(context);
        dao = db.patientDao();
    }

    public LiveData<List<Patient>> getPatients() {
        return dao.getPatients();
    }

    public LiveData<Patient> getPatientItem(int id) {
        return dao.getItem(id);
    }

    public void addPatient() {
        db.getQueryExecutor().execute(() -> dao.insert(new Patient()));
    }

    public void deletePatient(int id) {
        db.getQueryExecutor().execute(() -> dao.delete(id));
    }

    public void updatePatient(
            int id,
            String name,
            String diagnosis,
            int age
    ) {
        db.getQueryExecutor().execute(() ->
                dao.update(id, name, diagnosis, age)
        );
    }
}