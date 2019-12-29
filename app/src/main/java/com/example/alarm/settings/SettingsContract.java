package com.example.alarm.settings;

import com.example.alarm.base.BasePresenter;
import com.example.alarm.base.BaseView;
import com.example.alarm.reminderDetail.ReminderDetailContract;

public interface SettingsContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void onContactButtonClick();
    }
}

