package com.orange.chat2piao.abstractor.ifc.act;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import butterknife.Unbinder;

public interface IDialogBindView {
    //绑定控件
    void bindViews(Dialog dialog);
}
