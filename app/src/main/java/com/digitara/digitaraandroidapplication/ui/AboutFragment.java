package com.digitara.digitaraandroidapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.digitara.digitaraandroidapplication.Adapters.AboutPagerAdapter;
import com.digitara.digitaraandroidapplication.Model.AboutModel;
import com.digitara.digitaraandroidapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    AboutPagerAdapter aboutPagerAdapter;
    int position = 0;
    private ViewPager screenPager;
    TabLayout tabIndicator;
    TextView tvNext;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        tabIndicator = (TabLayout) root.findViewById(R.id.tab_indicator);
        tvNext = (TextView) root.findViewById(R.id.tv_next);
        screenPager = (ViewPager) root.findViewById(R.id.screen_viewpager);
        AboutScreenModel();
        return root;
    }

    private void AboutScreenModel() {
        List<AboutModel> mList = new ArrayList<>();
        mList.add(new AboutModel("DIGITARA", "is a full service digital marketing agency committed to transform brands into success stories through exemplary utilization of digital space for creating brand presence, development and transformation. We are giving contemporary solutions to your business needs since 2017.", R.drawable.about_1));
        mList.add(new AboutModel("WHAT WE DO", "We, Digitara, are specialized in growing your brand through effective Digital Marketing, PR and Advertising, ultimately creating a versatile story to cater your needs. As a team of specialized experts, we design campaigns which both generate social capital and add sense of civic responsibility.", R.drawable.about_2));
        mList.add(new AboutModel("OUR GOAL", "To engrave your brand in consumer’s mind that excites and inspires them. We, at Digitara, want your brand to dominate digital public sphere in a way that is incomparable. Our team’s enthusiasm for creative ideas, solutions and techniques would weave the narrative; you will fall in love with.", R.drawable.about_3));
        aboutPagerAdapter = new AboutPagerAdapter(getContext(), mList);
        screenPager.setAdapter(aboutPagerAdapter);
        tabIndicator.setupWithViewPager(screenPager);
        tvNext.setOnClickListener(view -> {
            int currentItem = screenPager.getCurrentItem();
            position = currentItem;
            if (currentItem < mList.size()) {
                int i = position + 1;
                position = i;
                screenPager.setCurrentItem(i);
            }
        });
    }

}
