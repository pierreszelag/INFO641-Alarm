package com.pierre.cours.sensor;

import com.pierre.cours.alarm.RadAlarm;
import com.pierre.cours.listener.RadListener;

import java.time.LocalDateTime;

public class RadSensor extends Sensor {
    int sensorId;

    public RadSensor(String location) {
        super(location);
        this.sensorId = id;
    }

    public void createRadAlarm(int criticality){
        String now = LocalDateTime.now().toString();
        RadAlarm radAlarm = new RadAlarm(sensorId, now, this.location, criticality);

        for(RadListener radListener : this.listenerList.getListeners(RadListener.class)) {
            radListener.runAlarm(radAlarm);
        }
    }

}
