package com.example.mawfd.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Patient;
import com.example.mawfd.data.repositories.PatientRepository;

public class PatientFragmentViewModel extends AndroidViewModel {
    private final PatientRepository repository = new PatientRepository(getApplication());
    public LiveData<Patient> patientLiveData;

    public PatientFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public void getPatientItem(int id) {
        patientLiveData = repository.getPatientsItem(id);
    }

    public void deletePatient(int id) {
        repository.deletePatient(id);
    }

    public void updatePatient(int id, String name, String diagnosis, int age){
        repository.updatePatient(id, name, diagnosis, age);
    }
}
