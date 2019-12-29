package com.example.alarm.reminderlist;


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
        modules = ReminderListPresenterModule.class)
public interface ReminderListComponent {

    void inject(ReminderListActivity reminderListActivity);

}

