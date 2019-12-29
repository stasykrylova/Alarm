package com.example.alarm.reminderDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.alarm.Alarm;
import com.example.alarm.R;
import com.example.alarm.reminderlist.ReminderListActivity;
import com.example.alarm.util.ActivityUtils;

import javax.inject.Inject;

public class ReminderDetailActivity extends AppCompatActivity {
    private static final String FRAG_REMINDER_DETAIL = "FRAG_REMINDER_DETAIL";
    private static final String REMINDER_TO_BE_EDITED = "REMINDER_TO_BE_EDITED";

    private FragmentManager manager;

    //Field/Member Variable Injection
    @Inject
    ReminderDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_detail);

        String reminderId = getIntent().getStringExtra(REMINDER_TO_BE_EDITED);

        if (reminderId == null){
            startActivity(new Intent(this, ReminderListActivity.class));
        }

        manager = getSupportFragmentManager();

        ReminderDetailFragment fragment =  (ReminderDetailFragment) manager.findFragmentByTag(FRAG_REMINDER_DETAIL);

        if (fragment == null){
            fragment = ReminderDetailFragment.newInstance(reminderId);
        }

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                fragment,
                R.id.cont_reminder_detail_fragment,
                FRAG_REMINDER_DETAIL
        );

        //In order to create the Dependencies for my ReminderDetailPresenter, applicationComponent
        //must be accessed.

        DaggerReminderDetailComponent.builder()
                .reminderDetailPresenterModule(new ReminderDetailPresenterModule(fragment))
                .applicationComponent(
                        ((Alarm) getApplication())
                                .getApplicationComponent()
                )
                .build().inject(this);
    }
}


//    public void initComponent(){
//        this.reminderDetailComponent = DaggerReminderDetailComponent
//                .builder()
//                .applicationComponent(getApplicationComponent())
//                .build();
//    }
//
//    protected ApplicationComponent getApplicationComponent() {
//        return Alarm.getApplicationComponent();
//    }


