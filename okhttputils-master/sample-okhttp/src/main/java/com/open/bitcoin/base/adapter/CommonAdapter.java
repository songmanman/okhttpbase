package com.open.bitcoin.base.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

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

public abstract class CommonAdapter<T>  extends BaseAdapter{
    private List<T> list = new ArrayList<T>();
    private Context mContext;

    public CommonAdapter(List<T> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = createHolder(position, parent);
            convertView = holder.itemView;
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        bindData(position, holder, getItem(position));
        return convertView;
    }

    public abstract ViewHolder createHolder(int position, ViewGroup parent);

    public abstract void bindData(int position, ViewHolder holder, T data);


    public Context getContext() {
        return mContext;
    }
}
