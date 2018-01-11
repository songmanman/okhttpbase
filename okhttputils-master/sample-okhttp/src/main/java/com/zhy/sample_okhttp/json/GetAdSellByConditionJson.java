package com.zhy.sample_okhttp.json;

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

public class GetAdSellByConditionJson extends CommonDataJson <GetAdSellByConditionJson.GetAdSellByConditionData>{

    public class GetAdSellByConditionData{
        private List<GetAdSellByConditionModel> dataList;
        private int count;

        public List<GetAdSellByConditionModel> getDataList() {
            return dataList;
        }

        public void setDataList(List<GetAdSellByConditionModel> dataList) {
            this.dataList = dataList;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

}
