package com.orange.chat2piao.constant;

import android.widget.Toast;

public interface IFinalConst {
    String sBaseUrl = "";
    String FRAGMENT_LOADING_DIALOG = "fragment_loading_dialog";//loadingDilog TAG

    //activity类型:base,buz,net,pullndloadmore
    int ACTIVITY_TYPE_BASE = 0x0001;
    int ACTIVITY_TYPE_BUZ = 0x0002;
    int ACTIVITY_TYPE_NET = 0x0003;
    int ACTIVITY_TYPE_PULLNDLOADMORE = 0x0004;

    //duration
    int DURATION_TOAST_DEFAULT = Toast.LENGTH_SHORT;

    //网络请求类型
    int REQUEST_BY_GET = 0x001;
    int REQUEST_BY_POST = 0x002;

    //网络请求结果code
    int CODE_SUCCESS = 200;
    int CODE_ERROR = -1;

    //pull每次请求数据条数
    int PULL_ITEM_COUNT = 10;
}
