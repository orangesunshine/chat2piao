package com.orange.chat2piao.base.demo.activity;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.demo.response.PullDemoData;
import com.orange.chat2piao.base.mvp.model.net.RetrofitUrlApi;
import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;
import com.orange.chat2piao.base.mvp.view.activity.PullNetActivity;
import com.orange.chat2piao.thirdParty.smartfreshlayout.SmartPull;
import com.orange.chat2piao.ui.recyclerview.IConvertRecyclerView;
import com.orange.chat2piao.ui.recyclerview.RecyclerViewHolder;
import com.orange.chat2piao.utils.NetUtils;

import java.lang.reflect.Type;
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

    @Override
    public void buildHeaderNdFooter() {
        SmartPull smartPull = new SmartPull(this, android.R.layout.activity_list_item, mHolder, new IPageNetRequest<PullDemoData>() {
            @Override
            public void request(int pageIndex, Type type, INetCallback<PullDemoData> callback) {
                HashMap<String, String> params = new HashMap<>();
                params.put("count", "10");
                params.put("pageIndex", String.valueOf(pageIndex));
//                RetrofitUrlApi.getInstance().postPull("http://172.168.70.200:8080/ifc/pull", params, callback);
                RetrofitUrlApi.getInstance().postPull("http://192.168.254.103:8080/ifc/pull", params, type, callback);
            }
        }, new IConvertRecyclerView<String>() {
            @Override
            public void convert(RecyclerViewHolder holder, String s, boolean selected) {
                holder.setText(android.R.id.text1, s);
            }
        });
        smartPull.refresh();
    }
}
