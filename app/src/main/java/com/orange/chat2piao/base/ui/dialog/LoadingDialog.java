package com.orange.chat2piao.base.ui.dialog;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.constant.IFinalConst;
import com.orange.chat2piao.base.constant.IInitConst;
import com.orange.chat2piao.base.ifc.view.ifc.ILoadingDialogFragment;
import com.orange.chat2piao.base.ui.dialog.base.BaseDialog;
import com.orange.chat2piao.base.ui.dialog.base.ViewHolder;

import androidx.fragment.app.FragmentManager;

public class LoadingDialog extends BaseDialog implements ILoadingDialogFragment {
    @Override
    public void convertView(ViewHolder holder, BaseDialog dialog) {

    }

    @Override
    public int getContentLayoutId() {
        return R.layout.dialog_loading;
    }

    @Override
    public void showLoading(FragmentManager manager) {
        if (null != manager)
            show(manager, IFinalConst.FRAGMENT_LOADING_DIALOG);
    }

    @Override
    public void dismissLoading() {
        if (null != mActivity && mActivity.isFinishing())
            super.dismissAllowingStateLoss();
    }
}
