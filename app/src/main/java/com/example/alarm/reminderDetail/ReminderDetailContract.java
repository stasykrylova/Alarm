package com.example.alarm.reminderDetail;

import com.example.alarm.base.BasePresenter;
import com.example.alarm.base.BaseView;
import com.example.alarm.data.viewmodel.Reminder;

public interface ReminderDetailContract {
    interface View extends BaseView<Presenter> {
        Reminder getViewModel();

        void setReminderTitle(String title);

        void setVibrateOnly(boolean active);

        void setRenewAutomatically(boolean active);

        void setPickerTime(int hour, int minute);

        void setCurrentAlarmState(boolean active);

        String getReminderId();

        void startReminderListActivity();

    }

    interface Presenter extends BasePresenter {
        void onBackIconPress();

        void onDoneIconPress();
    }
}


//1:17