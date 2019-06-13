package com.orange.chat2piao.base.demo.response;

import com.orange.chat2piao.base.reponse.PullData;

import java.util.List;

public class PullDemoData extends PullData<List<String>, String> {

    /**
     * DATA转List<ITEM>
     *
     * @return
     */
    @Override
    public List<String> getList() {
        return null == data ? null : data;
    }
}
