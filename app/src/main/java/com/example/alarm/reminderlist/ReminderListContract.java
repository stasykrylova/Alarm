package com.example.alarm.reminderlist;

import com.example.alarm.base.BasePresenter;
import com.example.alarm.base.BaseView;
import com.example.alarm.data.viewmodel.Reminder;

import java.util.List;

public interface ReminderListContract  {
    interface View extends BaseView<Presenter> {
        void setReminderListData(List<Reminder> reminderListData);

        void setNoReminderListDataFound();

        void addNewReminderToListView(Reminder reminder);

        void undoDeleteReminderAt(int index, Reminder reminder);

        void startReminderDetailActivity(String reminderId);

        void startSettingsActivity();


    }

    interface Presenter extends BasePresenter {
        void onReminderToggled(boolean active, Reminder reminder);

        void onSettingsIconClick();

        void onReminderSwiped(int index, Reminder reminder);

        void onReminderIconClick(Reminder reminder);

        void onCreateReminderButtonClick(int currentNumberOfReminders, Reminder reminder);
    }
}
