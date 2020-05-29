package com.pierre.cours.sensor;

import javax.swing.event.EventListenerList;

public abstract class Sensor {
    static int id = 0;
    String location;

    public EventListenerList listenerList = new EventListenerList();

    public Sensor(String location){
        this.location = location;
        id++;
    }
}

