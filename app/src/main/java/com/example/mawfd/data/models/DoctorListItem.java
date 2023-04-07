package com.example.mawfd.data.models;

public class DoctorListItem {
    private int doctorIcon;
    private String doctorSpec;
    private String doctorName;

    public DoctorListItem(int doctorIcon, String doctorSpec, String doctorName){
        this.doctorIcon = doctorIcon;
        this.doctorSpec = doctorSpec;
        this.doctorName = doctorName;
    }

    public int getDoctorIcon() {
        return doctorIcon;
    }

    public String getDoctorSpec() {
        return doctorSpec;
    }

    public String getDoctorName() {
        return doctorName;
    }
}
