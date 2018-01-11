package com.open.bitcoin.base.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhy.sample_okhttp.R;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :fgj
 * @createTime: 2018/1/10.
 * @version:1.0.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: ****************************************************************************************************************************************************************************
 */

public abstract class CommonRefreshListViewActivity extends CommonRefreshActivity<PullToRefreshListView, ListView> implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    protected boolean isExtendsRefreshListView = true;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isExtendsRefreshListView) {
            addContentView(R.layout.common_refresh_listview);
        }
    }

    @Override
    public void initControl() {
        if (isExtendsRefreshListView) {
            setRefreshView((PullToRefreshListView) findViewById(R.id.refresh_lst));
           // setTextView((TextView) findViewById(R.id.txt_list_toast));
        }
    }

    /**
     * 设置是否继承refreshListView;一定要super.onCreate(bundle)之前 默认继承
     * @param isExtendsRefreshListView
     * @description:
     */
    protected void setIsExtendsRefreshListView(boolean isExtendsRefreshListView) {
        this.isExtendsRefreshListView = isExtendsRefreshListView;
    }

    /**
     * 设置listview 适配器
     * @param adapter
     * @description:
     */
    public void setAdapter(BaseAdapter adapter) {
        if (getRefreshView() != null) {
            getRefreshView().setAdapter(adapter);
            getRefreshView().setOnItemLongClickListener(this);
            getRefreshView().setOnItemClickListener(this);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        return false;
    }

}
