package com.pierre.cours.alarm;

public class GazAlarm extends Alarm {
    String gazType;
    public GazAlarm(int idSensor, String date, String location, int criticality) {
        super(idSensor, date, location, criticality);
    }
}