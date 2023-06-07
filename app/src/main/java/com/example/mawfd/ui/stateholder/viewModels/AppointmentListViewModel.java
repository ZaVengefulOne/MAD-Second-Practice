package com.example.mawfd.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Appointment;
import com.example.mawfd.data.repositories.AppointmentRepository;

import java.util.List;

public class AppointmentListViewModel extends AndroidViewModel {

    private final AppointmentRepository repository = new AppointmentRepository(getApplication());
    public LiveData<List<Appointment>> listLiveData = repository.getAppointmentList();

    public AppointmentListViewModel(@NonNull Application application) {
        super(application);
    }

    public void addAppointment() {
        repository.addAppointment();
    }
}
