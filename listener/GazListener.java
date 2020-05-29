package com.pierre.cours.listener;

import com.pierre.cours.alarm.GazAlarm;

public interface GazListener extends Listener {
    void runAlarm(GazAlarm alarm);
}
