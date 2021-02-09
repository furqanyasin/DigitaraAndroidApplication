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
import com.digitara.digitaraandroidapplication.Model.AboutModel;
import com.digitara.digitaraandroidapplication.R;

import java.util.List;

public class AboutPagerAdapter extends PagerAdapter {
    Context mContext;
    List<AboutModel> mListScreen;


    public AboutPagerAdapter(Context mContext, List<AboutModel> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View layoutAboutScreen = ((LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_about_screen, (ViewGroup) null);
        ((TextView) layoutAboutScreen.findViewById(R.id.intro_title)).setText(mListScreen.get(position).getTitle());
        ((TextView) layoutAboutScreen.findViewById(R.id.intro_description)).setText(mListScreen.get(position).getDescription());
        ((ImageView) layoutAboutScreen.findViewById(R.id.intro_img)).setImageResource(mListScreen.get(position).getScreenImg());
        container.addView(layoutAboutScreen);
        return layoutAboutScreen;
    }

    @Override
    public int getCount() {
        return this.mListScreen.size();
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
