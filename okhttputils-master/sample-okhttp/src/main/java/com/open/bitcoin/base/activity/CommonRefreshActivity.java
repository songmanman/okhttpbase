package com.open.bitcoin.base.activity;

import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.open.bitcoin.base.MessageHandler;
import com.open.bitcoin.refresh.OnHandleRefreshListener;
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

public abstract class CommonRefreshActivity <T extends PullToRefreshBase<V>, V extends View> extends CommonTitleBarActivity implements OnHandleRefreshListener<T, V> {
    private T t;//刷新控件
    private boolean isFirstLoad = true;


    @Override
    public void setRefreshing() {
        if (t != null && weakReferenceHandler != null) {
            weakReferenceHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    t.setRefreshing();
                }
            }, 100);
        }
    }

    @Override
    public void onStopRefresh() {
        if (weakReferenceHandler != null) {
            weakReferenceHandler.sendEmptyMessage(MessageHandler.REFRESH_COMPLETE3);
            if (t != null) {
                // SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-HH:mm:ss");
                // Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
                // String time = formatter.format(curDate);
                // if (t.getCurrentMode() == Mode.PULL_FROM_START) {
                // pullFromStartLastTime = time;
                // } else if (t.getCurrentMode() == Mode.PULL_FROM_END) {
                // pullFromEndLastTime = time;
                // }
                t.getLoadingLayoutProxy().setLastUpdatedLabel(t.getContext().getResources().getString(R.string.refreshing_waiting));
                t.onRefreshComplete();
            }
        }
    }


    @Override
    public boolean isPullDownRefresh() {
        return (t != null ? t.getCurrentMode() : PullToRefreshBase.Mode.PULL_FROM_START) == PullToRefreshBase.Mode.PULL_FROM_START;// onLoadRefreshView == null ? true : onLoadRefreshView.isPullDownRefresh();
    }

    @Override
    public boolean isFirstLoad() {
        return isFirstLoad;// onLoadRefreshView == null ? true : onLoadRefreshView.isFirstLoad();
    }

    @Override
    public void setIsFirstLoad(boolean isFirstLoad) {
        this.isFirstLoad = isFirstLoad;
        // if (onLoadRefreshView != null) {
        // onLoadRefreshView.setIsFirstLoad(isFirstLoad);
        // }
    }

    @Override
    public T getPullView() {
        return t;// onLoadRefreshView != null ? onLoadRefreshView.getPullView() : null;
    }

    @Override
    public V getRefreshView() {
        return t != null ? t.getRefreshableView() : null;
    }

    @Override
    public void setRefreshMode(PullToRefreshBase.Mode mode) {
        if (t != null) {
            t.setMode(mode);
        }
    }


    protected void setRefreshView(T t) {
        // if (onLoadRefreshView == null) {
        // onLoadRefreshView = ImplOnLoadRefreshView.LoadRefreshView(t, this);
        // }
        this.t = t;
    }

}
