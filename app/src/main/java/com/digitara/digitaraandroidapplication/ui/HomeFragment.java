package com.digitara.digitaraandroidapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.digitara.digitaraandroidapplication.Activities.GetQuoteActivity;
import com.digitara.digitaraandroidapplication.Activities.WebView;
import com.digitara.digitaraandroidapplication.R;
import com.google.android.material.button.MaterialButton;

public class HomeFragment extends Fragment {
    MaterialButton btnRequestQuote, btnSurvey;
    LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        MaterialButton materialButton = (MaterialButton) root.findViewById(R.id.btn_submit);
        MaterialButton materialButtonSurvey = (MaterialButton) root.findViewById(R.id.btn_survey);

        //Request Quote Button
        btnRequestQuote = materialButton;
        materialButton.setOnClickListener(v -> {
            //code here
            startActivity(new Intent(getActivity(), GetQuoteActivity.class));
        });

        //Client Satisfaction Survey Button
        btnSurvey = materialButtonSurvey;
        materialButtonSurvey.setOnClickListener(v -> {
            //code here
            startActivity(new Intent(getActivity(), WebView.class));
        });

        linearLayout = (LinearLayout) root.findViewById(R.id.ll_swipe);
        TranslateAnimation animation = new TranslateAnimation(0.0f, 500.0f, 0.0f, 0.0f);
        animation.setDuration(1500);
        animation.setRepeatCount(100);
        animation.setRepeatMode(3);
        animation.setFillAfter(true);
        linearLayout.startAnimation(animation);
        return root;

    }

}
