package com.example.mawfd;

public class ScheduleListItem {
    private int resource;
    private String specialityName;

    public ScheduleListItem(int resource, String specialityName) {
        this.resource = resource;
        this.specialityName = specialityName;
    }

    public int getResource() {
        return resource;
    }

    public String getSpecialityName() {
        return specialityName;
    }
}
