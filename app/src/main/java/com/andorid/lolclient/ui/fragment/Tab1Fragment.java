package com.andorid.lolclient.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.andorid.lolclient.R;
import com.andorid.lolclient.adpter.MainPageAdpter;
import com.andorid.lolclient.ui.weight.PagerTab;

import butterknife.Bind;
import me.fangx.common.ui.fragment.BaseLazyFragment;
import me.fangx.common.util.eventbus.EventCenter;

public class Tab1Fragment extends BaseLazyFragment {
    @Bind(R.id.follow_pager)
    ViewPager followPager;
    //    @Bind(R.id.content)
//    LinearLayout content;
    @Bind(R.id.pagerTab)
    PagerTab pagerTab;
    @Bind(R.id.left_btn)
    ImageView left;
    private MainPageAdpter adpter;
   private Context context;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context=activity;
    }

    public static Tab1Fragment newInstance() {
        Tab1Fragment fragment = new Tab1Fragment();
        return fragment;
    }

    @Override
    protected void initViewsAndEvents() {
        initViewPage();

    }

    public void initViewPage() {
        adpter = new MainPageAdpter(getSupportFragmentManager(),context);
        followPager.setAdapter(adpter);
        followPager.setCurrentItem(1);
        followPager.setSaveEnabled(false);
        pagerTab.setViewPager(followPager);
        pagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
//                if (0 == position) {
//                    mSlidingMenu.clearIgnoredViews();             //清楚禁止展开的视图
//                } else {
//                    mSlidingMenu.addIgnoredView(followPager);   //添加一个视图,在这个视图上禁止展开
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        pagerTab.selectTab(1);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_tab1;
    }

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
