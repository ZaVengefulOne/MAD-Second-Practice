package com.example.mawfd.data.database.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mawfd.data.models.DoctorListItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Mapper {
    public static DoctorListItem mapDoctorListItemToDoctor(Doctor doctor) {
        DoctorListItem doctorListItem = new DoctorListItem(
                doctor.doctorSpec,
                doctor.doctorName
        );
        return doctorListItem;
    }

    public static List<DoctorListItem> mapDoctorToDoctorListItem(List<Doctor> doctorList) {
        List<DoctorListItem> doctorListItemList = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            DoctorListItem doctorListItem = mapDoctorListItemToDoctor(doctor);
            doctorListItemList.add(doctorListItem);
        }
        return doctorListItemList;
    }
}
