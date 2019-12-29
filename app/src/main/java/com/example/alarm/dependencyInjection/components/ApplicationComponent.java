package com.example.alarm.dependencyInjection.components;

import android.content.Context;
import android.media.AudioManager;
import android.os.PowerManager;
import android.os.Vibrator;

import com.example.alarm.data.alarm.AlarmService;
import com.example.alarm.data.reminder.ReminderService;
import com.example.alarm.dependencyInjection.modules.ApplicationModule;
import com.example.alarm.util.BaseSchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context context();
    PowerManager.WakeLock wakeLock();
    AudioManager audioManager();
    Vibrator vibrator();
    AlarmService alarmService();
    ReminderService reminderService();
    BaseSchedulerProvider baseSchedulerProvider();

}