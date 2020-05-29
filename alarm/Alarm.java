package com.pierre.cours.alarm;

public abstract class Alarm {
    public static int idAlarm = 1;
    public int idSensor;
    public String date;
    public String location;
    public int criticality; //entre 1 et 3

    public Alarm(int idSensor, String date, String location, int criticality) {
        this.idSensor = idSensor;
        this.date = date;
        this.location = location;
        this.criticality = criticality;
        idAlarm++;
    }
}

