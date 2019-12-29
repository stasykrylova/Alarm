package com.example.alarm.reminderDetail;

import dagger.Module;
import dagger.Provides;
@Module
public class ReminderDetailPresenterModule {
    //List what you would normally pass in as arguments to a Presenter's constructor
    private final ReminderDetailContract.View view;

    public ReminderDetailPresenterModule(ReminderDetailContract.View view) {
        this.view = view;
    }

    @Provides
    ReminderDetailContract.View provideReminderDetailView(){
        return view;
    }
}
