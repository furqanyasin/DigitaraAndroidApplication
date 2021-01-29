package com.digitara.digitaraandroidapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.digitara.digitaraandroidapplication.Adapters.ServicesPagerAdapter;
import com.digitara.digitaraandroidapplication.Model.ServicesModel;
import com.digitara.digitaraandroidapplication.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class ServicesFragment extends Fragment {
    MaterialCardView cvNext;
    List<ServicesModel> mListScreen;
    int position = 0;
    private ViewPager screenPager;
    ServicesPagerAdapter servicesPagerAdapter;
    TabLayout tabIndicator;
    TextView tvNext;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_services, container, false);
        this.tabIndicator = (TabLayout) root.findViewById(R.id.tab_indicator_services);
        this.tvNext = (TextView) root.findViewById(R.id.tv_next);
        this.cvNext = (MaterialCardView) root.findViewById(R.id.cv_next);
        this.screenPager = (ViewPager) root.findViewById(R.id.services_viewpager);
        ServicesScreen();
        return root;
    }

    private void ServicesScreen() {
        ArrayList arrayList = new ArrayList();
        this.mListScreen = arrayList;
        arrayList.add(new ServicesModel("WE BUILD YOU STRONG", "Digital Marketing\nBrand Identity\nPR Strategy and Marketing\nSEM (Search Engine Marketing)\nSMM (Social Media Management)\nSEO (Search Engine Optimization)\nWeb Development\nUI & UX Design\nATL & BTL Marketing", R.drawable.services_1));
        this.mListScreen.add(new ServicesModel("Design & Content Writing", "Logos\nTagline\nKVs", R.drawable.services_2));
        this.mListScreen.add(new ServicesModel("Website", "Design\nDevelopment\nSEO\nE-COMMERCE", R.drawable.services_2));
        this.mListScreen.add(new ServicesModel("Social Media", "Facebook\nInstagram\nTwitter\nYoutube\nLinkedIn\nPinterest", R.drawable.services_2));
        this.mListScreen.add(new ServicesModel("Facebook", "Campaign Design & Execution\nActive Engagement & Inbox Handling\nStatic Posts\nContent Writing\nAnimated Videos\nStories, DVCs\nMarketing Strategy\nAnalytics\nMonthly/Quarterly Report", R.drawable.services_2));
        this.mListScreen.add(new ServicesModel("Instagram", "Minute Videos\nAnimated Videos\nStatic Posts\nStories", R.drawable.services_2));
        this.mListScreen.add(new ServicesModel("Twitter", "No. of followers\nTweets\nHashtag and trends\nBlue Tick", R.drawable.services_2));
        this.mListScreen.add(new ServicesModel("Youtube", "Bumper Ads\nSkippable & Non-Skippable Ads\nVO Documentaries\nTVCs/ DVCs\nPlacement\nMonetization", R.drawable.services_2));
        ServicesPagerAdapter servicesPagerAdapter2 = new ServicesPagerAdapter(getContext(), this.mListScreen);
        this.servicesPagerAdapter = servicesPagerAdapter2;
        this.screenPager.setAdapter(servicesPagerAdapter2);
        this.tabIndicator.setupWithViewPager(this.screenPager);
        this.cvNext.setOnClickListener(new View.OnClickListener() {
            /* class com.digitara.digitara.ui.$$Lambda$ServicesFragment$g0vWS_RjZITjzEXzWmdxPnBNscs */

            public final void onClick(View view) {
                ServicesFragment.this.lambda$ServicesScreen$0$ServicesFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$ServicesScreen$0$ServicesFragment(View view) {
        int currentItem = this.screenPager.getCurrentItem();
        this.position = currentItem;
        if (currentItem < this.mListScreen.size()) {
            int i = this.position + 1;
            this.position = i;
            this.screenPager.setCurrentItem(i);
        }
    }
}
