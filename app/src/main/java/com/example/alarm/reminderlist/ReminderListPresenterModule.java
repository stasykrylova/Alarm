package com.example.alarm.reminderlist;


import dagger.Module;
import dagger.Provides;

/**
 * This is a feature level (think reminderdetail or reminderlist packages) Module. It satisfies the Presenter's
 * Dependency on the View Interface.
 *
 */
@Module
public class ReminderListPresenterModule {
    //List what you would normally pass in as arguments to a Presenter's constructor
    private final ReminderListContract.View view;

    public ReminderListPresenterModule(ReminderListContract.View view) {
        this.view = view;

    }

    @Provides
    ReminderListContract.View provideReminderListView(){
        return view;
    }
}
