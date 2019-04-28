package com.orange.chat2piao.abstractor.impl.wrapper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.orange.chat2piao.abstractor.adapter.WrapperAdater;
import com.orange.chat2piao.abstractor.ifc.act.IBaseAct;
import com.orange.chat2piao.abstractor.ifc.act.IBuzAct;
import com.orange.chat2piao.abstractor.ifc.wrapper.IWrapper;
import com.orange.chat2piao.ui.activity.base.BaseActivity;
import com.orange.chat2piao.ui.activity.base.BuzActivity;
import com.orange.chat2piao.ui.activity.base.CommonActivity;

import static com.orange.chat2piao.abstractor.ifc.constant.IConst.ACT_BUZ;
import static com.orange.chat2piao.abstractor.ifc.constant.IConst.ACT_COMMON;

public class BaseWrapper extends WrapperAdater<IBaseAct, Activity> {

    public BaseWrapper(Activity arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.setStatusBarTranslucent(getArg());
        }
    }

    public void onCreateLifecycleWrapper(Activity activity, Bundle bundle) {
        String simpleName = CommonActivity.class.getSimpleName();
        IWrapper wrapper = new BaseWrapper(activity);
        if (activity instanceof CommonActivity) {
            //commonWrapper->initVars、bindViews
            wrapper.wrap(new CommonWrapper(activity).setBundle(bundle));
        } else if (activity instanceof BuzActivity) {
            //commonWrapper->initVars、bindViews
            wrapper.wrap(new CommonWrapper(activity).setBundle(bundle));
            //BuzActivity->initViews、initListener、onActivityCreate
            wrapper.wrap(new BuzWrapper(activity).setIfc(new IBuzAct() {
                @Override
                public void initViews(Context context) {

                }

                @Override
                public void initListener(Context context) {

                }

                @Override
                public void onActivityCreate(Context context) {

                }
            }));
        }
        ((BaseActivity) activity).setWrapper(wrapper);
        wrapper.perform();
    }
}
