package com.orange.chat2piao.abstractor.ifc.act;

import android.content.Context;
import android.os.Bundle;

import butterknife.Unbinder;

public interface ICommonAct {
    //初始化变量
    void initVars(Bundle saveInstance);

    //绑定控件
    Unbinder bindViews(Context activity);
}
