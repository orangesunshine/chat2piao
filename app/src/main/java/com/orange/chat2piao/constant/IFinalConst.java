package com.orange.chat2piao.constant;

import android.widget.Toast;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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

    //换行符
    String LINE_SEPARATOR = System.getProperty("line.separator");

    //刷新|加载
    int TYPE_REFRESH = 0x001;
    int TYPE_LOADMORE = 0x002;
    @IntDef({TYPE_REFRESH, TYPE_LOADMORE})
    @Retention(RetentionPolicy.SOURCE)
    @interface PullType {
    }
}
