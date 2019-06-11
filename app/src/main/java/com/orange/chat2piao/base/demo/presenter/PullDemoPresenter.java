package com.orange.chat2piao.base.demo.presenter;

import com.orange.chat2piao.base.constant.IFinalConst;
import com.orange.chat2piao.base.demo.response.BetRecordPage;
import com.orange.chat2piao.base.demo.response.BetRecordSearch;
import com.orange.chat2piao.base.ifc.callback.IPullNetCallback;
import com.orange.chat2piao.base.ifc.view.IPullView;
import com.orange.chat2piao.base.impl.net.RetrofitPrefixSuffixApi;
import com.orange.chat2piao.base.impl.presenter.PullNetPresenter;

import java.util.HashMap;
import java.util.Map;

public class PullDemoPresenter extends PullNetPresenter<IPullView, BetRecordSearch> {
    /**
     * 请求参数curPage网络
     *
     * @param curPage
     * @param callback
     */
    @Override
    public void reqeust(int curPage, IPullNetCallback<BetRecordSearch> callback) {
        Map<String, String> params = new HashMap<>();
        params.put("gametype", "-1");
        params.put("pageSize", String.valueOf(curPage));
        params.put("state", "-1");
        params.put("betdt_begin", "12");
        params.put("bettype", "-1");
        params.put("state2", "-1");
        params.put("playtype", "-1");
        params.put("ccPage", "-1");
        RetrofitPrefixSuffixApi.getInstance().post("betRecord", "search.mvc", params, mPullNetCallback, data -> {
            if (null != data) {
                BetRecordPage page = data.PAGE;
                if (null != page) {
                    return page.count < IFinalConst.PULL_ITEM_COUNT;
                }
            }
            return true;
        });
    }
}
