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
import com.digitara.digitaraandroidapplication.R;
import com.google.android.material.button.MaterialButton;

public class HomeFragment extends Fragment {
    MaterialButton btnRequestQuote;
    LinearLayout linearLayout;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        MaterialButton materialButton = (MaterialButton) root.findViewById(R.id.btn_submit);
        this.btnRequestQuote = materialButton;
        materialButton.setOnClickListener(new View.OnClickListener() {
            /* class com.digitara.digitara.ui.$$Lambda$HomeFragment$0s8aPNKHsweyNHoxoUK1bRAbPS8 */

            public final void onClick(View view) {
                HomeFragment.this.lambda$onCreateView$0$HomeFragment(view);
            }
        });
        this.linearLayout = (LinearLayout) root.findViewById(R.id.ll_swipe);
        TranslateAnimation animation = new TranslateAnimation(0.0f, 500.0f, 0.0f, 0.0f);
        animation.setDuration(1500);
        animation.setRepeatCount(100);
        animation.setRepeatMode(3);
        animation.setFillAfter(true);
        this.linearLayout.startAnimation(animation);
        return root;
    }

    public /* synthetic */ void lambda$onCreateView$0$HomeFragment(View view) {
        startActivity(new Intent(getActivity(), GetQuoteActivity.class));
    }
}
