package com.example.alarm.usecase;

import com.example.alarm.data.reminder.ReminderService;

import io.reactivex.Observable;

public class GetReminderList implements UseCase.Request {

    private final ReminderService reminderService;

    public GetReminderList(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @Override
    public Observable runUseCase() {
        return reminderService.getReminders();
    }


}
