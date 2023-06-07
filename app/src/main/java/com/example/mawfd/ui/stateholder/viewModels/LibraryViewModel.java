package com.example.mawfd.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Patient;
import com.example.mawfd.data.repositories.PatientRepository;

import java.util.List;

public class LibraryViewModel extends AndroidViewModel {

    private final PatientRepository repository = new PatientRepository(getApplication());
    public LiveData<List<Patient>> listLiveData = repository.getPatientsList();

    public LibraryViewModel(@NonNull Application application) {
        super(application);
    }

    public void addPatient() {
        repository.addPatient();
    }
}
