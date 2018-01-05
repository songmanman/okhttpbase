package com.open.bitcoin.base.fragment;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.open.bitcoin.base.MessageHandler;

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

public abstract class BaseFragment<F extends BaseFragment>  extends Fragment{
    public WeakReferenceHandler weakReferenceHandler;
    public boolean isVisibleToUser;

    /***
     * 设置布局layoutid
     * @return
     */
    public abstract int getLayoutResId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(getLayoutResId(), container, false);
        findView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initValues();
        bindEvent();
    }

    public void setFragment(F f) {
        weakReferenceHandler = new WeakReferenceHandler(f);
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        initUI(isVisibleToUser);
    }

    private boolean isFirst = true;
    protected void initUI(final boolean isVisibleToUser) {
        if (weakReferenceHandler != null) {
            weakReferenceHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (getActivity() == null || !isVisibleToUser) {
                        initUI(isVisibleToUser);
                    } else {
                        if(isFirst){
                            weakReferenceHandler.sendEmptyMessageDelayed(MessageHandler.MESSAGE_HANDLER, 50);
                            isFirst = false;
                        }else{
                            weakReferenceHandler.sendEmptyMessageDelayed(MessageHandler.MESSAGE_DEFAULT_POSITION, 50);
                        }

                    }
                }
            }, 200);
        }
    }

    /**
     * weak 处理消息
     * @param msg
     */
    public void handlerMessage(Message msg){

    }

    /***
     * onCreateView
     */
    public void findView(){

    }

    /***
     *
     */
    public void initValues(){

    }

    /**
     *  绑定事件，在onActivityCreated调用
     */
    public void bindEvent(){

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (weakReferenceHandler!=null){
            weakReferenceHandler.removeCallbacksAndMessages(-1);
            weakReferenceHandler = null;
        }
    }
}
