package com.nav.navigatorapp.pojo;

import java.util.ArrayList;

public class Slots {
    ArrayList<String> morning,afternoon,evening,night;
    String day;
    public Slots(String day)
    {
        this.day=day;
        morning=new ArrayList<>();
        afternoon=new ArrayList<>();
        evening=new ArrayList<>();
        night=new ArrayList<>();
        for (int i=0;i<10;i++)
        {
            morning.add("10:30 AM");
            afternoon.add("12:10 PM");
            evening.add("05:30 PM");
            night.add("08:10 PM");
        }
    }

    public void addSlots()
    {

    }

    public ArrayList<String> getMorning() {
        return morning;
    }

    public void setMorning(ArrayList<String> morning) {
        this.morning = morning;
    }

    public ArrayList<String> getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(ArrayList<String> afternoon) {
        this.afternoon = afternoon;
    }

    public ArrayList<String> getEvening() {
        return evening;
    }

    public void setEvening(ArrayList<String> evening) {
        this.evening = evening;
    }

    public ArrayList<String> getNight() {
        return night;
    }

    public void setNight(ArrayList<String> night) {
        this.night = night;
    }
}
