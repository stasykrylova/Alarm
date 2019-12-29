package com.example.alarm.alarmReceiver;


import com.example.alarm.base.BasePresenter;
import com.example.alarm.base.BaseView;
import com.example.alarm.data.viewmodel.Reminder;

/**
 *
 */

public interface AlarmReceiverContract {
    interface View extends BaseView<Presenter> {
        String getReminderId();

        Reminder getReminderViewModel();

        void finishActivity();
    }

    interface Presenter extends BasePresenter {
        void onAlarmDismissClick();

    }
}
