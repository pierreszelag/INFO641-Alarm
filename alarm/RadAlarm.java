package com.pierre.cours.alarm;

public class RadAlarm extends Alarm {
    int radlvl; //entre 1 et 100
    public RadAlarm(int idSensor, String date, String location, int criticality) {
        super(idSensor, date, location, criticality);
    }
}
