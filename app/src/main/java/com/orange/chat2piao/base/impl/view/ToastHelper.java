package com.orange.chat2piao.base.impl.view;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.orange.chat2piao.base.constant.IConst;
import com.orange.chat2piao.base.ifc.view.ifc.IToast;
import com.orange.chat2piao.base.impl.globle.GlobleImp;

public class ToastHelper implements IToast {
    private static final ToastHelper ourInstance = new ToastHelper();

    private Toast mToast;
    private Context mContext;
    private Handler mHandler = new Handler();
    private Runnable cancelToast = new Runnable() {
        public void run() {
            if (null == mToast) return;
            mToast.cancel();
        }
    };

    public static ToastHelper getInstance() {
        return ourInstance;
    }

    private ToastHelper() {
        mContext = GlobleImp.getInstance().getAppContext();
    }

    @Override
    public void showToast(String msg) {
        showToast(msg, IConst.DURATION_TOAST_DEFAULT);
    }

    @Override
    public void showToast(int stringId) {
        showToast(mContext.getString(stringId));
    }

    @Override
    public void showToast(String msg, int duration) {
        if (mContext == null) throw new NullPointerException("Context not be null !");
        mHandler.removeCallbacks(cancelToast);
        if (null == mToast) {
            mToast = Toast.makeText(mContext, msg, duration);
        } else {
            mToast.setText(msg);
        }
        mHandler.postDelayed(cancelToast, duration);

        mToast.show();
    }
}
