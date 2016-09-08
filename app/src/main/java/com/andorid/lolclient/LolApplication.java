package com.andorid.lolclient;

import me.fangx.common.ui.BaseApplication;
import me.fangx.common.util.log.LogUtil;

/**
 * Created by Administrator on 2016/8/18.
 */
public class LolApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(true, "zjm");
    }

}
