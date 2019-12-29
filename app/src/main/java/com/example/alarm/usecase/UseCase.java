package com.example.alarm.usecase;

import com.example.alarm.data.viewmodel.Reminder;

import io.reactivex.Observable;

public interface UseCase {

    /**
     * Use cases which would benefit from a RequestModel Possibly
     */
    interface RequestModel {
        Observable runUseCase(Reminder reminder);
    }

    /**
     * Use cases which don't require a RequestModel
     */
    interface Request {
        Observable runUseCase();
    }
}
