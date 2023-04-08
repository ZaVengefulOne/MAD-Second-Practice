package com.example.mawfd.data.models;

public class DoctorListItem {
    private static String doctorSpec;
    private static String doctorName;

    public DoctorListItem(String doctorSpec, String doctorName){
        this.doctorSpec = doctorSpec;
        this.doctorName = doctorName;
    }



    public static String getDoctorSpec() {
        return doctorSpec;
    }

    public static String getDoctorName() {
        return doctorName;
    }
}
