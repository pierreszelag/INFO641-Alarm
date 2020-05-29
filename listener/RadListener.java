package com.pierre.cours.listener;

import com.pierre.cours.alarm.RadAlarm;

public interface RadListener extends Listener {
    void runAlarm(RadAlarm alarm);
}
