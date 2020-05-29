package com.pierre.cours;

import com.pierre.cours.listener.*;
import com.pierre.cours.monitor.*;
import com.pierre.cours.sensor.*;

public class Main {

    public static void main(String[] args) {
        //TEST Event Model
        MonitorA monitorA = new MonitorA();
        MonitorB monitorB = new MonitorB();

        FireSensor fireSensor = new FireSensor("salle 01");
        GazSensor gazSensor = new GazSensor("salle 02");
        RadSensor radSensor = new RadSensor("salle 03");

        fireSensor.listenerList.add(FireListener.class, monitorA);
        gazSensor.listenerList.add(GazListener.class, monitorA);
        gazSensor.listenerList.add(GazListener.class, monitorB);
        radSensor.listenerList.add(RadListener.class, monitorB);

        fireSensor.createFireAlarm(2);
        gazSensor.createGazAlarm(1);
        radSensor.createRadAlarm(3);


        //TEST Simulation window
        SimulationGUI simu = new SimulationGUI();

    }
}
