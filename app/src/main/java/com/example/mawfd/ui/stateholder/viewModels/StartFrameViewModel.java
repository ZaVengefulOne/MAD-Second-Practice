package com.example.mawfd.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mawfd.data.models.DoctorListItem;
import com.example.mawfd.data.repositories.DoctorsRepository;

import java.util.List;

public class StartFrameViewModel extends AndroidViewModel {
    private final DoctorsRepository repository = new DoctorsRepository(getApplication());

    public LiveData<List<DoctorListItem>> listLiveData = repository.getDoctorList();

    public StartFrameViewModel(@NonNull Application application) {
        super(application);
    }
}
