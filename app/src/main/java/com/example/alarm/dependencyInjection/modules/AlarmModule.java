package com.example.alarm.dependencyInjection.modules;

import android.app.AlarmManager;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.os.Vibrator;

import com.example.alarm.data.alarm.AlarmService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AlarmModule {

    public AlarmModule(PowerManager.WakeLock wakeLock,
                       MediaPlayer mediaPlayer,
                       AudioManager audioManager,
                       Vibrator vibe,
                       AlarmManager alarmManager,
                       Context applicationContext) {
        alarmService = new AlarmService(
                wakeLock,
                mediaPlayer,
                audioManager,
                vibe,
                alarmManager,
                applicationContext
        );
    }

    AlarmService alarmService;

    @Singleton
    @Provides
    AlarmService provideAlarmService() {
        return alarmService;
    }

}

