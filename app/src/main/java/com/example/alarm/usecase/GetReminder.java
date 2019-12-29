package com.example.alarm.usecase;

import com.example.alarm.data.reminder.ReminderService;
import com.example.alarm.data.viewmodel.Reminder;

import io.reactivex.Observable;

public class GetReminder implements UseCase.RequestModel {

    /**
     *Reminder Service is a Facade/Repository Pattern which Abstracts Realm from the rest of my the
     App
     */
    private final ReminderService reminderService;

    public GetReminder(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @Override
    public Observable runUseCase(Reminder reminder) {
        return reminderService.getReminderById(reminder);
    }

}
