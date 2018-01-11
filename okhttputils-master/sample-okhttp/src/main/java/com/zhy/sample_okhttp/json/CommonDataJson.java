package com.zhy.sample_okhttp.json;

import java.io.Serializable;

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

public class CommonDataJson<T> implements Serializable{
    private int result;//:"200",
    private String msg;//"Success",
    private T data;


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
