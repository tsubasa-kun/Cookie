package com.love_cookies.cookie.view.adapter;

import android.content.Context;

import com.love_cookies.cookie.R;
import com.love_cookies.cookie.mobile.bean.ChangeLogBean;
import com.love_cookies.cookie_library.adapter.CommonAdapter;
import com.love_cookies.cookie_library.adapter.CommonViewHolder;

import java.util.List;

/**
 * Created by xiekun on 2016/12/20 0020.
 *
 * 更改日志适配器
 */
public class ChangeLogAdapter extends CommonAdapter<ChangeLogBean.ChangeLogEntity> {

    public ChangeLogAdapter(Context context, List<ChangeLogBean.ChangeLogEntity> datas) {
        super(context, R.layout.item_change_log_list, datas);
    }

    @Override
    public void convert(CommonViewHolder commonViewHolder, ChangeLogBean.ChangeLogEntity changeLogEntity) {
        commonViewHolder.setText(R.id.version, changeLogEntity.getVersion());
        commonViewHolder.setText(R.id.date, changeLogEntity.getDate());
        commonViewHolder.setText(R.id.description, changeLogEntity.getDescription());
    }
}
