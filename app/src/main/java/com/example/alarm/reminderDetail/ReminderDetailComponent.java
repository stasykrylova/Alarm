package com.example.alarm.reminderDetail;

import com.example.alarm.dependencyInjection.components.ApplicationComponent;
import com.example.alarm.util.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(dependencies = ApplicationComponent.class,
        modules = ReminderDetailPresenterModule.class)
public interface ReminderDetailComponent {

   void inject(ReminderDetailActivity reminderDetailActivity);
}

