package com.love_cookies.cookie.view.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.love_cookies.cookie.R;
import com.love_cookies.cookie.view.widget.SettingItemView;
import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.application.ActivityCollections;
import com.love_cookies.cookie_library.utils.ToastUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by xiekun on 2016/12/20 0020.
 *
 * 主页
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private long exitTime;

    @ViewInject(R.id.title_tv)
    private TextView pageTitle;
    @ViewInject(R.id.version)
    private SettingItemView version;

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        pageTitle.setText(R.string.app_name);
        version.setOnClickListener(this);
    }

    /**
     * 控件点击事件
     * @param v
     */
    @Override
    public void widgetClick(View v) {
        turn(VersionActivity.class);
    }

    /**
     * 点两次返回退出程序
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {//点击两次退出逻辑
                ToastUtils.show(this, R.string.exit_tip);
                exitTime = System.currentTimeMillis();
            } else {
                ActivityCollections.getInstance().finishAllActivity();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
