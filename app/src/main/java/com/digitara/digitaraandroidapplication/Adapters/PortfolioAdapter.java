package com.digitara.digitaraandroidapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.digitara.digitaraandroidapplication.Model.PortfolioModel;
import com.digitara.digitaraandroidapplication.R;

import java.util.List;

public class PortfolioAdapter extends PagerAdapter {
    Context mContext;
    List<PortfolioModel> mListPortfolio;

    public PortfolioAdapter(Context mContext, List<PortfolioModel> mListPortfolio) {
        this.mContext = mContext;
        this.mListPortfolio = mListPortfolio;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        View layoutServicesScreen = ((LayoutInflater) mContext.getSystemService("layout_inflater")).inflate(R.layout.layout_portfolio_screen, (ViewGroup) null);
        ((ImageView) layoutServicesScreen.findViewById(R.id.intro_img)).setImageResource(mListPortfolio.get(position).getScreenImg());
        container.addView(layoutServicesScreen);
        return layoutServicesScreen;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mListPortfolio.size();
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
