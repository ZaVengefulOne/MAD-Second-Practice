package com.example.mawfd.ui.stateholder.viewModels;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mawfd.data.models.DoctorListItem;
import com.example.mawfd.data.repositories.DoctorsRepository;

public class DoctorListItemViewModel extends AndroidViewModel {
    private DoctorsRepository repository = new DoctorsRepository(getApplication());
    public LiveData<DoctorListItem> doctorListItemLiveData;

    public DoctorListItemViewModel(@NonNull Application application) {
        super(application);
    }

    public void getDoctorListItemLiveData(int position) {
        doctorListItemLiveData = repository.getDoctorItem(position);
    }
}
