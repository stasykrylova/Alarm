package com.example.alarm.dependencyInjection.modules;

import com.example.alarm.data.reminder.ReminderService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class ReminderModule {

    public ReminderModule (Realm realm){
        this.reminderService = new ReminderService();
    }

    ReminderService reminderService;

    @Singleton
    @Provides
    ReminderService provideReminderService() {
        return reminderService;
    }

}

