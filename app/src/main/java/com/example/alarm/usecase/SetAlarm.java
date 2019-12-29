package com.example.alarm.usecase;

import com.example.alarm.data.alarm.AlarmService;
import com.example.alarm.data.viewmodel.Reminder;

import io.reactivex.Observable;

public class SetAlarm implements UseCase.RequestModel {

    private final AlarmService alarmService;

    public SetAlarm(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @Override
    public Observable runUseCase(Reminder reminder) {
        return alarmService.setAlarm(reminder);
    }
}
