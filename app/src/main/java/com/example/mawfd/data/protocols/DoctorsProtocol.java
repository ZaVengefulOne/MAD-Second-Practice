package com.example.mawfd.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.mawfd.data.models.DoctorListItem;

import java.util.List;

public interface DoctorsProtocol {
    LiveData<List<DoctorListItem>> getUserSettingsList();

        LiveData<DoctorListItem> getProfileItem(int position);

}
