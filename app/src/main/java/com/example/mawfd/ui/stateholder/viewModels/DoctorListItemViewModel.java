package com.example.mawfd.ui.stateholder.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mawfd.data.datasource.DoctorsDataSource;
import com.example.mawfd.data.models.DoctorListItem;
import com.example.mawfd.data.repositories.DoctorsRepository;

public class DoctorListItemViewModel extends ViewModel {
    private DoctorsRepository repository = new DoctorsRepository();
    public LiveData<DoctorListItem> doctorListItemLiveData;

    public void getDoctorListItemLiveData(int position) {
        doctorListItemLiveData = repository.getProfileItem(position);
    }
}
