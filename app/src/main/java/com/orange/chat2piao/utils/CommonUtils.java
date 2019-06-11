package com.orange.chat2piao.utils;

import com.orange.chat2piao.constant.IFinalConst;

public class CommonUtils {
    /**
     * 判断网络code==200，true：成功|false：失败
     *
     * @param code
     * @return
     */
    public static boolean checkCodeSuccess(int code) {
        return IFinalConst.CODE_SUCCESS == code;
    }
}
