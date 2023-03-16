package com.example.mawfd;

public class ScheduleListItem {
    private int resource;
    private String specialityName;

    public ScheduleListItem(int resource, String categoryTitle) {
        this.resource = resource;
        this.specialityName = categoryTitle;
    }

    public int getResource() {
        return resource;
    }

    public String getCategoryTitle() {
        return specialityName;
    }
}
