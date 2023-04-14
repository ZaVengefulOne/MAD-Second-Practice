package com.example.mawfd.data.datasource;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.mawfd.data.database.entity.DoctorListItem;
import com.example.mawfd.data.database.DoctorsDataBase;
import com.example.mawfd.data.database.dao.DoctorProfilesDao;
import com.example.mawfd.data.database.entity.DoctorListItem;

import java.util.ArrayList;
import java.util.List;

public class DoctorsDataSource {
    private final Context context;
    List<DoctorListItem> doctors = new ArrayList<>();
    public DoctorsDataSource(Context context){
        this.context = context;
    }

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
        DoctorsDataBase db = DoctorsDataBase.getDatabase(context);
        DoctorProfilesDao profileSettingDao = db.profileSettingDao();
        return profileSettingDao.getItem(position + 1);
    }
}
