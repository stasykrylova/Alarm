package com.example.alarm.alarmReceiver;


import com.example.alarm.R;
import com.example.alarm.data.alarm.AlarmService;
import com.example.alarm.data.reminder.ReminderService;
import com.example.alarm.data.viewmodel.Reminder;
import com.example.alarm.usecase.DismissAlarm;
import com.example.alarm.usecase.GetReminder;
import com.example.alarm.usecase.StartAlarm;
import com.example.alarm.usecase.UpdateOrCreateReminder;
import com.example.alarm.util.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class AlarmReceiverPresenter implements AlarmReceiverContract.Presenter {

    private final DismissAlarm dismissAlarm;
    private final StartAlarm startAlarm;
    private final GetReminder getReminder;
    private final UpdateOrCreateReminder updateOrCreateReminder;

    private final AlarmReceiverContract.View view;
    private final BaseSchedulerProvider schedulerProvider;
    private final CompositeDisposable compositeDisposable;
    private Reminder currentReminder;

    @Inject
    public AlarmReceiverPresenter(AlarmReceiverContract.View view,
                                  ReminderService reminderService,
                                  AlarmService alarmService,
                                  BaseSchedulerProvider schedulerProvider) {
        this.getReminder = new GetReminder(reminderService);
        this.dismissAlarm = new DismissAlarm(alarmService);
        this.startAlarm = new StartAlarm(alarmService);
        this.updateOrCreateReminder = new UpdateOrCreateReminder(reminderService);

        this.view = view;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Inject
    void setPresenter() {
        view.setPresenter(this);
    }


    @Override
    public void subscribe() {
        getReminderFromDatabase();
    }

    @Override
    public void unSubscribe() {

    }

    /**
     * Query the Reminder Database for a Reminder which matches the given reminderId passed
     * in from the Activity's extras.
     */
    private void getReminderFromDatabase() {
        Reminder reminder = view.getReminderViewModel();

        getReminder.runUseCase(reminder)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeWith(new DisposableObserver<Reminder>() {
                    @Override
                    public void onNext(Reminder reminder) {
                        checkReminderState(reminder);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.makeToast(R.string.error_database_connection_failure);
                        view.finishActivity();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * Checks whether the Reminder should be written as INACTIVE or left alone, based on
     * reminder.isRenewAutomatically
     * @param reminder
     */
    private void checkReminderState(final Reminder reminder) {
        if (reminder.isRenewAutomatically()) {
            startAlarm(reminder);
        } else {
            reminder.setActive(false);
            updateOrCreateReminder.runUseCase(reminder)
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .subscribeWith(
                            new DisposableObserver() {
                                @Override
                                public void onComplete() {
                                    startAlarm(reminder);
                                }

                                @Override
                                public void onNext(Object o) {

                                }

                                @Override
                                public void onError(Throwable e) {
                                    view.makeToast(R.string.error_database_write_failure);
                                }
                            });
        }
    }



    private void startAlarm(Reminder reminder) {
        startAlarm.runUseCase(reminder)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeWith(new DisposableObserver() {
                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onNext(Object o) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.makeToast(R.string.error_starting_alarm);
                    }
                });


    }



    @Override
    public void onAlarmDismissClick() {
        //first, stop the media player and vibrator
        dismissAlarm.runUseCase()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeWith(
                        new DisposableObserver() {
                            @Override
                            public void onComplete() {
                                view.finishActivity();

                            }

                            @Override
                            public void onNext(Object o) {

                            }

                            @Override
                            public void onError(Throwable e) {
                            }
                        });


    }
}
