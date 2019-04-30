package com.orange.chat2piao.ui.dialog;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.orange.chat2piao.R;
import com.orange.chat2piao.abstractor.ifc.ILoadingDialogFragment;
import com.orange.chat2piao.abstractor.ifc.constant.IConst;
import com.orange.chat2piao.ui.dialog.base.BaseDialog;
import com.orange.chat2piao.ui.dialog.base.ViewHolder;

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
            show(manager, IConst.FRAGMENT_LOADING_DIALOG);
    }

    @Override
    public void dismissLoading() {
        if (null != mActivity && mActivity.isFinishing())
            super.dismissAllowingStateLoss();
    }
}
