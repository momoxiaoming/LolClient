package com.andorid.lolclient.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.andorid.lolclient.R;
import com.andorid.lolclient.adpter.MainCenterRecyAdpter;
import com.andorid.lolclient.ui.fragment.FragmentFactory;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends SlidingFragmentActivity {


    @Bind(R.id.banner)
    Banner banner;

    @Bind(R.id.left_btn)
    ImageView left;

    @Bind(R.id.main_recyview)
    RecyclerView recyclerView;

    @Bind(R.id.main_center_recyview)
    RecyclerView main_center_recyview;

    private SlidingMenu mSlidingMenu;
    private List<String> imageuri = new ArrayList<>();
    private MainCenterRecyAdpter mainCenterRecyAdpter;

    private List<String> mImageList = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        initViewPage();
        initBanner();
        initSlidMenu();
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlidingMenu.toggle();
            }
        });

    }

    public void initAdpterData() {

        mainCenterRecyAdpter = new MainCenterRecyAdpter(mImageList, getApplicationContext());

    }


    public void initBanner() {
        imageuri.add("http://img5.imgtn.bdimg.com/it/u=108122922,2557727777&fm=21&gp=0.jpg");
        imageuri.add("http://img.zcool.cn/community/0172be555961b00000009af06e61c2.jpg");
        imageuri.add("http://img.zcool.cn/community/0101b6561714f432f875313db1998e.jpg");
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);   //显示圆形指示器
        banner.isAutoPlay(true);   //设置是否轮播
        banner.setBannerAnimation(Transformer.Tablet);
        banner.setImages(imageuri);

    }

    public void initSlidMenu() {
        setBehindContentView(R.layout.menu_fragment); //设置内容的xml
        getSlidingMenu().setSlidingEnabled(true);     //设置是否显示侧滑
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  //设置要显示侧滑的手势
        mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);  //菜单打开时,离屏幕右边的偏移量,也就是侧滑菜单的宽带
        mSlidingMenu.setFadeEnabled(false);   //是否启用侧滑菜单的淡入淡出
        mSlidingMenu.setBehindScrollScale(0.25f);   //设置滚动
        mSlidingMenu.setHorizontalFadingEdgeEnabled(true);  //定义水平边缘是否应该消失
        mSlidingMenu.setVerticalFadingEdgeEnabled(true);    //定义垂直边缘是否应该消失
        mSlidingMenu.setFadingEdgeLength(50);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(
                        R.id.menu_frame,
                        FragmentFactory.createFragment(
                                1)).commit();
        mSlidingMenu.addIgnoredView(banner);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
