package com.zhy.sample_okhttp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.open.bitcoin.base.adapter.CommonAdapter;
import com.open.bitcoin.base.adapter.ViewHolder;
import com.zhy.sample_okhttp.R;
import com.zhy.sample_okhttp.json.GetAdSellByConditionJson;
import com.zhy.sample_okhttp.json.GetAdSellByConditionModel;

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

public class AdSellByConditionAdapter extends CommonAdapter<GetAdSellByConditionModel>{

    public AdSellByConditionAdapter(List<GetAdSellByConditionModel> list, Context mContext) {
        super(list, mContext);
    }

    @Override
    public ViewHolder createHolder(int position, ViewGroup parent) {
        return new AdSellByConditionHolder(LayoutInflater.from(getContext()).inflate(R.layout.adapter_ad_sell_by_condition, parent, false));
    }

    @Override
    public void bindData(int position, ViewHolder holder, GetAdSellByConditionModel data) {
        if (data!=null){

        }
    }

    public class AdSellByConditionHolder extends ViewHolder{
        public final ImageView img_logo;
        public final TextView txt_user_account,txt_ad_tradeAmount,txt_ad_price;

        public AdSellByConditionHolder(View itemView) {
            super(itemView);
            img_logo = (ImageView) itemView.findViewById(R.id.img_logo);
            txt_user_account = (TextView) itemView.findViewById(R.id.txt_user_account);
            txt_ad_tradeAmount = (TextView) itemView.findViewById(R.id.txt_ad_tradeAmount);
            txt_ad_price = (TextView) itemView.findViewById(R.id.txt_ad_price);
        }
    }
}
