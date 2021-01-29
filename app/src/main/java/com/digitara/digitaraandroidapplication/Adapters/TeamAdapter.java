package com.digitara.digitaraandroidapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.digitara.digitaraandroidapplication.Model.TeamModel;
import com.digitara.digitaraandroidapplication.R;

import java.util.List;

public class TeamAdapter extends PagerAdapter {
    Context mContext;
    List<TeamModel> mListTeam;

    public TeamAdapter(Context mContext2, List<TeamModel> mListTeam2) {
        this.mContext = mContext2;
        this.mListTeam = mListTeam2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        View layoutScreen = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.team_layout, (ViewGroup) null);
        ((TextView) layoutScreen.findViewById(R.id.tv_description)).setText(this.mListTeam.get(position).getDescription());
        ((ImageView) layoutScreen.findViewById(R.id.img_team)).setImageResource(this.mListTeam.get(position).getProfileImg());
        container.addView(layoutScreen);
        return layoutScreen;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mListTeam.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ConstraintLayout) object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
