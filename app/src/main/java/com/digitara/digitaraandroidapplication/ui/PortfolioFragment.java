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
        this.tabIndicator = (TabLayout) root.findViewById(R.id.tab_indicator_services);
        this.tvNext = (TextView) root.findViewById(R.id.tv_next);
        this.cvNext = (MaterialCardView) root.findViewById(R.id.cv_next);
        this.portfolioPager = (ViewPager) root.findViewById(R.id.portfolio_viewpager);
        PortfolioScreen();
        return root;
    }

    private void PortfolioScreen() {
        ArrayList arrayList = new ArrayList();
        this.mListPortfolio = arrayList;
        arrayList.add(new PortfolioModel(R.drawable.port_img_odp_0));
        this.mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_1));
        this.mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_2));
        this.mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_3));
        this.mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_4));
        this.mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_5));
        this.mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_6));
        this.mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_7));
        this.mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_8));
        this.mListPortfolio.add(new PortfolioModel(R.drawable.port_img_odp_9));
        PortfolioAdapter portfolioAdapter2 = new PortfolioAdapter(getContext(), this.mListPortfolio);
        this.portfolioAdapter = portfolioAdapter2;
        this.portfolioPager.setAdapter(portfolioAdapter2);
        this.tabIndicator.setupWithViewPager(this.portfolioPager);
        this.cvNext.setOnClickListener(new View.OnClickListener() {
            /* class com.digitara.digitara.ui.$$Lambda$PortfolioFragment$z1qaDrmYN4Th4mbLgLy1oSGa44 */

            public final void onClick(View view) {
                PortfolioFragment.this.lambda$PortfolioScreen$0$PortfolioFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$PortfolioScreen$0$PortfolioFragment(View view) {
        int currentItem = this.portfolioPager.getCurrentItem();
        this.position = currentItem;
        if (currentItem < this.mListPortfolio.size()) {
            int i = this.position + 1;
            this.position = i;
            this.portfolioPager.setCurrentItem(i);
        }
    }
}
