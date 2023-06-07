package com.example.mawfd.data.protocols;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import com.example.mawfd.data.database.entity.Appointment;
import com.example.mawfd.data.database.entity.Doctor;

import java.util.List;


public interface AppointmentProtocol {
    LiveData<List<Appointment>> getAppointmentList();

    LiveData<Appointment> getAppointmentItem(int position);

    void addAppointment();
    void deleteAppointment(int id);
    void updateAppointment(
            int id,
            String doctorName,
            String doctorSpec,
            String PatientName,
            String PatientDiagnosis
    );
}
