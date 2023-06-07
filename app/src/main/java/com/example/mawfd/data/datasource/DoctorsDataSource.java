package com.example.mawfd.data.datasource;

import android.content.Context;
import androidx.lifecycle.LiveData;


import com.example.mawfd.data.database.entity.Doctor;

import com.example.mawfd.data.database.DoctorsDataBase;
import com.example.mawfd.data.database.dao.DoctorProfilesDao;


import java.util.ArrayList;
import java.util.List;

public class DoctorsDataSource {
    private final Context context;
    private final DoctorsDataBase db;
    private final DoctorProfilesDao dao;
    List<Doctor> doctors = new ArrayList<>();
    public DoctorsDataSource(Context context){
        this.context = context;
        db = DoctorsDataBase.getDatabase(context);
        dao = db.doctorProfilesDao();
    }

//    public LiveData<List<Doctor>> getDoctorList() {
////        doctors.add(new Doctor(
////                "Терапевт",
////                "Пчёлкина Ирина Евгеньевна"
////        ));
////        doctors.add(new Doctor(
////                "Отоларинголог",
////                "Ларина Елена Викторовна"
////        ));
////        doctors.add(new Doctor(
////                "Педиатр",
////                "Вамбрейсов Валентин Тильтович"
////        ));
////        doctors.add(new Doctor(
////                "Гастроэнтеролог",
////                "Шаломеенко Андрей Алексеевич"
////        ));
////        doctors.add(new Doctor(
////                "Офтальмолог",
////                "Корпало Роман Анатольевич"
////        ));
////        doctors.add(new Doctor(
////                "Кардиолог",
////                "Ионова Полина Алексеевна"
////        ));
//
//
//        DoctorsDataBase db = DoctorsDataBase.getDatabase(context);
//        DoctorProfilesDao DoctorDao = db.doctorProfilesDao();
//        db.getQueryExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//                for (Doctor doctor : doctors){
//                    DoctorDao.insert(doctor);
//            }
//        }
//        });
//        LiveData<List<Doctor>> listLiveData = DoctorDao.getDoctorList();
//        return listLiveData;
//    }

    public LiveData<List<Doctor>> getDoctorsList() {
        return dao.getDoctorList();
    }

    public void addDoctor() {
        db.getQueryExecutor().execute(() -> dao.insert(new Doctor()));
    }

//    public LiveData<Doctor> getDoctorItem(int position) {
//        DoctorsDataBase db = DoctorsDataBase.getDatabase(context);
//        DoctorProfilesDao doctorProfilesDao = db.doctorProfilesDao();
//        MutableLiveData<Doctor> liveData = new MutableLiveData<>();
//        LiveData<Doctor> doctorLiveData = doctorProfilesDao.getItem(position + 1);
////        if (doctorLiveData != null) {
////            liveData.setValue(Mapper.mapDoctorListItemToDoctor(doctorLiveData.getValue()));
////        }
//        return liveData;
//    }
    public LiveData<Doctor> getDoctorItem(int id) {
    return dao.getItem(id);
}
    public void deleteDoctor(int id) {
        db.getQueryExecutor().execute(() -> dao.delete(id));
    }
    public void updateDoctor(
            int id,
            String doctorName,
            String doctorSpec
    ) {
        db.getQueryExecutor().execute(() ->
                dao.update(id, doctorName, doctorSpec)
        );
    }
}
