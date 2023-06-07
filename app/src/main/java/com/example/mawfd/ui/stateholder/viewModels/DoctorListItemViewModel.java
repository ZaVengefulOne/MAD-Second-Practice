package com.example.mawfd.ui.stateholder.viewModels;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.models.DoctorListItem;
import com.example.mawfd.data.repositories.DoctorsRepository;

public class DoctorListItemViewModel extends AndroidViewModel {
    private DoctorsRepository repository = new DoctorsRepository(getApplication());
    public LiveData<Doctor> doctorListItemLiveData;

    public DoctorListItemViewModel(@NonNull Application application) {
        super(application);
    }

    public void getDoctorItem(int id) {
        doctorListItemLiveData = repository.getDoctorItem(id);
    }

    public void deleteDoctor(int id) {
        repository.deleteDoctor(id);
    }

    public void updatePatient(int id, String doctorName, String doctorSpec){
        repository.updateDoctor(id, doctorName, doctorSpec);
    }
}
