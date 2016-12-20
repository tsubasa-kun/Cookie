package com.love_cookies.cookie.presenter;

import android.content.Context;

import com.love_cookies.cookie.mobile.bean.ChangeLogBean;
import com.love_cookies.cookie.mobile.biz.ChangeLogBiz;
import com.love_cookies.cookie.view.interfaces.IVersion;
import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by xiekun on 2016/12/20 0020.
 *
 * 版本信息Presenter
 */
public class VersionPresenter {

    private ChangeLogBiz changeLogBiz;
    private IVersion iVersion;

    public VersionPresenter(IVersion iVersion) {
        changeLogBiz = new ChangeLogBiz();
        this.iVersion = iVersion;
    }

    /**
     * 获取ChangeLog
     * @param context
     */
    public void getChangeLog(Context context) {
        changeLogBiz.getChangeLog(context, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iVersion.setChangeLog((ChangeLogBean)result);
            }

            @Override
            public void onFailed(Object msg) {
            }
        });
    }

}
