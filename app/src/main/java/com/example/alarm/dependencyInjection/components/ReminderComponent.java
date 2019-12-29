package com.example.alarm.dependencyInjection.components;


import com.example.alarm.data.reminder.ReminderService;
import com.example.alarm.dependencyInjection.modules.ApplicationModule;
import com.example.alarm.dependencyInjection.modules.ReminderModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ReminderModule.class, ApplicationModule.class})
public interface ReminderComponent {

    void inject(ReminderService reminderService);

}