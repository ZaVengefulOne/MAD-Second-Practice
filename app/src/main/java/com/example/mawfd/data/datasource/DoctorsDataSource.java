package com.example.mawfd.data.datasource;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.data.database.entity.Mapper;
import com.example.mawfd.data.models.DoctorListItem;
import com.example.mawfd.data.database.DoctorsDataBase;
import com.example.mawfd.data.database.dao.DoctorProfilesDao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DoctorsDataSource {
    private final Context context;
    List<Doctor> doctors = new ArrayList<>();
    public DoctorsDataSource(Context context){
        this.context = context;
    }

    public LiveData<List<Doctor>> getDoctorList() {
        doctors.add(new Doctor(
                "Терапевт",
                "Пчёлкина Ирина Евгеньевна"
        ));
        doctors.add(new Doctor(
                "Отоларинголог",
                "Ларина Елена Викторовна"
        ));
        doctors.add(new Doctor(
                "Педиатр",
                "Вамбрейсов Валентин Тильтович"
        ));
        doctors.add(new Doctor(
                "Гастроэнтеролог",
                "Шаломеенко Андрей Алексеевич"
        ));
        doctors.add(new Doctor(
                "Офтальмолог",
                "Корпало Роман Анатольевич"
        ));
        doctors.add(new Doctor(
                "Кардиолог",
                "Ионова Полина Алексеевна"
        ));


        DoctorsDataBase db = DoctorsDataBase.getDatabase(context);
        DoctorProfilesDao DoctorDao = db.doctorProfilesDao();
//        Mapper mapper = new Mapper();
        db.getQueryExecutor().execute(new Runnable() {
            @Override
            public void run() {
                for (Doctor doctor : doctors){
                    DoctorDao.insert(doctor);
            }
        }
        });
        LiveData<List<Doctor>> listLiveData = DoctorDao.getDoctorList();
        /*MutableLiveData<List<DoctorListItem>> mutableLiveData = new MutableLiveData<>();
        if (listLiveData != null) {
            List<DoctorListItem> listLD = mapper.mapDoctorToDoctorListItem(listLiveData);
            mutableLiveData.setValue(listLD);
        }*/
        return listLiveData;
    }

    public LiveData<Doctor> getDoctorItem(int position) {
        DoctorsDataBase db = DoctorsDataBase.getDatabase(context);
        DoctorProfilesDao doctorProfilesDao = db.doctorProfilesDao();
        MutableLiveData<Doctor> liveData = new MutableLiveData<>();
        LiveData<Doctor> doctorLiveData = doctorProfilesDao.getItem(position + 1);
//        if (doctorLiveData != null) {
//            liveData.setValue(Mapper.mapDoctorListItemToDoctor(doctorLiveData.getValue()));
//        }
        return liveData;
    }
}
