package com.orange.chat2piao.ui.recyclerview.popupwin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.blankj.utilcode.util.ScreenUtils;
import com.orange.chat2piao.R;
import com.orange.chat2piao.base.common.holder.DefaultHolder;
import com.orange.chat2piao.ui.recyclerview.IConvertContentView;

public class CommonPopupWindow<T> {
    protected Context mContext;
    protected View mContentView;
    protected PopupWindow mInstance;

    public CommonPopupWindow(Context context, int layoutRes, T data, IConvertContentView<T> convertViewHolder) {
        mContext = context;
        mContentView = LayoutInflater.from(context).inflate(layoutRes, null, false);
        mInstance = new PopupWindow(mContentView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        initWindow();
        if (null != convertViewHolder)
            convertViewHolder.convert(new DefaultHolder(mContentView), data);
    }

    public View getContentView() {
        return mContentView;
    }

    public PopupWindow getPopupWindow() {
        return mInstance;
    }

    public void animationStyle(int animIn, int animOut) {
        mInstance.setAnimationStyle(animIn);
    }

    protected void initWindow() {
        mInstance.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mInstance.setOutsideTouchable(true);
        mInstance.setTouchable(true);
        mInstance.setAnimationStyle(R.style.winDialogAnim);
    }

    public void showBashOfAnchor(View anchor, LayoutGravity layoutGravity, int xmerge, int ymerge) {
        int[] offset = layoutGravity.getOffset(anchor, mInstance);
        mInstance.showAsDropDown(anchor, offset[0] + xmerge, offset[1] + ymerge);
    }

    public void showAsDropDown(View anchor, int xoff, int yoff) {
        mInstance.showAsDropDown(anchor, xoff, yoff);
    }

    public void showAtLocation(View parent, int gravity, int x, int y) {
        mInstance.showAtLocation(parent, gravity, x, y);
    }

    public void showAtScreenLocation(View parent, int gravity, int x, int y) {
        showAtScreenLocation(parent, gravity, x, y, null);
    }

    public void showAtScreenLocation(View parent, int gravity, int x, int y, ShowUpCallback callback) {
        int[] windowPos = new int[2];
        boolean up = calculatePopWindowPos(parent, mContentView, windowPos);
        if (null != callback)
            callback.showUp(up);
        mInstance.showAtLocation(parent, gravity, windowPos[0] + x, windowPos[1] + y);
    }

    /**
     * 计算出来的位置，y方向就在anchorView的上面和下面对齐显示，x方向就是与屏幕右边对齐显示
     * 如果anchorView的位置有变化，就可以适当自己额外加入偏移来修正
     *
     * @param anchorView  呼出window的view
     * @param contentView window的内容布局
     * @return window显示的左上角的xOff, yOff坐标
     */
    private boolean calculatePopWindowPos(final View anchorView, final View contentView, int[] windowPos) {
        if (null == windowPos)
            windowPos = new int[2];
        final int anchorLoc[] = new int[2];
        // 获取锚点View在屏幕上的左上角坐标位置
        anchorView.getLocationOnScreen(anchorLoc);
        final int anchorHeight = anchorView.getHeight();
        // 获取屏幕的高宽
        final int screenHeight = ScreenUtils.getScreenHeight();
        final int screenWidth = ScreenUtils.getScreenWidth();
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        // 计算contentView的高宽
        final int windowHeight = contentView.getMeasuredHeight();
        final int windowWidth = contentView.getMeasuredWidth();
        // 判断需要向上弹出还是向下弹出显示
        final boolean isNeedShowUp = (screenHeight - anchorLoc[1] - anchorHeight < windowHeight);
        if (isNeedShowUp) {
            windowPos[0] = screenWidth - windowWidth;
            windowPos[1] = anchorLoc[1] - windowHeight;
        } else {
            windowPos[0] = screenWidth - windowWidth;
            windowPos[1] = anchorLoc[1] + anchorHeight;
        }
        return isNeedShowUp;
    }

    public interface ShowUpCallback {
        void showUp(boolean up);
    }
}

