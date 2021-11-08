package com.digitara.digitaraandroidapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.digitara.digitaraandroidapplication.R;

public class WebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        android.webkit.WebView webView =new android.webkit.WebView(getBaseContext());
        setContentView(webView);
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdMGGiCIk0Lq3y7bJSjVWZNWelh7fvDJhKhaomCVNgl4odjNQ/viewform");




    }
}