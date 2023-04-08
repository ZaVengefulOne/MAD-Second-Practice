package com.example.mawfd.ui.stateholder.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
//import androidx.lifecycle.ViewModel;

import com.example.mawfd.data.models.DoctorListItem;
import com.example.mawfd.data.repositories.DoctorsRepository;

import java.util.List;

public class StartFrameViewModel extends ViewModel {
    private final DoctorsRepository repository = new DoctorsRepository();

    public LiveData<List<DoctorListItem>> listLiveData = repository.getDoctorList();
}
