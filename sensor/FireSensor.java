package com.pierre.cours.sensor;

import com.pierre.cours.alarm.FireAlarm;
import com.pierre.cours.listener.FireListener;

import java.time.LocalDateTime;

public class FireSensor extends Sensor {
    int sensorId;

    public FireSensor(String location){
        super(location);
        this.sensorId = id;
    }

    public void createFireAlarm(int criticality){
        String now = LocalDateTime.now().toString();
        FireAlarm fireAlarm = new FireAlarm(sensorId, now, this.location, criticality);

        for(FireListener fireListener : this.listenerList.getListeners(FireListener.class)) {
            fireListener.runAlarm(fireAlarm);
        }
    }
}
