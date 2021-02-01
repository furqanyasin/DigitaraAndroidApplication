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

    public TeamAdapter(Context mContext, List<TeamModel> mListTeam) {
        this.mContext = mContext;
        this.mListTeam = mListTeam;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        View layoutScreen = ((LayoutInflater) mContext.getSystemService("layout_inflater")).inflate(R.layout.team_layout, (ViewGroup) null);
        ((TextView) layoutScreen.findViewById(R.id.tv_description)).setText(mListTeam.get(position).getDescription());
        ((ImageView) layoutScreen.findViewById(R.id.img_team)).setImageResource(mListTeam.get(position).getProfileImg());
        container.addView(layoutScreen);
        return layoutScreen;
    }

    @Override
    public int getCount() {
        return this.mListTeam.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ConstraintLayout) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
