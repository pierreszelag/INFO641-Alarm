package com.pierre.cours.monitor;

import com.pierre.cours.alarm.*;
import com.pierre.cours.listener.*;

import java.util.ArrayList;

public class MonitorB extends Monitor implements GazListener, RadListener {

    ArrayList<Alarm> alarmList = new ArrayList<Alarm>();

    @Override
    public void runAlarm(GazAlarm alarm) {
        System.out.println("\n!! GAZ ALARM !!");
        System.out.println("Sensor ID : " + alarm.idSensor);
        System.out.println("Location : " + alarm.location);
        System.out.println("Date : " + alarm.date);
        System.out.println("Criticality : " + alarm.criticality);
        this.alarmList.add(alarm);
    }

    @Override
    public void runAlarm(RadAlarm alarm) {
        System.out.println("\n!! RAD ALARM !!");
        System.out.println("Sensor ID : " + alarm.idSensor);
        System.out.println("Location : " + alarm.location);
        System.out.println("Date : " + alarm.date);
        System.out.println("Criticality : " + alarm.criticality);
        this.alarmList.add(alarm);
    }
}
