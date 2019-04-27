package com.orange.chat2piao.abstractor.ifc.act;

import android.os.Bundle;

public interface ICommonAct {
    //初始化变量
    void initVars(Bundle saveInstance);

    //绑定控件
    void bindViews();
}
