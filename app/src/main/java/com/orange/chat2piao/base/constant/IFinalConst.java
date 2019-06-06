package com.orange.chat2piao.base.constant;

import android.widget.Toast;

public interface IFinalConst {
    String FRAGMENT_LOADING_DIALOG = "fragment_loading_dialog";//loadingDilog TAG

    //activity类型:base,buz,net,pullndloadmore
    int ACTIVITY_TYPE_BASE = 0x0001;
    int ACTIVITY_TYPE_BUZ = 0x0002;
    int ACTIVITY_TYPE_NET = 0x0003;
    int ACTIVITY_TYPE_PULLNDLOADMORE = 0x0004;

    //duration
    int DURATION_TOAST_DEFAULT = Toast.LENGTH_SHORT;
}
