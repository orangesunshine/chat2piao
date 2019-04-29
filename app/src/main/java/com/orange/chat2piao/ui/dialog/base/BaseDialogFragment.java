package com.orange.chat2piao.ui.dialog.base;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.githang.statusbar.StatusBarCompat;
import com.orange.chat2piao.R;
import com.orange.chat2piao.abstractor.ifc.act.IBaseAct;

public abstract class BaseDialogFragment extends DialogFragment implements IBaseAct {
    private View mRoot;

    @Override
    public void setStatusBarTranslucent(Activity activity) {
        StatusBarCompat.setTranslucent(activity.getWindow(), true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DialogFragment.STYLE_NO_FRAME 没有边框，
        //R.style.dialogTheme 主要就是设置对话框内容区域外的背景色
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.dialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == mRoot) {
            mRoot = inflater.inflate(getContentLayoutId(), container);
        }
        return mRoot;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (null == dialog) return;

        //如果宽高都为MATCH_PARENT,内容外的背景色就会失效，所以只设置宽全屏
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setLayout(width, height);//全屏
        dialog.getWindow().setGravity(Gravity.BOTTOM);//内容设置在底部
        //内容的背景色.对于全屏很重要，系统的内容宽度是不全屏的，替换为自己的后宽度可以全屏
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void setGravity(int gravity) {
        Dialog dialog = getDialog();
        if (null == dialog) return;
        dialog.getWindow().setGravity(gravity);//内容设置在底部
    }


}

