package com.orange.chat2piao.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orange.chat2piao.R;
import com.stephentuso.welcome.WelcomeHelper;

public class MainActivity extends AppCompatActivity {
    private WelcomeHelper welcomeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeScreen = new WelcomeHelper(this, SampleWelcomeActivity.class);
        welcomeScreen.show(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeScreen.onSaveInstanceState(outState);
    }
}
