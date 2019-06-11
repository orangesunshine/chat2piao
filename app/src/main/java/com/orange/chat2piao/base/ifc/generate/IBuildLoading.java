package com.orange.chat2piao.base.ifc.generate;

import com.orange.chat2piao.base.ifc.call.ILoading;
import com.orange.chat2piao.base.ifc.component.ILoadingDialogFragment;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

public interface IBuildLoading {
    ILoading buildLoading(BaseActivity activity, ILoadingDialogFragment fragment);
}
