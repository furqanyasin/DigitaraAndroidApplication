package com.digitara.digitaraandroidapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.digitara.digitaraandroidapplication.Adapters.PortfolioAdapter;
import com.digitara.digitaraandroidapplication.Model.PortfolioModel;
import com.digitara.digitaraandroidapplication.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PortfolioFragment extends Fragment {
    MaterialCardView cvNext;
    List<PortfolioModel> mListPortfolio;
    PortfolioAdapter portfolioAdapter;
    private ViewPager portfolioPager;
    int position = 0;
    TabLayout tabIndicator;
    TextView tvNext;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_portfolio, container, false);
        tabIndicator = (TabLayout) root.findViewById(R.id.tab_indicator_services);
        tvNext = (TextView) root.findViewById(R.id.tv_next);
        cvNext = (MaterialCardView) root.findViewById(R.id.cv_next);
        portfolioPager = (ViewPager) root.findViewById(R.id.portfolio_viewpager);
        PortfolioScreen();
        return root;
    }

    private void PortfolioScreen() {
        ArrayList arrayList = new ArrayList();
        mListPortfolio = arrayList;
        arrayList.add(new PortfolioModel(R.drawable.port_img_odp_0));
        mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_1));
        mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_2));
        mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_3));
        mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_4));
        mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_5));
        mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_6));
        mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_7));
        mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_8));
        mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_9));
        portfolioAdapter = new PortfolioAdapter(getContext(), mListPortfolio);
        portfolioPager.setAdapter(portfolioAdapter);
        tabIndicator.setupWithViewPager(this.portfolioPager);
        cvNext.setOnClickListener(v -> {
            //code here
            int currentItem = portfolioPager.getCurrentItem();
            position = currentItem;
            if (currentItem < this.mListPortfolio.size()) {
                int i = this.position + 1;
                position = i;
                portfolioPager.setCurrentItem(i);
            }
        });
    }

}
