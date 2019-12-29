package com.example.alarm.reminderlist;


import android.Manifest;
import android.os.Bundle;

import com.example.alarm.Alarm;
import com.example.alarm.R;
import com.example.alarm.util.ActivityUtils;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class ReminderListActivity extends AppCompatActivity {
        private static final String FRAG_REMINDER_LIST = "FRAG_REMINDER_LIST";

        private FragmentManager manager;

        @Inject
        ReminderListPresenter presenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_reminder_list);
                //Toolbar
                // toolbar = (Toolbar) findViewById(R.id.toolbar);
                // setSupportActionBar(toolbar);
                manager = getSupportFragmentManager();



                ReminderListFragment fragment = (ReminderListFragment) manager.findFragmentByTag(FRAG_REMINDER_LIST);

                if (fragment == null){
                        fragment = ReminderListFragment.newInstance();
                }

                ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                        fragment,
                        R.id.cont_reminder_list_fragment,
                        FRAG_REMINDER_LIST
                );






               TedPermission.with(this)
                        .setPermissionListener(
                                new PermissionListener() {
                                    @Override
                                    public void onPermissionGranted() {

                                    }

                                    @Override
                                    public void onPermissionDenied(List<String> deniedPermissions) {

                                    }
                                })
                        .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                        .setPermissions(
                                Manifest.permission.WAKE_LOCK,
                                Manifest.permission.VIBRATE
                        )
                        .check();

                DaggerReminderListComponent.builder()
                        .reminderListPresenterModule(new ReminderListPresenterModule(fragment))
                        .applicationComponent(
                                ((Alarm) getApplication())
                                        .getApplicationComponent()
                        )
                        .build().inject(this);



        /*
        Dagger 2 Notes
         */
//        DaggerReminderListComponent.builder()
//                .reminderListPresenterModule(new ReminderListPresenterModule(fragment))
//                .reminderComponent(
//                        ((Alarm) getApplication())
//                                .getReminderComponent()
//                )
//                .build().inject(this);
        }

}