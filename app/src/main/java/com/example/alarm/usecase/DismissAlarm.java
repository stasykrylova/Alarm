package com.example.alarm.usecase;

import com.example.alarm.data.alarm.AlarmService;

import io.reactivex.Observable;

public class DismissAlarm implements UseCase.Request {

    private final AlarmService alarmService;

    public DismissAlarm(AlarmService alarmService) {
        this.alarmService = alarmService;
    }


    @Override
    public Observable runUseCase() {
        return alarmService.dismissAlarm();
    }
}