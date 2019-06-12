package com.orange.chat2piao.base.demo.presenter;

import com.orange.chat2piao.base.mvp.presenter.BasePresenter;
import com.orange.chat2piao.base.mvp.view.IView;

public class PullDemoPresenter extends BasePresenter<IView> {
    @Override
    public void attachView(IView view) {
        super.attachView(view);
    }

    /**
     * 请求参数curPage网络
     *
     * @param curPage
     * @param callback
     */
//    @Override
//    public void reqeust(int curPage, INetCallback<BetRecordSearch> callback) {
//        Map<String, String> params = new HashMap<>();
//        params.put("gametype", "-1");
//        params.put("pageSize", String.valueOf(curPage));
//        params.put("state", "-1");
//        params.put("betdt_begin", "12");
//        params.put("bettype", "-1");
//        params.put("state2", "-1");
//        params.put("playtype", "-1");
//        params.put("ccPage", "-1");
//        RetrofitPrefixSuffixApi.getInstance().post("betRecord", "search.mvc", params, mPullNetCallback, data -> {
//            if (null != data) {
//                BetRecordPage page = data.PAGE;
//                if (null != page) {
//                    return page.count < IFinalConst.PULL_ITEM_COUNT;
//                }
//            }
//            return true;
//        });
//    }
}
