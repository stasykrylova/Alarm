package com.example.alarm.base;

import androidx.annotation.StringRes;

public interface BaseView<T> {


    void setPresenter(T presenter);


    void makeToast(@StringRes int message);

}
