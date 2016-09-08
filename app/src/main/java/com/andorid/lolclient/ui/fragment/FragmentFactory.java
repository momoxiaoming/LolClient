package com.andorid.lolclient.ui.fragment;

import android.support.v4.app.Fragment;

/**
 * fragment管理器
 * Created by Administrator on 2016/8/18.
 */
public class FragmentFactory {

    public static int menu_frame;





    public static Fragment createFragment(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = Tab1Fragment.newInstance();
                break;
            case 1:
                fragment = LeftFragment.newInstance();
                break;
            case 2:
                fragment = Tab1Fragment.newInstance();
                break;
            case 3:
                fragment = Tab1Fragment.newInstance();
                break;
        }
        return fragment;
    }


}
