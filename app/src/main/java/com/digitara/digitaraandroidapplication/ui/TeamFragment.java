package com.digitara.digitaraandroidapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.digitara.digitaraandroidapplication.Adapters.TeamAdapter;
import com.digitara.digitaraandroidapplication.Model.TeamModel;
import com.digitara.digitaraandroidapplication.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TeamFragment extends Fragment {
    MaterialCardView cvNext;
    int position = 0;
    TabLayout tabIndicator;
    TeamAdapter teamAdapter;
    private ViewPager teamPager;
    TextView tvNext;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_team, container, false);
        this.tabIndicator = (TabLayout) root.findViewById(R.id.tab_indicator_team);
        this.cvNext = (MaterialCardView) root.findViewById(R.id.cv_next);
        this.teamPager = (ViewPager) root.findViewById(R.id.team_viewpager);
        TeamFunction();
        return root;
    }

    private void TeamFunction() {
        List<TeamModel> mListTeam = new ArrayList<>();
        mListTeam.add(new TeamModel(null, R.drawable.team_img_0));
        mListTeam.add(new TeamModel("A seasoned communication professional and networking expert who aims to lead the digital world with exquisite digital communication.", R.drawable.team_img_1));
        mListTeam.add(new TeamModel("His unparallel vision for establishing and implementing policies, and overseeing business operations makes him a “Jack of all trades”.", R.drawable.team_img_2));
        mListTeam.add(new TeamModel("Her determination comes from years of experience in strategic communication, business development, entrepreneurship and PR.", R.drawable.team_img_3));
        mListTeam.add(new TeamModel("Hassan’s insight of local communication landscape and understanding of global media, positions him at a vintage point to design communications.", R.drawable.team_img_4));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_5));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_6));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_7));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_8));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_9));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_10));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_11));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_12));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_13));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_14));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_15));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_16));
        mListTeam.add(new TeamModel(null, R.drawable.team_img_17));
        TeamAdapter teamAdapter2 = new TeamAdapter(getContext(), mListTeam);
        this.teamAdapter = teamAdapter2;
        this.teamPager.setAdapter(teamAdapter2);
        this.cvNext.setOnClickListener(view -> {
            teamFunction(mListTeam,view);
        });
    }

    public void teamFunction(List mListTeam, View view) {
        int currentItem = this.teamPager.getCurrentItem();
        this.position = currentItem;
        if (currentItem < mListTeam.size()) {
            int i = this.position + 1;
            this.position = i;
            this.teamPager.setCurrentItem(i);
        }
    }
}
