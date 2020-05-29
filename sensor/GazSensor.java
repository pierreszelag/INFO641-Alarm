package com.pierre.cours.sensor;

import com.pierre.cours.alarm.GazAlarm;
import com.pierre.cours.listener.GazListener;

import java.time.LocalDateTime;

public class GazSensor extends Sensor {
    int sensorId;

    public GazSensor(String location) {
        super(location);
        this.sensorId = id;
    }

    public void createGazAlarm(int criticality){
        String now = LocalDateTime.now().toString();
        GazAlarm gazAlarm = new GazAlarm(sensorId, now, this.location, criticality);

        for(GazListener gazListener : this.listenerList.getListeners(GazListener.class)) {
            gazListener.runAlarm(gazAlarm);
        }
    }

}
