package com.example.alarm.alarmReceiver;


import com.example.alarm.dependencyInjection.components.ApplicationComponent;
import com.example.alarm.util.FragmentScoped;

import dagger.Component;

/**
 * Since ReminderDetailComponent is dependent upon the ReminderRepository, when must make
 * satisfy the dependency by supplying TaskRepositoryComponent.class.
 *
 */
@FragmentScoped
@Component(dependencies = ApplicationComponent.class,
        modules = AlarmReceiverPresenterModule.class)
public interface AlarmReceiverComponent {

    void inject(AlarmReceiverActivity alarmReceiverActivity);
}