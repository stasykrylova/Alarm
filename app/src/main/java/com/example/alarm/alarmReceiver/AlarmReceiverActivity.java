package com.example.alarm.alarmReceiver;


import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.alarm.Alarm;
import com.example.alarm.R;
import com.example.alarm.util.ActivityUtils;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

/**
 * This Activity is fired when an Alarm goes off. Once it is active, it handles the Alarm based on
 * the Alarm's configuration (such as Vibrate Only, etc.). It also serves as the method for stopping
 * an Alarm which is going off.
 */
public class AlarmReceiverActivity extends AppCompatActivity {

    private static final String ALARM_FRAGMENT = "ALARM_FRAGMENT";
    private static final String REMINDER_ID = "REMINDER_ID";

    @Inject
    AlarmReceiverPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //apparently flags need to be set before calling setContentView
        //TODO figure out which of these is actually necessary lol.
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        setContentView(R.layout.activity_alarm_receiver);

        String reminderId = getIntent().getStringExtra(REMINDER_ID);

        FragmentManager manager = this.getSupportFragmentManager();

        AlarmReceiverFragment fragment = (AlarmReceiverFragment) manager.findFragmentByTag(ALARM_FRAGMENT);

        if (fragment == null) {
            fragment = AlarmReceiverFragment.newInstance(reminderId);
        }

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                fragment,
                R.id.root_alarm,
                ALARM_FRAGMENT
        );

        DaggerAlarmReceiverComponent.builder()
                .alarmReceiverPresenterModule(new AlarmReceiverPresenterModule(fragment))
                .applicationComponent(
                        ((Alarm) getApplication())
                                .getApplicationComponent()
                )
                .build().inject(this);
    }
}
