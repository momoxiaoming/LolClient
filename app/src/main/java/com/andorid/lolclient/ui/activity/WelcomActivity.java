package com.andorid.lolclient.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.andorid.lolclient.R;

import me.fangx.common.ui.activity.BaseAppCompatActivity;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.common.util.netstatus.NetUtils;

/**
 * Created by Administrator on 2016/8/18.
 */
public class WelcomActivity extends BaseAppCompatActivity {
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            readyGo(MainActivity.class);
        }
    };
    @Override
    protected void getBundleExtras(Bundle extras) {
    }





    @Override
    protected int getContentViewLayoutID() {
        return R.layout.welcom_activity;
    }

    @Override
    protected void initViewsAndEvents() {


        handler.sendEmptyMessageDelayed(0,2000);

    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }
}
