package com.example.alarm.usecase;

import com.example.alarm.data.reminder.ReminderService;
import com.example.alarm.data.viewmodel.Reminder;

import io.reactivex.Observable;

public class UpdateOrCreateReminder implements UseCase.RequestModel {

    private final ReminderService reminderService;

    public UpdateOrCreateReminder(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @Override
    public Observable runUseCase(Reminder reminder) {
        return reminderService.updateReminder(reminder);
    }
}
