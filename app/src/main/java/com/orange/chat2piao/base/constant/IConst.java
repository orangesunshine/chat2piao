package com.orange.chat2piao.base.constant;

import android.graphics.Point;
import android.widget.Toast;

public class IConst {
    public static Point sScreenPoint = null;//全局屏幕尺寸
    public final static String FRAGMENT_LOADING_DIALOG = "fragment_loading_dialog";//loadingDilog TAG

    //activity类型:base,buz,net,pullndloadmore
    public final static int ACTIVITY_TYPE_BASE = 0x0001;
    public final static int ACTIVITY_TYPE_BUZ = 0x0002;
    public final static int ACTIVITY_TYPE_NET = 0x0003;
    public final static int ACTIVITY_TYPE_PULLNDLOADMORE = 0x0004;

    //duration
    public static final int DURATION_TOAST_DEFAULT = Toast.LENGTH_SHORT;
}
