package com.example.alarm.dependencyInjection.components;

import com.example.alarm.data.alarm.AlarmService;
import com.example.alarm.dependencyInjection.modules.AlarmModule;
import com.example.alarm.dependencyInjection.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AlarmModule.class, ApplicationModule.class})
public interface AlarmComponent {

    void inject(AlarmService alarmService);

}

