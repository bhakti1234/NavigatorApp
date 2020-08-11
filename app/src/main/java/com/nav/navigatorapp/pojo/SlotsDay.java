package com.nav.navigatorapp.pojo;

public class SlotsDay {
    String day,number_of_slots;

    public SlotsDay(String day, String number_of_slots)
    {
        this.day=day;
        this.number_of_slots=number_of_slots;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getNumber_of_slots() {
        return number_of_slots;
    }

    public void setNumber_of_slots(String number_of_slots) {
        this.number_of_slots = number_of_slots;
    }
}
