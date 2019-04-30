package com.orange.chat2piao.abstractor.ifc;

import androidx.fragment.app.FragmentManager;

public interface ILoadingDialogFragment {
    void showLoading(FragmentManager manager);

    void dismissLoading();
}
