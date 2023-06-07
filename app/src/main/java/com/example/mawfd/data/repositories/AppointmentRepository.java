package com.example.mawfd.data.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Appointment;
import com.example.mawfd.data.database.entity.Patient;
import com.example.mawfd.data.datasource.AppointmentDataSource;
import com.example.mawfd.data.datasource.PatientDataSource;
import com.example.mawfd.data.protocols.AppointmentProtocol;
import com.example.mawfd.data.protocols.PatientsProtocol;

import java.util.List;

public class AppointmentRepository implements AppointmentProtocol {

    private final AppointmentDataSource dataSource;

    public AppointmentRepository(Context context) {
        dataSource = new AppointmentDataSource(context);
    }

    @Override
    public LiveData<List<Appointment>> getAppointmentList() {
        return dataSource.getAppointments();
    }

    @Override
    public LiveData<Appointment> getAppointmentItem(int id) {
        return dataSource.getAppointmentItem(id);
    }

    @Override
    public void addAppointment() {
        dataSource.addAppointment();
    }

    @Override
    public void deleteAppointment(int id) {
        dataSource.deleteAppointment(id);
    }

    @Override
    public void updateAppointment(
            int id,
            String doctorName,
            String doctorSpec,
            String patientName,
            String patientDiagnosis
    ) {
        dataSource.updateAppointment(id, doctorName,doctorSpec, patientName, patientDiagnosis);
    }
}