package com.example.alarm.settings;

import javax.inject.Inject;

public class SettingsPresenter implements SettingsContract.Presenter {
  private final SettingsContract.View view;

  @Inject
  public SettingsPresenter(SettingsContract.View view) {
    this.view = view;
  }

  @Inject
  void setPresenter() {
    view.setPresenter(this);
  }

  @Override
  public void subscribe() {

  }

  @Override
  public void unSubscribe() {

  }

  @Override
  public void onContactButtonClick() {

  }
}
