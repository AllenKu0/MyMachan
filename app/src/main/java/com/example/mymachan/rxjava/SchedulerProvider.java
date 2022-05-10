package com.example.mymachan.rxjava;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler ui();

    Scheduler computation();

    Scheduler io();

    Scheduler newThread();
}
