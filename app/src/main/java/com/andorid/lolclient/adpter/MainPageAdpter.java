package com.andorid.lolclient.adpter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.andorid.lolclient.R;
import com.andorid.lolclient.ui.fragment.FragmentFactory;

/**
 * Created by Administrator on 2016/8/18.
 */
public class MainPageAdpter extends FragmentStatePagerAdapter {
    public  static int PAGE_COUNT = 0;
    private Context context;
    private String[] tab_Name = null;

    public MainPageAdpter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tab_Name = context.getResources().getStringArray(R.array.home_tab_array);
        PAGE_COUNT = tab_Name.length;

    }




    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tab_Name[position];
    }
}
