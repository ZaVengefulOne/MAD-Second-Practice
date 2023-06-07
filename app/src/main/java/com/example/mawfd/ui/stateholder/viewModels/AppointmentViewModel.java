package com.example.mawfd.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Appointment;
import com.example.mawfd.data.database.entity.Patient;
import com.example.mawfd.data.repositories.AppointmentRepository;
import com.example.mawfd.data.repositories.PatientRepository;

public class AppointmentViewModel extends AndroidViewModel {
    private final AppointmentRepository repository = new AppointmentRepository(getApplication());
    public LiveData<Appointment> appointmentLiveData;

    public AppointmentViewModel(@NonNull Application application) {
        super(application);
    }

    public void getAppointmentItem(int id) {
        appointmentLiveData = repository.getAppointmentItem(id);
    }

    public void deleteAppointment(int id) {
        repository.deleteAppointment(id);
    }

    public void updateAppointment(int id, String doctorName, String doctorSpec, String patientName, String patienDiagnosis){
        repository.updateAppointment(id, doctorName, doctorSpec, patientName, patienDiagnosis);
    }
}
