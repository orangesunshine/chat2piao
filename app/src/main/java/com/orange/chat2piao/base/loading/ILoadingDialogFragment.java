package com.orange.chat2piao.base.loading;

import androidx.fragment.app.FragmentManager;

public interface ILoadingDialogFragment {
    /**
     * 显示loading
     * @param manager
     */
    void showLoading(FragmentManager manager);

    void dismissLoading();
}
