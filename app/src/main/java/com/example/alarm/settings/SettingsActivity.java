package com.example.alarm.settings;


import android.os.Bundle;

import com.example.alarm.R;
import com.example.alarm.util.ActivityUtils;


import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

public class SettingsActivity extends AppCompatActivity {
    private static final String FRAG_SETTINGS = "FRAG_SETTINGS";

    private Toolbar toolbar;
    private FragmentManager manager;

    @Inject
    SettingsPresenter settingsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        manager = getSupportFragmentManager();

        SettingsFragment fragment =  (SettingsFragment) manager.findFragmentByTag(FRAG_SETTINGS);

        if (fragment == null){
            fragment = SettingsFragment.newInstance();
        }

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                fragment,
                R.id.cont_settings_fragment,
                FRAG_SETTINGS
        );

        DaggerSettingsComponent.builder()
                .settingsPresenterModule(new SettingsPresenterModule(fragment))
                .build()
                .inject(this);
    }
}

