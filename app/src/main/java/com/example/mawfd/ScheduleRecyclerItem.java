package com.example.mawfd;

public class ScheduleRecyclerItem {
    private int resource;
    private String specialityName;

    public ScheduleRecyclerItem(int resource, String specialityName) {
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
