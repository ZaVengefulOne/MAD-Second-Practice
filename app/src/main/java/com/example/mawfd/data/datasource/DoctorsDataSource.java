package com.example.mawfd.data.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.mawfd.data.models.DoctorListItem;

import java.util.ArrayList;
import java.util.List;

public class DoctorsDataSource {
    List<DoctorListItem> doctors = new ArrayList<>();

    public LiveData<List<DoctorListItem>> getDoctorList() {
        doctors.add(new DoctorListItem(
                "Терапевт",
                "Пчёлкина Ирина Евгеньевна"
        ));
        doctors.add(new DoctorListItem(
                "Отоларинголог",
                "Ларина Елена Викторовна"
        ));
        doctors.add(new DoctorListItem(
                "Педиатр",
                "Вамбрейсов Валентин Тильтович"
        ));
        doctors.add(new DoctorListItem(
                "Гастроэнтеролог",
                "Шаломеенко Андрей Алексеевич"
        ));
        doctors.add(new DoctorListItem(
                "Офтальмолог",
                "Корпало Роман Анатольевич"
        ));
        doctors.add(new DoctorListItem(
                "Кардиолог",
                "Ионова Полина Алексеевна"
        ));
        MutableLiveData<List<DoctorListItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(doctors);
        return mutableLiveData;
    }

    public LiveData<DoctorListItem> getDoctorItem(int position) {
        getDoctorList();
        MutableLiveData<DoctorListItem> data = new MutableLiveData<>();
        data.setValue(doctors.get(position));
        return data;
    }
}
