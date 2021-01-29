package com.digitara.digitaraandroidapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.digitara.digitaraandroidapplication.MainActivity;
import com.digitara.digitaraandroidapplication.R;

public class SplashActivity extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 2000;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_splash);
        new Handler().postDelayed(new Runnable() {
            /* class com.digitara.digitara.Activities.$$Lambda$SplashActivity$KsKCbW8bNGA7K7q6HMJAAGU4oU */

            public final void run() {
                SplashActivity.this.lambda$onCreate$0$SplashActivity();
            }
        }, (long) SPLASH_TIME_OUT);
    }

    public /* synthetic */ void lambda$onCreate$0$SplashActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
