package com.example.alarm;


import android.app.Application;

import com.example.alarm.dependencyInjection.components.AlarmComponent;
import com.example.alarm.dependencyInjection.components.ApplicationComponent;

import com.example.alarm.dependencyInjection.components.ReminderComponent;
import com.example.alarm.dependencyInjection.modules.ApplicationModule;

import com.example.alarm.dependencyInjection.components.DaggerApplicationComponent;
import io.realm.Realm;
import io.realm.RealmConfiguration;



public class Alarm extends Application {
    private ApplicationComponent applicationComponent;
    private ReminderComponent reminderComponent;
    private AlarmComponent alarmComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeRealm();

        ApplicationModule applicationModule = new ApplicationModule(
                getApplicationContext()
        );

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(applicationModule)
                .build();

//        reminderComponent = DaggerReminderComponent
//                .builder()
//                .applicationModule(applicationModule)
//                .build();
//
//        alarmComponent = DaggerAlarmComponent
//                .builder()
//                .applicationModule(applicationModule)
//                .build();

    }

    private void initializeRealm(){
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }



    public ReminderComponent getReminderComponent(){
        return reminderComponent;
    }

    public AlarmComponent getAlarmComponent(){
        return alarmComponent;
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}


//43:24

//        reminderRepositoryComponent = DaggerReminderRepositoryComponent
//                .builder()
//                .applicationModule(new ApplicationModule(getApplicationContext()))
//                .build();
//
//        schedulerComponent = DaggerSchedulerComponent
//                .builder()
//                .applicationModule(new ApplicationModule(getApplicationContext()))
//                .build();



