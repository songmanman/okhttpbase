package com.zhy.sample_okhttp;

import android.os.Bundle;
import android.os.Message;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.open.bitcoin.base.MessageHandler;
import com.open.bitcoin.base.activity.CommonRefreshListViewActivity;
import com.zhy.sample_okhttp.adapter.AdSellByConditionAdapter;
import com.zhy.sample_okhttp.json.GetAdSellByConditionJson;
import com.zhy.sample_okhttp.json.GetAdSellByConditionModel;

import java.util.ArrayList;
import java.util.List;

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

public class AdSellByConditionPullToRefreshListViewActivitiy extends CommonRefreshListViewActivity{
    private List<GetAdSellByConditionModel> list = new ArrayList<>();
    private AdSellByConditionAdapter mAdSellByConditionAdapter = new AdSellByConditionAdapter(list,this);


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setActivity(this);
    }


    @Override
    public void initValue() {
        super.initValue();
        list.add(new GetAdSellByConditionModel());
        list.add(new GetAdSellByConditionModel());
        list.add(new GetAdSellByConditionModel());
        setAdapter(mAdSellByConditionAdapter);
        setRefreshMode(PullToRefreshBase.Mode.PULL_FROM_START);

        weakReferenceHandler.sendEmptyMessage(MessageHandler.MESSAGE_HANDLER);
    }


    @Override
    public void handlerMessage(Message msg) {
        super.handlerMessage(msg);
        switch (msg.what){
            case MessageHandler.MESSAGE_HANDLER:
                //请求接口
                break;
        }
    }
}
