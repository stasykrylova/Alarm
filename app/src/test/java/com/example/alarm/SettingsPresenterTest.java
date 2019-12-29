package com.example.alarm;

import com.example.alarm.settings.SettingsContract;
import com.example.alarm.settings.SettingsPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SettingsPresenterTest {

    @Mock
    private SettingsContract.View view;

    private SettingsPresenter presenter;

    @Before
    public void SetUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = new SettingsPresenter(
                view
        );

    }

    @Test
    public void whenContactButtonClicked () {
        presenter.onContactButtonClick();
        //verify(view).startCreateAccountActivity();
    }


}
