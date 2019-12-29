package com.example.alarm.data.alarm;


import com.example.alarm.data.viewmodel.Reminder;

import io.reactivex.Observable;

/**
 * This interface describes the responsibilities and interactions between
 * Presenters and The ReminderRepository class.
 *
 */

public interface AlarmSource {

    Observable setAlarm(Reminder reminder);

    Observable cancelAlarm(Reminder reminder);

    Observable dismissAlarm();

    Observable startAlarm(Reminder reminder);
}
