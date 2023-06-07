package com.example.mawfd.data.datasource;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.AppointmentsDataBase;
import com.example.mawfd.data.database.PatientsDataBase;
import com.example.mawfd.data.database.dao.AppointmentDao;
import com.example.mawfd.data.database.dao.PatientDao;
import com.example.mawfd.data.database.entity.Appointment;
import com.example.mawfd.data.database.entity.Patient;

import java.util.List;

public class AppointmentDataSource {

    private final AppointmentsDataBase db;
    private final AppointmentDao dao;

    public AppointmentDataSource(Context context) {
        db = AppointmentsDataBase.getDatabase(context);
        dao = db.appointmentDao();
    }

    public LiveData<List<Appointment>> getAppointments() {
        return dao.getAppointments();
    }

    public LiveData<Appointment> getAppointmentItem(int id) {
        return dao.getItem(id);
    }

    public void addAppointment() {
        db.getQueryExecutor().execute(() -> dao.insert(new Appointment()));
    }

    public void deleteAppointment(int id) {
        db.getQueryExecutor().execute(() -> dao.delete(id));
    }

    public void updateAppointment(
            int id,
            String doctorName,
            String doctorSpec,
            String patientName,
            String patientDiagnosis
    ) {
        db.getQueryExecutor().execute(() ->
                dao.update(id, doctorName, doctorSpec, patientName, patientDiagnosis)
        );
    }
}