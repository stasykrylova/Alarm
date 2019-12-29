package com.example.alarm.settings;

import com.example.alarm.dependencyInjection.components.ApplicationComponent;
import com.example.alarm.util.FragmentScoped;

import dagger.Component;
@FragmentScoped
@Component(dependencies = ApplicationComponent.class,
        modules = SettingsPresenterModule.class)
public interface SettingsComponent {

    void inject(SettingsActivity settingsActivity);

}
