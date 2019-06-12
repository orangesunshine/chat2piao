package com.orange.chat2piao.base.demo.activity;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.mvp.model.net.RetrofitUrlApi;
import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.view.activity.PullNetActivity;

import java.util.HashMap;

public class PullDemoActivity extends PullNetActivity {

    /**
     * 获取contentLayout
     *
     * @return
     */
    @Override
    public int getContentLayoutId() {
        return R.layout.activity_demo_pull;
    }

    /**
     * 请求参数curPage网络
     *
     * @param pageIndex
     * @param callback
     */
    @Override
    public void request(int pageIndex, INetCallback callback) {
        HashMap<String, String> params = new HashMap<>();
        params.put("count", "10");
        params.put("pageIndex", String.valueOf(pageIndex));
        RetrofitUrlApi.getInstance().post("http://192.168.254.103:8080/ifc/pull", params, callback);
    }
}
