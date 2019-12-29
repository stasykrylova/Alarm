package com.example.alarm.util;

import io.reactivex.Scheduler;

public interface BaseSchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
