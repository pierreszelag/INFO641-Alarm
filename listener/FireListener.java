package com.pierre.cours.listener;

import com.pierre.cours.alarm.FireAlarm;

public interface FireListener extends Listener {
    void runAlarm(FireAlarm alarm);
}
