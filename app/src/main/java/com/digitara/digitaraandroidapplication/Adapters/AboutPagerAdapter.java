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

    public AboutPagerAdapter(Context mContext2, List<AboutModel> mListScreen2) {
        this.mContext = mContext2;
        this.mListScreen = mListScreen2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        View layoutAboutScreen = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.layout_about_screen, (ViewGroup) null);
        ((TextView) layoutAboutScreen.findViewById(R.id.intro_title)).setText(this.mListScreen.get(position).getTitle());
        ((TextView) layoutAboutScreen.findViewById(R.id.intro_description)).setText(this.mListScreen.get(position).getDescription());
        ((ImageView) layoutAboutScreen.findViewById(R.id.intro_img)).setImageResource(this.mListScreen.get(position).getScreenImg());
        container.addView(layoutAboutScreen);
        return layoutAboutScreen;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mListScreen.size();
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
