package com.example.alarm.alarmReceiver;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alarm.R;
import com.example.alarm.data.viewmodel.Reminder;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

public class AlarmReceiverFragment extends Fragment implements AlarmReceiverContract.View {

    private static final String REMINDER_ID = "REMINDER_ID";
    private String reminderId;

    AlarmReceiverContract.Presenter presenter;

    public AlarmReceiverFragment() {

    }

    public static AlarmReceiverFragment newInstance(String reminderId) {
        AlarmReceiverFragment fragment = new AlarmReceiverFragment();
        Bundle args = new Bundle();
        args.putString(REMINDER_ID, reminderId);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.reminderId = getArguments().getString(REMINDER_ID);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alarm, container, false);

        final Button stopAlarm = (Button) v.findViewById(R.id.btn_alarm_dismiss);
        final TextView qvest = (TextView) v.findViewById(R.id.tv_qv);
        final EditText answer = (EditText) v.findViewById(R.id.edt_qv);
        final Integer firstNum = 1+(int) (Math.random()*500);
        final Integer secondNum =1+(int)(Math.random()*200);
        final String qvestText = firstNum.toString()+"+"+secondNum.toString();
        qvest.setText(qvestText);
        final Integer trueAnsInt=firstNum+secondNum;





        stopAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer yourAnwerNumbers;
                if(answer.getText().toString().equals("")){yourAnwerNumbers=-1;}else {yourAnwerNumbers=Integer.parseInt(answer.getText().toString());}
                if(trueAnsInt.equals(yourAnwerNumbers)){
                    stopAlarm.setText("Well Done!");
                presenter.onAlarmDismissClick()
               ;

                    }
                else {stopAlarm.setBackgroundColor(getResources().getColor(R.color.RED_WRONG));
                stopAlarm.setText("Try again");
                //stopAlarm.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                }
            }
        });
      return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void setPresenter(AlarmReceiverContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void makeToast(@StringRes int message) {
        Toast.makeText(getActivity(),
                message,
                Toast.LENGTH_SHORT)
                .show();
    }


    @Override
    public void onResume() {
        super.onResume();
        /*
                In order to set up the Presenter properly, it must be supplied with the Id of the
                Alarm which just went off.
                 */
        presenter.subscribe();
    }

    @Override
    public String getReminderId() {
        return this.reminderId;
    }

    @Override
    public Reminder getReminderViewModel() {
        return new Reminder(
                this.reminderId,
                getString(R.string.def_reminder_name),
                false,
                true,
                false,
                12,
                30
        );
    }

    @Override
    public void finishActivity() {
        Activity activity = getActivity();

        //null check to avoid cases where Act is destroyed. Not sure if necessary at this point.
        if (activity != null) {
            activity.finish();
        }
    }
}
