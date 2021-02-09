package com.digitara.digitaraandroidapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.digitara.digitaraandroidapplication.MainActivity;
import com.digitara.digitaraandroidapplication.R;

public class SplashActivity extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 2000;

    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_splash);
        new Handler().postDelayed(new Runnable() {

            public final void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
