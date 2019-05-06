package com.orange.chat2piao.base.ifc.view.ifc;

import androidx.fragment.app.FragmentManager;

public interface ILoadingDialogFragment {
    void showLoading(FragmentManager manager);

    void dismissLoading();
}
