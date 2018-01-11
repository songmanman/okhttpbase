package com.open.bitcoin.base.activity;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :Administrator
 * @createTime: 2018/1/5
 * @version:1.0.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: ****************************************************************************************************************************************************************************
 */

public abstract class BaseActivity<BA extends BaseActivity> extends FragmentActivity {
    public  WeakActivityReferenceHandler weakReferenceHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStackManager.getInstance().pushActivity(this);
    }

    public void setActivity(BA ba) {
        this.weakReferenceHandler = new WeakActivityReferenceHandler(ba);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStackManager.getInstance().popActivity(this);
        if (weakReferenceHandler!=null){
            weakReferenceHandler.removeCallbacksAndMessages(null);
            weakReferenceHandler = null;
        }
    }


    /**
     * weak 处理消息
     * @param msg
     */
    public void handlerMessage(Message msg){

    }
}
